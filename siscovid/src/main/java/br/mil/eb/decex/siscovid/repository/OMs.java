package br.mil.eb.decex.siscovid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.decex.siscovid.model.OrganizacaoMilitar;

@Repository
public interface OMs extends JpaRepository<OrganizacaoMilitar, Long>{

}
