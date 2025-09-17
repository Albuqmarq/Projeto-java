INSERT INTO roles (name) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

-- senha = 123456 (bcrypt)
INSERT INTO users (username, password, enabled)
VALUES ('admin', '$2a$10$Dow1RYo63eNbUsVTNff7k.JXc3tuUm9tYcgnCWR5hBp3VvDhKsb2S', true);

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);