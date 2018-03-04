COMMENT ON TABLE PROFILE.USERS IS 'Tabla que almacena los datos del usuario';

-- Default system user
insert into PROFILE.USERS (id, name, lastname, age, gender, phone_number, email, country, city, address, active) values
(1, 'Martín', 'Santander', 29, 'MALE', '0961222999','ms@gmail.com', 'Paraguay', 'Asunción', 'Avda. Mcal. Lopez casi San Martín', true);

insert into PROFILE.USERS (id, name, lastname, age, gender, phone_number, email, country, city, address, active) values
(2, 'Violeta', 'Ramirez', 26, 'FEMALE', '0981333000','vr@gmail.com', 'Paraguay', 'Asunción', 'Avda. España casi Sacramento', true);

insert into PROFILE.USERS (id, name, lastname, age, gender, phone_number, email, country, city, address, active) values
(3, 'Alfredo', 'Hernandez', 33, 'MALE', '0971888666','ah@gmail.com', 'Paraguay', 'Asunción', 'Lillo 2212', true);

insert into PROFILE.USERS (id, name, lastname, age, gender, phone_number, email, country, city, address, active) values
(4, 'Jose', 'Gomez', 23, 'MALE', '','jg@gmail.com', 'Argentina', 'Formosa', 'No registrado', true);

insert into PROFILE.USERS (id, name, lastname, age, gender, phone_number, email, country, city, address, active) values
(5, 'Nathalia', 'Gimenez', 31, 'FEMALE', '','ng@gmail.com', 'Argentina', 'Buenos Aires', 'No registrado', true);



