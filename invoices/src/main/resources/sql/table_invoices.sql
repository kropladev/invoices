-- Table: invoices

-- DROP TABLE invoices;

CREATE TABLE invoices
(
  i_id integer NOT NULL,
  i_amount double precision,
  i_categ character varying(255),
  i_desc character varying(255),
  i_invdate timestamp without time zone,
  i_invid character varying(255),
  i_motime timestamp without time zone,
  i_name character varying(255),
  i_paydate timestamp without time zone,
  CONSTRAINT invoices_pkey PRIMARY KEY (i_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE invoices
  OWNER TO invoice;

  
INSERT INTO invoices(i_id, i_amount, i_categ, i_desc, i_invdate, i_invid, i_motime,i_name, i_paydate)
    VALUES (1, 0, "adsf", "edycja opisów1", "", "POLTR/ERE", "","test", "");
          
INSERT INTO invoices(i_id, i_amount, i_categ, i_desc, i_invdate, i_invid, i_motime, i_name, i_paydate)
    VALUES (2, 34.54, "adsf", "edycja opisów", "", "POLTR/ERE", "","test", "");

INSERT INTO invoices(i_id, i_amount, i_categ, i_desc, i_invdate, i_invid, i_motime,i_name, i_paydate)
    VALUES (3, 34.55, "adsf", "mąka", "", "POLTR/ERE", "","test", "");



            