package br.mil.eb.decex.siscovid.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.Pacientes;
import br.mil.eb.decex.siscovid.repository.Pessoas;
import br.mil.eb.decex.siscovid.service.exception.IdentidadeJaCadastradaException;

@Service
public class CadastroPacienteService {
	
	@Autowired
	private Pessoas pessoas;
	
	@Autowired
	private Pacientes pacientes;
	
	@Transactional
	public Pessoa salvar(Pessoa paciente) {
		Optional<Pessoa> pessoaOptional = pacientes.findByIdentidade(paciente.getIdentidade());
		if(pessoaOptional.isPresent()) {
			throw new IdentidadeJaCadastradaException("Identidade já cadastrada!");
		}
		
		return pessoas.saveAndFlush(paciente);
	}

}
