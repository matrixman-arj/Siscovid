package br.mil.eb.decex.siscovid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.decex.siscovid.model.UnidadeCivilSaude;

@Repository
public interface UCSs extends JpaRepository<UnidadeCivilSaude, Long>{
	
	public Optional<UnidadeCivilSaude> findBySigla(String sigla);

}
