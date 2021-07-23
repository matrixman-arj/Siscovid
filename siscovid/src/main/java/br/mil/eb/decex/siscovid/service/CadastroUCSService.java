package br.mil.eb.decex.siscovid.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.decex.siscovid.model.UnidadeCivilSaude;
import br.mil.eb.decex.siscovid.repository.UCSs;
import br.mil.eb.decex.siscovid.service.exception.UCSJaCadastradaException;

@Service
public class CadastroUCSService {
	
	@Autowired
	private UCSs ucss;
	
	@Transactional
	public UnidadeCivilSaude salvar(UnidadeCivilSaude ucs) {
		Optional<UnidadeCivilSaude> ucsOptional = ucss.findBySigla(ucs.getSigla());
		if(ucsOptional.isPresent()) {
			throw new UCSJaCadastradaException("Unidade Civil de Saúde já cadastrada!");
		}
		
		return ucss.saveAndFlush(ucs);
	}

}
