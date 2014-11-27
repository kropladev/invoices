-- Table: counter_statuses_reads

-- DROP TABLE counter_statuses_reads;

CREATE TABLE counter_statuses_reads
(
  csr_id integer NOT NULL,
  csr_date timestamp without time zone,
  CONSTRAINT counter_statuses_reads_pkey PRIMARY KEY (csr_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE counter_statuses_reads
  OWNER TO invoice;

