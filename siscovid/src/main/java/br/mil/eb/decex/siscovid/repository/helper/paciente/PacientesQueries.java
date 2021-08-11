package br.mil.eb.decex.siscovid.repository.helper.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.filter.PacienteFilter;

public interface PacientesQueries {
	
			
	public Page<Pessoa> filtrar(PacienteFilter filtro, Pageable pageable);

}
