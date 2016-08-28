CREATE TABLE HOTEL (ID VARCHAR(255) NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE ROOM (ID VARCHAR(255) NOT NULL, NAME VARCHAR(255), HOTEL_ID VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PC2 (ID VARCHAR(255) NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PARTS2 (ID VARCHAR(255) NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PC2_PARTS2 (pcs_ID VARCHAR(255) NOT NULL, parts_ID VARCHAR(255) NOT NULL, PRIMARY KEY (pcs_ID, parts_ID))
ALTER TABLE HOTEL ADD CONSTRAINT UNQ_HOTEL_0 UNIQUE (name)
ALTER TABLE ROOM ADD CONSTRAINT UNQ_ROOM_0 UNIQUE (id, hotel_id)
ALTER TABLE ROOM ADD CONSTRAINT FK_ROOM_HOTEL_ID FOREIGN KEY (HOTEL_ID) REFERENCES HOTEL (ID)
ALTER TABLE PC2_PARTS2 ADD CONSTRAINT PC2_PARTS2_pcs_ID FOREIGN KEY (pcs_ID) REFERENCES PC2 (ID)
ALTER TABLE PC2_PARTS2 ADD CONSTRAINT PC2_PARTS2parts_ID FOREIGN KEY (parts_ID) REFERENCES PARTS2 (ID)
