package br.mil.eb.decex.siscovid.repository.helper.om;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.mil.eb.decex.siscovid.model.OrganizacaoMilitar;
import br.mil.eb.decex.siscovid.repository.filter.OMFilter;

public interface OMsQueries {
	
			
	public Page<OrganizacaoMilitar> filtrar(OMFilter filtro, Pageable pageable);

}
