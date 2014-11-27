-- Table: counter_status

-- DROP TABLE counter_status;

CREATE TABLE counter_status
(
  cs_id integer NOT NULL,
  cs_amount double precision,
  cs_read_date timestamp without time zone,
  c_id integer,
  csr_id integer,
  CONSTRAINT counter_status_pkey PRIMARY KEY (cs_id),
  CONSTRAINT fk_i5l1t8tyh1irml3hx3exso9qb FOREIGN KEY (csr_id)
      REFERENCES counter_statuses_reads (csr_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_oe4wa50uv841gterg1txq0627 FOREIGN KEY (c_id)
      REFERENCES counters (c_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE counter_status
  OWNER TO invoice;

