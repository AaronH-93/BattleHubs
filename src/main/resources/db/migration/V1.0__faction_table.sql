CREATE TABLE IF NOT EXISTS faction (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR NOT NULL
);
