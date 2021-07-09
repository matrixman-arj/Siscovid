package br.mil.eb.decex.siscovid.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.mil.eb.decex.siscovid.service.CadastroUsuarioService;

@Configuration
@ComponentScan(basePackageClasses = CadastroUsuarioService.class)
public class ServiceConfig {

}
