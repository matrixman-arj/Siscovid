package br.mil.eb.decex.siscovid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.decex.siscovid.model.UnidadeMilitarSaude;

@Repository
public interface UMSs extends JpaRepository<UnidadeMilitarSaude, Long>{
	
	public Optional<UnidadeMilitarSaude> findBySigla(String sigla);

}
