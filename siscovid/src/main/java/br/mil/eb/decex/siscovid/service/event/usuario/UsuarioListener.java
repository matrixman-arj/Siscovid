package br.mil.eb.decex.siscovid.service.event.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.mil.eb.decex.siscovid.storage.FotoStorage;



@Component
public class UsuarioListener {
	
	@Autowired
	private FotoStorage fotoStorage;
	
//	@EventListener(condition = "#evento.temFoto() and #evento.novaFoto")
	@EventListener
	public void usuarioSalvo(UsuarioSalvoEvent evento) {
		System.out.println("Novo usuario salvo: " + evento.getPessoa().getNomeGuerra() );
//		fotoStorage.salvarTemporariamente(evento.getPessoa().getFoto());

		

	}

}
