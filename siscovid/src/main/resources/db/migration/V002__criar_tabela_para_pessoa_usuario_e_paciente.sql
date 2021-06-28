CREATE TABLE pessoa (
	codigo serial NOT NULL,
	identidade character varying(255),
	nome character varying(255),
	nome_guerra character varying(255),
	senha character varying(255),
	confirmacao_senha character varying(255),
	posto_graduacao character varying(255),
	tipo_paciente character varying(255),
	perfil character varying(255),
	infectado_codigo bigint,
	om_codigo bigint,
	antiguidade integer,
	
	CONSTRAINT pessoa_pkey PRIMARY KEY (codigo),
	
	CONSTRAINT om_codigo_fkey FOREIGN KEY (om_codigo)
    REFERENCES om (codigo),	
	UNIQUE (identidade)
	
);