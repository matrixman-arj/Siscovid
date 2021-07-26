package br.mil.eb.decex.siscovid.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.mil.eb.decex.siscovid.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.mil.eb.decex.siscovid.thymeleaf.processor.MessageElementTagProcessor;

public class SiscovidDialect extends AbstractProcessorDialect{

	public SiscovidDialect() {
		super("DECEx Siscovid", "siscovid", StandardDialect.PROCESSOR_PRECEDENCE);
		
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {	
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		return processadores;
		
	}

}
