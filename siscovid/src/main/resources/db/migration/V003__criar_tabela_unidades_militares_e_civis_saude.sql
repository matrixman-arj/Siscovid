-- Table: public.om

-- DROP TABLE public.om;

CREATE TABLE ums

(
    codigo serial NOT NULL,
    descricao character varying(255),
    sigla character varying(255),
    endereco character varying(255),    
    ordem integer,   
    
    CONSTRAINT ums_pkey PRIMARY KEY (codigo)
       
);

-- Table: public.om

-- DROP TABLE public.om;

CREATE TABLE ucs

(
    codigo serial NOT NULL,
    descricao character varying(255),
    sigla character varying(255),
    endereco character varying(255),    
    ordem integer,   
    
    CONSTRAINT ucs_pkey PRIMARY KEY (codigo)
       
);
