CREATE TABLE IF NOT EXISTS USER_DATA (
id int NOT NULL,
lastName varchar(100),
firstName varchar(100),
middleName varchar(100),
fullName varchar(100),
nickname varchar(100),
comment varchar(100);
groupName varchar(100),
skype varchar(100),
email varchar(100),
homePhoneNumber int,
mobilePhoneNumber int,
mobilePhoneNumberSecond int,
entryDate date,
dateOfLastChange date,
PRIMARY KEY ( id ));

CREATE TABLE IF NOT EXISTS ADDRESS (
id INT NOT NULL,
user_data_id int NOT NULL,
index INT NOT NULL,
city varchar(100),
houseNumber INT NOT NULL,
flatNumber INT NOT NULL,
PRIMARY KEY ( id )
 CONSTRAINT users_data_id_fkey FOREIGN KEY (user_data_id )
    REFERENCES sers_data (id));