CREATE TABLE t_member (
  id       VARCHAR2(20) NOT NULL,
  password VARCHAR2(20) NOT NULL,
  rrm      VARCHAR2(14) NOT NULL,
  name     VARCHAR2(50) NOT NULL,
  birth    DATE         NOT NULL,
  email    VARCHAR2(50) NOT NULL,
  phone    VARCHAR2(20) NOT NULL,
  
  CONSTRAINT pk_t_member PRIMARY KEY (id, rrm)
);