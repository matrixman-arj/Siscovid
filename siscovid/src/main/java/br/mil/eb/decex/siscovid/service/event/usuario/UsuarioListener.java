package br.mil.eb.decex.siscovid.service.event.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.mil.eb.decex.siscovid.storage.FotoStorage;



@Component
public class UsuarioListener {
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@EventListener(condition = "#evento.temFoto()")	
	public void usuarioSalvo(UsuarioSalvoEvent evento) {
		fotoStorage.salvar(evento.getPessoa().getFoto());
		
	}

}
