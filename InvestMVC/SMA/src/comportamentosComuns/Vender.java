package comportamentosComuns;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Vender extends CyclicBehaviour {
	private static final long serialVersionUID = -6907071223712349071L;

	@Override
	public void action() {
		ACLMessage msg = myAgent.receive();
		if(msg !=null){
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("O mercado está subindo");
			System.out.println("Hora de Vender");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		}
		else block();
	}
}
