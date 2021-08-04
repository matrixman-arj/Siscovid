package br.mil.eb.decex.siscovid.repository.helper.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.filter.UsuarioFilter;

public interface UsuariosQueries {
	
			
	public Page<Pessoa> filtrar(UsuarioFilter filtro, Pageable pageable);

}
