CREATE TABLE BOOKING_USER(
    ID NUMBER PRIMARY KEY,
    FIRST_NAME VARCHAR,
    LAST_NAME VARCHAR,
    EMAIL_ADDRESS VARCHAR
);

CREATE TABLE TRAIN_DETAILS(
    ID NUMBER PRIMARY KEY,
    TRAIN_NAME VARCHAR,
    STATION_FROM VARCHAR,
    STATION_TO VARCHAR
);

CREATE TABLE TRAIN_SCHEDULE(
    ID NUMBER PRIMARY KEY,
    TRAIN_DETAILS_ID NUMBER,
    DEPARTURE_DATE TIMESTAMP,
    COST NUMBER(10,2)
);

CREATE TABLE Train_Seats (
                      id NUMBER PRIMARY KEY,
                      train_schedule_id NUMBER,
                      section_Name VARCHAR(2),
                      seat_Number INTEGER,
                      seat_Booking_Status VARCHAR(10)
);

CREATE TABLE Train_ticket (
    id NUMBER PRIMARY KEY ,
    user_id NUMBER,
    train_seat_id NUMBER,
    PRICE NUMBER(10,2),
    ticket_status VARCHAR(10)
)