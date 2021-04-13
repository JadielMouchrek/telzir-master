package br.com.telzir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.telzir.domain.PlanoPadrao;

@Repository
public interface PlanoPadraoRepository extends JpaRepository<PlanoPadrao, Integer> {

	@Query(value = "SELECT * FROM PLANO_PADRAO c WHERE c.ORIGEM_ID = :idOrigem and c.DESTINO_ID = :idDestino", nativeQuery = true)
	PlanoPadrao findByIdOrigemAndIdDestino(@Param("idOrigem") Integer idOrigem,
			@Param("idDestino") Integer idDestino);

}
