package br.mil.eb.decex.siscovid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.helper.paciente.PacientesQueries;

@Repository
public interface Pacientes extends JpaRepository<Pessoa, Long>, PacientesQueries {
	
	public Optional<Pessoa> findByIdentidade(String identidade);

}
