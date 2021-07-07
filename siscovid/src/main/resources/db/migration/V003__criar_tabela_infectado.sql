CREATE TABLE infectado (
	codigo serial NOT NULL,
	pessoa_codigo bigint,
	status character varying(255),
	local_convalescenca character varying(255),
	data_inicial date,	
	CONSTRAINT infectado_pkey PRIMARY KEY (codigo),
	
	CONSTRAINT pessoa_codigo_fkey FOREIGN KEY (pessoa_codigo)
    REFERENCES pessoa (codigo)
	
	
);