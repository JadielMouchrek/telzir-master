package br.com.telzir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.telzir.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

	@Query(value = "SELECT * FROM CIDADE c WHERE c.ddd = :ddd ", nativeQuery = true)
	Cidade findByDDD(@Param("ddd") String ddd);
	
}
