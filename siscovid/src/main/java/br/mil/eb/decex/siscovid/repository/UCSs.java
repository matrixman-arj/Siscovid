package br.mil.eb.decex.siscovid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.decex.siscovid.model.UnidadeCivilSaude;
import br.mil.eb.decex.siscovid.repository.helper.us.UCSsQueries;

@Repository
public interface UCSs extends JpaRepository<UnidadeCivilSaude, Long>, UCSsQueries{
	
	public Optional<UnidadeCivilSaude> findBySigla(String sigla);

}
