INSERT INTO users (cpf, name) VALUES ('05891913739', 'Beltrano de Tal');
INSERT INTO users (cpf, name) VALUES ('16536078748', 'Fulano de Tal');
INSERT INTO users (cpf, name) VALUES ('67384572606', 'Ciclano de Tal');


INSERT INTO roles (role) VALUES ('admin');
INSERT INTO roles (role) VALUES ('supervisor');
INSERT INTO roles (role) VALUES ('usuario');

INSERT INTO `permissions` (permission, role_id) VALUES ('create', 1);
INSERT INTO `permissions` (permission, role_id) VALUES ('update', 1);
INSERT INTO `permissions` (permission, role_id) VALUES ('read', 1);
INSERT INTO `permissions` (permission, role_id) VALUES ('delete', 1);
INSERT INTO `permissions` (permission, role_id) VALUES ('c', 2);
INSERT INTO `permissions` (permission, role_id) VALUES ('r', 2);
INSERT INTO `permissions` (permission, role_id) VALUES ('u', 2);
INSERT INTO `permissions` (permission, role_id) VALUES ('show', 3);

