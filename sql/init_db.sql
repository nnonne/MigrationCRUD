CREATE TABLE IF NOT EXISTS worker(
id IDENTITY PRIMARY KEY NOT NULL,
name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) > 1),
birthday DATE CHECK (birthday >= '1901-01-01'),
level VARCHAR NOT NULL CHECK level IN ('Trainee', 'Junior', 'Middle', 'Senior'),
salary INTEGER CHECK (salary <= 100000 AND salary >= 100)
);

CREATE TABLE IF NOT EXISTS client(
id IDENTITY PRIMARY KEY NOT NULL,
name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) > 1)
);


CREATE TABLE IF NOT EXISTS project(
id IDENTITY PRIMARY KEY,
name VARCHAR(100),
client_id INTEGER NOT NULL,
start_date DATE,
finish_date DATE,
project_duration INTEGER CHECK (project_duration >= 1 AND project_duration <= 100)
);

CREATE TABLE IF NOT EXISTS project_worker(
project_id BIGINT NOT NULL,
worker_id BIGINT NOT NULL,
PRIMARY KEY(project_id, worker_id),
FOREIGN KEY(project_id) REFERENCES project(id),
FOREIGN KEY(worker_id) REFERENCES worker(id)
);