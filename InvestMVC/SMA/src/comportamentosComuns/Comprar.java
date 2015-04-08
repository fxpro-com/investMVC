package comportamentosComuns;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Comprar extends CyclicBehaviour {
	private static final long serialVersionUID = 8117839713833938344L;

	@Override
	public void action() {
		ACLMessage msg = myAgent.receive();
		if(msg !=null){
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
			System.out.println("O mercado está Caindo");
			System.out.println("Hora de Comprar");
			System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		}
		else block();
	}

}
