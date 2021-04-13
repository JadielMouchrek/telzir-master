package br.com.telzir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.telzir.domain.Cidade;
import br.com.telzir.domain.PlanoMaisCentoEVinte;
import br.com.telzir.domain.PlanoMaisSessenta;
import br.com.telzir.domain.PlanoMaisTrinta;
import br.com.telzir.domain.PlanoPadrao;
import br.com.telzir.domain.TipoPlano;
import br.com.telzir.dto.FormularioDTO;
import br.com.telzir.repository.CidadeRepository;
import br.com.telzir.repository.TipoPlanoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PlanoService {

	@Autowired
	CidadeService cidadeService;
	
	@Autowired 
	TipoPlanoRepository tipoPlanoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private PlanoPadraoService chamadaPadraoService;

	public Double calcularValoresFormulario(FormularioDTO formulario) {

		Double valorComPlano = 0.0;

		Cidade origem = cidadeRepository.findByDDD(formulario.getDddOrigem());
		Cidade destino = cidadeRepository.findByDDD(formulario.getDddDestino());

		PlanoPadrao chamadaPadrao = chamadaPadraoService.findChamadaPadrao(origem.getId(), destino.getId());

		if (chamadaPadrao == null) {
			chamadaPadrao = new PlanoPadrao(null, origem, destino, 0.0);
		}

		switch (formulario.getPlano()) {
		case "FaleMais 30":
			PlanoMaisTrinta planotrinta = new PlanoMaisTrinta(chamadaPadrao.getOrigem(), chamadaPadrao.getDestino(),
					formulario.getTempoMinutos());
			planotrinta.setValorMinuto(chamadaPadrao.getValorMinuto());
			valorComPlano = planotrinta.getValorTotalChamada(formulario.getTempoMinutos());
			break;
		case "FaleMais 60":
			PlanoMaisSessenta planosessenta = new PlanoMaisSessenta(chamadaPadrao.getOrigem(),
					chamadaPadrao.getDestino(), formulario.getTempoMinutos());
			planosessenta.setValorMinuto(chamadaPadrao.getValorMinuto());
			valorComPlano = planosessenta.getValorTotalChamada(formulario.getTempoMinutos());
			break;
		case "FaleMais 120":
			PlanoMaisCentoEVinte planocentoevinte = new PlanoMaisCentoEVinte(chamadaPadrao.getOrigem(),
					chamadaPadrao.getDestino(), formulario.getTempoMinutos());
			planocentoevinte.setValorMinuto(chamadaPadrao.getValorMinuto());
			valorComPlano = planocentoevinte.getValorTotalChamada(formulario.getTempoMinutos());
			break;
		default:
			valorComPlano = chamadaPadrao.getValorTotalChamada(formulario.getTempoMinutos());
			break;
		}

		return valorComPlano;
	}
	
	public List<TipoPlano> findPlanos(){
		return tipoPlanoRepository.findAll();
	}
	
	public FormularioDTO montarFormulario() throws ObjectNotFoundException {
		List<Cidade> cidadesDisponiveis = cidadeService.findCidades();
		List<TipoPlano> planos = tipoPlanoRepository.findAll();
		return new FormularioDTO(cidadesDisponiveis, planos);
	}

}
