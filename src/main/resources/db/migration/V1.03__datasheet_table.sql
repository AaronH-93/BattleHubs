CREATE TABLE IF NOT EXISTS datasheet (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR NOT NULL,
    type UUID NOT NULL REFERENCES unit_type (id),
    linked_codex_id UUID NOT NULL REFERENCES codex (id),
    linked_faction_id UUID NOT NULL REFERENCES faction (id)
);
