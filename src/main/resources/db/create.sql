CREATE TABLE boardgames (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR UNIQUE NOT NULL,
    no_players INTEGER,    
    duration INTEGER,
    difficulty VARCHAR,
    category VARCHAR,
    personal_rate FLOAT,
    description VARCHAR,
    image_url VARCHAR
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);

CREATE TABLE user_games (
    user_id BIGINT NOT NULL,
    boardgame_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, boardgame_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (boardgame_id) REFERENCES boardgames(id)
);