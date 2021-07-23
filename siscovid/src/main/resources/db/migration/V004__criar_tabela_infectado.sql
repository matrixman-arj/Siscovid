CREATE TABLE infectado (
	codigo serial NOT NULL,
	pessoa_codigo bigint,
	status character varying(255),
	local_convalescenca character varying(255),
	ums_codigo bigint,
	ucs_codigo bigint,
	data_inicial date,	
	CONSTRAINT infectado_pkey PRIMARY KEY (codigo),
	
	CONSTRAINT pessoa_codigo_fkey FOREIGN KEY (pessoa_codigo)
    REFERENCES pessoa (codigo),
	
	CONSTRAINT ums_codigo_fkey FOREIGN KEY (ums_codigo)
    REFERENCES ums (codigo),
    
    CONSTRAINT ucs_codigo_fkey FOREIGN KEY (ucs_codigo)
    REFERENCES ucs (codigo)
);