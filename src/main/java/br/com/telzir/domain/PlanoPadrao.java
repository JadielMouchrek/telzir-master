package br.com.telzir.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PlanoPadrao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double valorMinuto;

	@OneToOne
	private Cidade origem;

	@OneToOne
	private Cidade destino;

	public PlanoPadrao(Integer id, Cidade origem, Cidade destino, Double valorMinuto) {
		super();
		this.id = id;
		this.valorMinuto = valorMinuto;
		this.origem = origem;
		this.destino = destino;
	}

	public PlanoPadrao() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanoPadrao other = (PlanoPadrao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorMinuto() {
		return valorMinuto;
	}

	public void setValorMinuto(Double valorMinuto) {
		this.valorMinuto = valorMinuto;
	}

	/*
	 * O valor total da chamada é feito apartir da quantidade de minutos
	 * multiplicado pelo valor do minuto Ao escolher um plano o usuário tem uma
	 * certa quantidade de minutos sem pagar (dependendo do plano), e o restante dos
	 * minutos terá acrécimo de 10% em cima do valor da chamada
	 */

	public Double getValorTotalChamada(Integer quantidadeMinutosChamada) {

		if (quantidadeMinutosChamada < 0) {
			return 0.0;
		}

		Double valorChamadaPadrao = this.valorMinuto;
		Double valorTotalChamada = valorChamadaPadrao * quantidadeMinutosChamada;
		return valorTotalChamada;
	}

	public Cidade getOrigem() {
		return origem;
	}

	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}

	public Cidade getDestino() {
		return destino;
	}

	public void setDestino(Cidade destino) {
		this.destino = destino;
	}

}
