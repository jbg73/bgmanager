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