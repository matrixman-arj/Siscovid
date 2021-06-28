-- Table: public.om

-- DROP TABLE public.om;

CREATE TABLE om

(
    codigo serial NOT NULL,
    descricao character varying(255),
    sigla character varying(255),
    om_pai_codigo bigint,
    secao bigint,
    ordem integer,   
    
    CONSTRAINT om_pkey PRIMARY KEY (codigo),
    
    CONSTRAINT om_om_pai_codigo_fkey FOREIGN KEY (om_pai_codigo)
    REFERENCES om (codigo)
   
);
