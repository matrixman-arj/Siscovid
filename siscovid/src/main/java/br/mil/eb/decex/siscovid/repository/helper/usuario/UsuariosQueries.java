package br.mil.eb.decex.siscovid.repository.helper.usuario;

import java.util.List;

import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.filter.UsuarioFilter;

public interface UsuariosQueries {
	
			
	public List<Pessoa> filtrar(UsuarioFilter filtro);

}
