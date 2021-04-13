package br.com.telzir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.telzir.domain.PlanoPadrao;
import br.com.telzir.repository.PlanoPadraoRepository;
import br.com.telzir.service.exceptions.ObjectNotFoundException;

@Service
public class PlanoPadraoService {

	@Autowired
	private PlanoPadraoRepository chamadaPadraoRepository;

	public PlanoPadrao findChamadaPadrao(Integer idOrigem, Integer idDestino) {
		try {
			PlanoPadrao chamada = chamadaPadraoRepository.findByIdOrigemAndIdDestino(idOrigem, idDestino);
			return chamada;
		} catch (Exception e) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id origem: " + idOrigem + "Id destino:"
					+ idDestino + ", Tipo: " + PlanoPadrao.class.getName());
		}

	}

}
