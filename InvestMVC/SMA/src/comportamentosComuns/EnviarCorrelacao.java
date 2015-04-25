package comportamentosComuns;

import java.io.IOException;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class EnviarCorrelacao extends CyclicBehaviour {
	private static final long serialVersionUID = 7192572878341493779L;
	
	private ACLMessage resposta;
	private double correlacaoLinear;


	@Override
	public void action() {
		ACLMessage msg = myAgent.receive();
		if(msg !=null){
			resposta= msg.createReply();
			System.out.println("O agente "+msg.getSender().getName() + "está se comunicando");
			String conteudo = msg.getContent();
			
			if(conteudo.equalsIgnoreCase("Pedido de informação")){
				
				try {
					RodarComandos.rodarComandoNoTerminal("bash executaCorrelacao.sh");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					resposta.setContent(String.valueOf(LeituraArquivo.leituraCorrelacao()));
				} catch (IOException e) {
					e.printStackTrace();
				}
				myAgent.send(resposta);
			}
		}
		else block();
	}

}
