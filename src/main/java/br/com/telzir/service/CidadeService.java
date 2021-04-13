package br.com.telzir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.telzir.domain.Cidade;
import br.com.telzir.repository.CidadeRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CidadeService {
	@Autowired
	CidadeRepository cidadeRepository;

	public List<Cidade> findCidades() throws ObjectNotFoundException{
		try {
			List<Cidade> cidades =  cidadeRepository.findAll();
			return cidades;
		} catch (Exception e) {
			throw new ObjectNotFoundException("Objetos não encontrados!Tipo: " + Cidade.class.getName());
		}
	}
	
	public Cidade findCidadeByDDD(String ddd) throws ObjectNotFoundException{
		try {
			Cidade cidade = cidadeRepository.findByDDD(ddd);			
			return cidade;
		}catch (Exception e) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! DDD: " + ddd + "Tipo" +Cidade.class.getName());
		}
		
	}

}
