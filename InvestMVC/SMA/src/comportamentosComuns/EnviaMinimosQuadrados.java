package comportamentosComuns;

import java.io.IOException;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class EnviaMinimosQuadrados extends CyclicBehaviour {

	private static final long serialVersionUID = 7180922771811478672L;
	private AID[] controleDeMetodos;

	@Override
	public void action() {
		ACLMessage msg = myAgent.receive();
		ACLMessage resposta = new ACLMessage(ACLMessage.INFORM);
		if (msg != null) {
			procuraMetodosNoDF();

			try {
				RodarComandos
						.rodarComandoNoTerminal("bash executaMinimosQuadrados.sh");
			} catch (IOException e) {
				e.printStackTrace();
			}

			resposta.addReceiver(controleDeMetodos[0]); // Existe Apenas um
														// controlador

			try {
				resposta.setContent(LeituraArquivo.leituraMinimosQuadrados());
			} catch (IOException e) {
				e.printStackTrace();
			}
			myAgent.send(resposta);
		} else
			block();
	}

	public void procuraMetodosNoDF() {
		DFAgentDescription template = new DFAgentDescription();
		ServiceDescription service = new ServiceDescription();
		service.setType("Controlador");
		template.addServices(service);
		try {
			DFAgentDescription[] controladoreDoSistema = DFService.search(
					myAgent, template);
			controleDeMetodos = new AID[controladoreDoSistema.length];
			for (int i = 0; i < controladoreDoSistema.length; i++) {
				controleDeMetodos[i] = controladoreDoSistema[i].getName();
			}
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}
	}

}