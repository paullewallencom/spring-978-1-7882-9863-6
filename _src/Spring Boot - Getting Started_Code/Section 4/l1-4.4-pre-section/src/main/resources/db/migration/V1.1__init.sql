create table bookmark(
  uuid binary not null,
  url VARCHAR(255),
  version int not null default 1,
  PRIMARY KEY (uuid)
)