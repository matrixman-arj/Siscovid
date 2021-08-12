package br.mil.eb.decex.siscovid.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.Pessoas;
import br.mil.eb.decex.siscovid.repository.Usuarios;
import br.mil.eb.decex.siscovid.service.event.usuario.UsuarioSalvoEvent;
import br.mil.eb.decex.siscovid.service.exception.IdentidadeJaCadastradaException;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private Pessoas pessoas;
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		Optional<Pessoa> pessoaOptional = usuarios.findByIdentidade(pessoa.getIdentidade());
		if(pessoaOptional.isPresent()) {
			throw new IdentidadeJaCadastradaException("Identidade já cadastrada!");
		}
		publisher.publishEvent(new UsuarioSalvoEvent(pessoa));
		return pessoas.saveAndFlush(pessoa);
	}

}
