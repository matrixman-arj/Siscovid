package br.mil.eb.decex.siscovid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.helper.usuario.UsuariosQueries;

@Repository
public interface Usuarios extends JpaRepository<Pessoa, Long>, UsuariosQueries {

}
