package br.mil.eb.decex.siscovid.repository.helper.us;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.mil.eb.decex.siscovid.model.UnidadeCivilSaude;
import br.mil.eb.decex.siscovid.repository.filter.UCSFilter;

public interface UCSsQueries {
	
			
	public Page<UnidadeCivilSaude> filtrar(UCSFilter filtro, Pageable pageable);

}
