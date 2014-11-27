-- Table: counters

-- DROP TABLE counters;

CREATE TABLE counters
(
  c_id integer NOT NULL,
  c_active boolean,
  i_description character varying(255),
  c_serial integer,
  CONSTRAINT counters_pkey PRIMARY KEY (c_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE counters
  OWNER TO invoice;

