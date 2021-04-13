package br.com.telzir.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.telzir.domain.Cidade;
import br.com.telzir.domain.TipoPlano;

public class FormularioDTO {

	private String dddOrigem;
	private String dddDestino;
	private String plano;
	private Integer tempoMinutos;
	public List<Cidade> cidades = new ArrayList<Cidade>();
	public List<TipoPlano> planos = new ArrayList<>();
	
	public FormularioDTO(List<Cidade> cidadesDisponiveis, List<TipoPlano>planos) {
		this.cidades = cidadesDisponiveis;
		this.planos = planos;
	}

	public FormularioDTO() {
		
	}

	public FormularioDTO(String plano, Integer tempoMinutos) {
		super();
		this.plano = plano;
		this.tempoMinutos = tempoMinutos;
	}


	public String getDddOrigem() {
		return dddOrigem;
	}

	public void setDddOrigem(String dddOrigem) {
		this.dddOrigem = dddOrigem;
	}

	public String getDddDestino() {
		return dddDestino;
	}

	public void setDddDestino(String dddDestino) {
		this.dddDestino = dddDestino;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public Integer getTempoMinutos() {
		return tempoMinutos;
	}

	public void setTempoMinutos(Integer tempoMinutos) {
		this.tempoMinutos = tempoMinutos;
	}

}
