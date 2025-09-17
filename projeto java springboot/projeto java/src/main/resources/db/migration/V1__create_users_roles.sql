CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE
);

CREATE TABLE users_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_role FOREIGN KEY(role_id) REFERENCES roles(id),
    PRIMARY KEY(user_id, role_id)
);