package br.mil.eb.decex.siscovid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.decex.siscovid.model.OrganizacaoMilitar;

@Repository
public interface OMs extends JpaRepository<OrganizacaoMilitar, Long>{
	
	public Optional<OrganizacaoMilitar> findBySigla(String sigla);

}
