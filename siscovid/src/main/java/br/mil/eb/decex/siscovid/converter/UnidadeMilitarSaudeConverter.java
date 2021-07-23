package br.mil.eb.decex.siscovid.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.mil.eb.decex.siscovid.model.UnidadeMilitarSaude;

public class UnidadeMilitarSaudeConverter implements Converter<String, UnidadeMilitarSaude> {

	@Override
	public UnidadeMilitarSaude convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			UnidadeMilitarSaude ums = new UnidadeMilitarSaude();
			ums.setCodigo(Long.valueOf(codigo));
			return ums;
		}
		
		return null;
	}

}
