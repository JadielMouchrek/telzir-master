package br.com.telzir.domain;

public class PlanoMaisTrinta extends PlanoPadrao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlanoMaisTrinta(Cidade origem, Cidade destino, Integer qtdMinutosChamada) {
		this.setOrigem(origem);
		this.setDestino(destino);
	}

	/*
	 * O valor total da chamada é feito apartir da quantidade de minutos multiplicado pelo valor do minuto
	 * Ao escolher um plano o usuário tem uma certa quantidade de minutos sem pagar (dependendo do plano),
	 * e o restante dos minutos terá acrécimo de 10% em cima do valor da chamada
	 * */
	
	@Override
	public Double getValorTotalChamada(Integer qtdMinutosChamada) {
		if (qtdMinutosChamada < 0 || qtdMinutosChamada -30 <0) {
			return 0.0;
		}
		Integer quantidadeMinutos = qtdMinutosChamada - 30;
		Double valorChamadaPadrao = this.getValorMinuto() * quantidadeMinutos;
		Double valorTotalChamada = valorChamadaPadrao + valorChamadaPadrao * 0.1;
		return valorTotalChamada;
	}

}
