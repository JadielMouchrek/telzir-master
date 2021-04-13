package br.com.telzir;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.telzir.domain.Cidade;
import br.com.telzir.domain.PlanoPadrao;
import br.com.telzir.domain.TipoPlano;
import br.com.telzir.repository.CidadeRepository;
import br.com.telzir.repository.PlanoPadraoRepository;
import br.com.telzir.repository.TipoPlanoRepository;

@SpringBootApplication
public class TelzirTesteApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TelzirTesteApplication.class, args);
	}

	@Autowired
	PlanoPadraoRepository chamadaPadraoRepository;
	
	@Autowired 
	CidadeRepository cidadeRepository;
	

	@Autowired
	TipoPlanoRepository tipoPlanoRepository;

	/*
	 * Para prover dados iniciais para o projeto, adicionei o metodo run a ser executado na classe TelzirTesteApplication
	 * 
	 * */
	
	@Override
	public void run(String... args) throws Exception {
		
		Cidade cidade1 = new Cidade(null, "011");
		Cidade cidade2 = new Cidade(null, "016");
		Cidade cidade3 = new Cidade(null, "017");
		Cidade cidade4 = new Cidade(null, "018");
		
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3, cidade4));
				
		PlanoPadrao ChamadaPadrao1 = new PlanoPadrao(null, cidade1, cidade2, 1.90);
		PlanoPadrao ChamadaPadrao2 = new PlanoPadrao(null, cidade2, cidade1, 2.90);
		PlanoPadrao ChamadaPadrao3 = new PlanoPadrao(null, cidade1, cidade3, 1.70);
		PlanoPadrao ChamadaPadrao4 = new PlanoPadrao(null, cidade3, cidade1, 2.70);
		PlanoPadrao ChamadaPadrao5 = new PlanoPadrao(null, cidade1, cidade4, 0.90);
		PlanoPadrao ChamadaPadrao6 = new PlanoPadrao(null, cidade4, cidade1, 1.90);
		
		
		chamadaPadraoRepository.saveAll(Arrays.asList(ChamadaPadrao1, ChamadaPadrao2, ChamadaPadrao3, ChamadaPadrao4, ChamadaPadrao5, ChamadaPadrao6));		
		
		TipoPlano tipoPlano1 = new TipoPlano(null, "FaleMais 30", 30);
		TipoPlano tipoPlano2 = new TipoPlano(null, "FaleMais 60", 60);
		TipoPlano tipoPlano3 = new TipoPlano(null, "FaleMais 120", 120);
		
		tipoPlanoRepository.saveAll(Arrays.asList(tipoPlano1, tipoPlano2, tipoPlano3));
		
		
	}
	
}
