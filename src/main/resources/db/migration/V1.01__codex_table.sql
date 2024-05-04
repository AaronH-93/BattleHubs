CREATE TABLE IF NOT EXISTS codex (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR NOT NULL,
    faction UUID NOT NULL REFERENCES faction (id)
);
