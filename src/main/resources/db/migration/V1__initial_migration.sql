CREATE TABLE authors
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    name            VARCHAR(255) NOT NULL,
    birth_year  INT,
    death_year INT
);

CREATE TABLE books
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(255) NOT NULL,
    language         VARCHAR(10),
    download_count INT,
    author_id       BIGINT,
    FOREIGN KEY (author_id) REFERENCES authors (id)
);