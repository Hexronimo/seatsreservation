CREATE TABLE ROOM(
    ID_ROOM INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    INFO VARCHAR(1500)
);

CREATE TABLE SEAT(
    ID_SEAT BIGINT AUTO_INCREMENT PRIMARY KEY,
    ID_ROOM INT NOT NULL,
    NAME VARCHAR(16) NOT NULL,

    FOREIGN KEY ("ID_ROOM") REFERENCES ROOM ("ID_ROOM")
);

CREATE TABLE EVENT(
    ID_EVENT INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    INFO VARCHAR(1500)
);

CREATE TABLE HAPPEN(
    ID_HAPPEN BIGINT AUTO_INCREMENT PRIMARY KEY,
    ID_EVENT INT NOT NULL,
    ID_ROOM INT NOT NULL,
    DATE_START DATE NOT NULL,
    TIME_START TIME NOT NULL,
    DATE_END DATE NOT NULL,
    TIME_END TIME NOT NULL,

    FOREIGN KEY ("ID_ROOM") REFERENCES ROOM ("ID_ROOM"),
    FOREIGN KEY ("ID_EVENT") REFERENCES EVENT ("ID_EVENT")
);

CREATE TABLE CUSTOMER(
    ID_CUSTOMER INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);

CREATE TABLE RESERVATION(
    ID_RESERVATION BIGINT AUTO_INCREMENT PRIMARY KEY,
    ID_HAPPEN BIGINT NOT NULL,
    ID_SEAT BIGINT NOT NULL,
    ID_CUSTOMER BIGINT,

    FOREIGN KEY ("ID_HAPPEN") REFERENCES HAPPEN ("ID_HAPPEN"),
    FOREIGN KEY ("ID_SEAT") REFERENCES SEAT ("ID_SEAT"),
    FOREIGN KEY ("ID_CUSTOMER") REFERENCES CUSTOMER ("ID_CUSTOMER")
);
