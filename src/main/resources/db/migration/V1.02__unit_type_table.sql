CREATE TABLE IF NOT EXISTS unit_type (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    type_name VARCHAR NOT NULL
);