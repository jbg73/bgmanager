CREATE TABLE boardgames (
    id VARCHAR PRIMARY KEY,
    name VARCHAR UNIQUE NOT NULL,
    no_players INTEGER,    
    duration INTEGER,
    difficulty VARCHAR,
    category VARCHAR,
    personal_rate FLOAT,
    description STRING,
    image_url STRING
);