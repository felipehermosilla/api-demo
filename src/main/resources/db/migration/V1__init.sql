CREATE SCHEMA IF NOT EXISTS PROFILE;

-- Esto debe existir, lo demás se crea por JPA
CREATE TABLE IF NOT EXISTS profile.users (
    id bigserial NOT NULL,
    name character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    age integer NOT NULL,
    gender character varying(12) NOT NULL,
    phone_number character varying(20),
    email character varying(20),
	country character varying(25),
	city character varying(20),
	address character varying(50),
    active boolean DEFAULT false NOT NULL
);

