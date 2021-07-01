package br.mil.eb.decex.siscovid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.decex.siscovid.model.Pessoa;

@Repository
public interface Pessoas extends JpaRepository<Pessoa, Long> {

}
