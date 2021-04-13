package br.com.telzir.domain;

public class PlanoMaisSessenta extends PlanoPadrao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlanoMaisSessenta(Cidade origem, Cidade destino, Integer qtdMinutosChamada) {
		this.setOrigem(origem);
		this.setDestino(destino);
	}

	@Override
	public Double getValorTotalChamada(Integer qtdMinutosChamada) {
		if(qtdMinutosChamada < 0 || qtdMinutosChamada -60<0) {
			return 0.0;
		}
		
		Integer quantidadeMinutos = qtdMinutosChamada -60;
		Double valorChamadaPadrao = this.getValorMinuto()*quantidadeMinutos; 
		Double valorTotalChamada = valorChamadaPadrao + valorChamadaPadrao*0.1;
		return valorTotalChamada;
	}

}
