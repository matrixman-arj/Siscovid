package br.mil.eb.decex.siscovid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.mil.eb.decex.siscovid.service.CadastroUsuarioService;
import br.mil.eb.decex.siscovid.storage.FotoStorage;
import br.mil.eb.decex.siscovid.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = CadastroUsuarioService.class)
public class ServiceConfig {
	
	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}

}
