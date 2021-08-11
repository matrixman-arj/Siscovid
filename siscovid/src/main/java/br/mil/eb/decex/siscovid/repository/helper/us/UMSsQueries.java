package br.mil.eb.decex.siscovid.repository.helper.us;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.mil.eb.decex.siscovid.model.UnidadeMilitarSaude;
import br.mil.eb.decex.siscovid.repository.filter.UMSFilter;

public interface UMSsQueries {
	
			
	public Page<UnidadeMilitarSaude> filtrar(UMSFilter filtro, Pageable pageable);

}
