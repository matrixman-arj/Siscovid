package br.mil.eb.decex.siscovid.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.decex.siscovid.model.UnidadeMilitarSaude;
import br.mil.eb.decex.siscovid.repository.UMSs;
import br.mil.eb.decex.siscovid.service.exception.UMSJaCadastradaException;

@Service
public class CadastroUMSService {
	
	@Autowired
	private UMSs umss;
	
	@Transactional
	public UnidadeMilitarSaude salvar(UnidadeMilitarSaude ums) {
		Optional<UnidadeMilitarSaude> umsOptional = umss.findBySigla(ums.getSigla());
		if(umsOptional.isPresent()) {
			throw new UMSJaCadastradaException("Unidade Militar de Saúde já cadastrada!");
		}
		
		return umss.saveAndFlush(ums);
	}	
	
}
