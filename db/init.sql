CREATE TABLE users
(
	id BIGSERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	surname TEXT NOT NULL,
	email TEXT NOT NULL,
	username TEXT NOT NULL,
	password TEXT NOT NULL,
	age INT NOT NULL,
	country TEXT NOT NULL,
	gender TEXT NOT NULL,
	created TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

COMMENT ON TABLE users IS 'Table that holds users info';
COMMENT ON COLUMN users.id IS 'Primary key';
COMMENT ON COLUMN users.name IS 'Name of user';
COMMENT ON COLUMN users.surname IS 'Surname of user';
COMMENT ON COLUMN users.email IS 'Email of user';
COMMENT ON COLUMN users.username IS 'Username of user';
COMMENT ON COLUMN users.password IS 'Password of user';
COMMENT ON COLUMN users.age IS 'Age of user';
COMMENT ON COLUMN users.country IS 'Country of user';
COMMENT ON COLUMN users.gender IS 'Gender of user';
COMMENT ON COLUMN users.created IS 'The date this user was created';


CREATE TABLE vault
(
	id BIGSERIAL PRIMARY KEY,
	users_id BIGSERIAL,
	created TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
	CONSTRAINT fk_users FOREIGN KEY(users_id) REFERENCES users(id)
);

COMMENT ON TABLE vault IS 'Table that holds the connection between user and his unique vault';
COMMENT ON COLUMN vault.id IS 'Id of vault';
COMMENT ON COLUMN vault.users_id IS 'Id of user owning this vault (Foreign key)';
COMMENT ON COLUMN vault.created IS 'The date this vault was created';

CREATE TABLE record
(
	id BIGSERIAL PRIMARY KEY,
	vault_id BIGSERIAL,
	name TEXT NOT NULL,
	username TEXT NOT NULL,
	password TEXT NOT NULL,
	created TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
	CONSTRAINT fk_vault FOREIGN KEY(vault_id) REFERENCES vault(id)
);

COMMENT ON TABLE record IS 'Table that holds record info';
COMMENT ON COLUMN record.id IS 'Id of record';
COMMENT ON COLUMN record.vault_id IS 'Id of vault containing this record';
COMMENT ON COLUMN record.name IS 'Name of record';
COMMENT ON COLUMN record.username IS 'Username of record';
COMMENT ON COLUMN record.password IS 'Password of record';
COMMENT ON COLUMN record.created IS 'The date this record was created';

/* Insert some basic data. */
insert into users(name, surname, email, username, password, age, country, gender)
values('Kosmas', 'Poiraz', 'kosmas@gmail.com', 'pook', '123456', '25', 'Greece', 'Male');
insert into vault(users_id)
values(1);
insert into record(vault_id, name, username, password)
values( 1, 'Facebook','pook1', '1245679');
insert into record(vault_id, name, username, password)
values( 1, 'Instagram','pook2', '1234');
insert into record(vault_id, name, username, password)
values( 1, 'Eurobank','pook3', '102030');

insert into users(name, surname, email, username, password, age, country, gender)
values('Spiros', 'Papak', 'spiros@gmail.com', 'pipis', '123456', '29', 'Greece', 'Male');
insert into vault(users_id)
values(2);
insert into record(vault_id, name, username, password)
values( 2, 'Facebook','pipis1', '1245679');
insert into record(vault_id, name, username, password)
values( 2, 'Instagram','pipis2', '1234');
insert into record(vault_id, name, username, password)
values( 2, 'Eurobank','pipis3', '102030');
