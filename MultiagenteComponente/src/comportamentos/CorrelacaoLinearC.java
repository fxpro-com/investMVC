package comportamentos;

import java.io.IOException;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class CorrelacaoLinearC extends TickerBehaviour{

	public CorrelacaoLinearC(Agent a, long period) {
		super(a, period);
	}

	private static final long serialVersionUID = -7263649666502523728L;

	@Override
	protected void onTick() {
		RodaComandos.terminal("./../EstruturadoComponente/correlacaoLinear");
		try {
		} catch (NumberFormatException erro) {
			erro.printStackTrace();
		}		
	}
	
}
