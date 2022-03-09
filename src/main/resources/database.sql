CREATE DATABASE booking
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

REATE TABLE public.clients
(
    id serial NOT NULL,
    client_code text NOT NULL,
    name text NOT NULL,
    lastname text NOT NULL,
    age numeric NOT NULL,
    phonenumber text NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL,
    house_id numeric NOT NULL,
    discount_code text,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.clients
    OWNER to postgres;
