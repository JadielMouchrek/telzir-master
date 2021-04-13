package br.com.telzir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.telzir.domain.TipoPlano;

@Repository
public interface TipoPlanoRepository extends JpaRepository<TipoPlano, Integer>{

}
