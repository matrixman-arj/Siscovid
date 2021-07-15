package br.mil.eb.decex.siscovid.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.decex.siscovid.model.OrganizacaoMilitar;
import br.mil.eb.decex.siscovid.repository.OMs;
import br.mil.eb.decex.siscovid.service.exception.OMJaCadastradaException;

@Service
public class CadastroOMService {
	
	@Autowired
	private OMs oms;
	
	@Transactional
	public void salvar(OrganizacaoMilitar om) {
		Optional<OrganizacaoMilitar> omOptional = oms.findBySigla(om.getSigla());
		if(omOptional.isPresent()) {
			throw new OMJaCadastradaException("Organização Militar já cadastrada!");
		}
		
		oms.save(om);
	}

}
