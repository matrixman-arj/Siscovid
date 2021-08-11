package br.mil.eb.decex.siscovid.service.event.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.mil.eb.decex.siscovid.storage.FotoStorage;



@Component
public class PacienteListener {
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@EventListener(condition = "#evento.temFoto()")	
	public void usuarioSalvo(PacienteSalvoEvent evento) {
		fotoStorage.salvar(evento.getPessoa().getFoto());
		
	}

}
