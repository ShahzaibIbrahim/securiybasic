CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    enabled int not null,
    PRIMARY KEY(id)
);

CREATE TABLE authorities (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  authority varchar(45) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO users VALUES (NULL, 'happy', '12345', '1');
INSERT INTO authorities VALUES (NULL, 'happy', 'write');

CREATE TABLE customer (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(45) NOT NULL,
  pwd varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO customer (email, pwd, role)
VALUES ('johndoe@example.com', '54321', 'admin');

COMMIT;