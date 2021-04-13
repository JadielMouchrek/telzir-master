package br.com.telzir;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.telzir.domain.Cidade;
import br.com.telzir.domain.PlanoPadrao;
import br.com.telzir.dto.FormularioDTO;
import br.com.telzir.repository.CidadeRepository;
import br.com.telzir.repository.PlanoPadraoRepository;
import br.com.telzir.repository.TipoPlanoRepository;
import br.com.telzir.service.CidadeService;
import br.com.telzir.service.PlanoPadraoService;
import br.com.telzir.service.PlanoService;
import javassist.tools.rmi.ObjectNotFoundException;

@SpringBootTest
class TelzirTesteApplicationTests {

	@Autowired
	CidadeService cidadeService;
	
	@Autowired
	private PlanoPadraoService chamadaPadraoService;
	
	@Autowired
	private PlanoService planoService;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private PlanoPadraoRepository chamadaRepository;
	
	@Autowired
	private TipoPlanoRepository tipoPlanoRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void cidadePersistTestes() throws ObjectNotFoundException {
		Cidade cidadeMock1 = new Cidade(null, "019");
		cidadeRepository.saveAll(Arrays.asList(cidadeMock1));

		assertEquals(cidadeMock1, cidadeService.findCidadeByDDD("019"));
	}
	
	@Test
	void chamadaPadraoBuscaTestes() {
		Cidade cidadeMock1 = new Cidade(null, "020");
		Cidade cidadeMock2 = new Cidade(null, "021");
		cidadeRepository.saveAll(Arrays.asList(cidadeMock1, cidadeMock2));
				
		PlanoPadrao chamadaPadraoMock = new PlanoPadrao(null, cidadeMock1, cidadeMock2, 1.90);
		chamadaRepository.saveAll(Arrays.asList(chamadaPadraoMock));
				
		PlanoPadrao chamadaPadrao = chamadaPadraoService.findChamadaPadrao(cidadeMock1.getId(), cidadeMock2.getId());
		
		assertEquals(chamadaPadraoMock, chamadaPadrao);
	}
	
	@Test
	void selecaoPlanoTestes() throws ObjectNotFoundException {
		FormularioDTO formularioDTO = new FormularioDTO(cidadeService.findCidades(), tipoPlanoRepository.findAll());
		formularioDTO.setDddOrigem("011");
		formularioDTO.setDddDestino("016");
		formularioDTO.setTempoMinutos(20);
		formularioDTO.setPlano("FaleMais 30");
		
		Double valorTotal = planoService.calcularValoresFormulario(formularioDTO);
		assertEquals(0.0, valorTotal);
		
		formularioDTO.setDddOrigem("011");
		formularioDTO.setDddDestino("017");
		formularioDTO.setTempoMinutos(80);
		formularioDTO.setPlano("FaleMais 60");
		
		Double valorTotal2 = planoService.calcularValoresFormulario(formularioDTO);
		assertEquals(37.40, valorTotal2);
		
		formularioDTO.setDddOrigem("018");
		formularioDTO.setDddDestino("011");
		formularioDTO.setTempoMinutos(200);
		formularioDTO.setPlano("FaleMais 120");
		
		Double valorTotal3 = planoService.calcularValoresFormulario(formularioDTO);
		assertEquals(167.2, valorTotal3);
		
		formularioDTO.setDddOrigem("018");
		formularioDTO.setDddDestino("017");
		formularioDTO.setTempoMinutos(100);
		formularioDTO.setPlano("FaleMais 30");
	
		Double valorTotal4 = planoService.calcularValoresFormulario(formularioDTO);
		assertEquals(0.0, valorTotal4);
	}

}
