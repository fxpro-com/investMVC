package metodosMatematicos;

import java.io.IOException;

import comportamentos.EsperarPedidos;
import comportamentos.LeituraArquivo;
import comportamentos.RegistrarNoDF;
import comportamentos.RodaComandos;

import jade.core.*;
import jade.domain.DFService;
import jade.domain.FIPAException;

public class CorrelacaoAgente extends Agent{

	private static final long serialVersionUID = -7919542083794177881L;
	private double correlacaoLinear;
	
	protected void setup(){
		RodaComandos.terminal("./../EstruturadoComponente/correlacaoLinear");
//		RodaComandos.terminal("./hello");
		try {
			correlacaoLinear = Double.parseDouble(LeituraArquivo.leituraCorrelacao());
		} catch (NumberFormatException erro) {
			erro.printStackTrace();
		} catch (IOException erro) {
			erro.printStackTrace();
		}
		
		addBehaviour(new RegistrarNoDF("MetodoNumerico", "CorrelacaoDePearson"));
		addBehaviour(new EsperarPedidos(correlacaoLinear));
	}
	
	//Remove o registro do agente da página amarela quando sua execução é finalizada
	protected void takeDown(){
		
		try {
			DFService.deregister(this);
			System.out.println("Agente analisador+"+getAID().getName()+"está finalizado!");
		} catch (FIPAException erro) {
			erro.printStackTrace();
		}	
	}

}