package br.mil.eb.decex.siscovid.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.mil.eb.decex.siscovid.model.UnidadeCivilSaude;

public class UnidadeCivilSaudeConverter implements Converter<String, UnidadeCivilSaude> {

	@Override
	public UnidadeCivilSaude convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			UnidadeCivilSaude ucs = new UnidadeCivilSaude();
			ucs.setCodigo(Long.valueOf(codigo));
			return ucs;
		}
		
		return null;
	}

}
