package br.mil.eb.decex.siscovid.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.mil.eb.decex.siscovid.model.Pessoa;

public class PacienteConverter implements Converter<String, Pessoa> {

	@Override
	public Pessoa convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Pessoa pessoa = new Pessoa();
			pessoa.setCodigo(Long.valueOf(codigo));
			return pessoa;
		}
		
		return null;
	}

}
