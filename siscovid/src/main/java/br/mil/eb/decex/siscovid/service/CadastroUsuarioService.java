package br.mil.eb.decex.siscovid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.Pessoas;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private Pessoas pessoas;
	
	@Transactional
	public void salvar(Pessoa pessoa) {
		pessoas.save(pessoa);
	}

}
