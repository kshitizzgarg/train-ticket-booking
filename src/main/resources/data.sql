INSERT INTO Booking_User (id,first_name, last_name, email_address) VALUES (1, 'Kshitiz', 'Garg', 'kshitizzgarg@gmail.com');

-- Sample inserts for TRAIN_DETAILS table (London to Paris and return)
INSERT INTO TRAIN_DETAILS (ID, TRAIN_NAME, STATION_FROM, STATION_TO) VALUES (1, 'Eurostar London-Paris', 'LONDON', 'PARIS');
INSERT INTO TRAIN_DETAILS (ID, TRAIN_NAME, STATION_FROM, STATION_TO) VALUES (2, 'Eurostar Paris-London', 'PARIS', 'LONDON');

-- Sample inserts for TRAIN_SCHEDULE table (Departing tomorrow, April 18, 2025)
INSERT INTO TRAIN_SCHEDULE (ID, TRAIN_DETAILS_ID, DEPARTURE_DATE, COST) VALUES (1, 1, TIMESTAMP '2025-04-18 00:00:00', 20.00);
INSERT INTO TRAIN_SCHEDULE (ID, TRAIN_DETAILS_ID, DEPARTURE_DATE, COST) VALUES (2, 2, TIMESTAMP '2025-04-18 00:00:00', 20.00);

-- INSERT train seat info

INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (1, 1, 'A', 1, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (2, 1, 'A', 2, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (3, 1, 'A', 3, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (4, 1, 'A', 4, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (5, 1, 'A', 5, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (6, 1, 'A', 6, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (7, 1, 'A', 7, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (8, 1, 'A', 8, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (9, 1, 'A', 9, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (10, 1, 'A', 10, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (11, 1, 'A', 11, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (12, 1, 'A', 12, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (13, 1, 'A', 13, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (14, 1, 'A', 14, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (15, 1, 'A', 15, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (16, 1, 'A', 16, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (17, 1, 'A', 17, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (18, 1, 'A', 18, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (19, 1, 'A', 19, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (20, 1, 'A', 20, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (21, 1, 'A', 21, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (22, 1, 'A', 22, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (23, 1, 'A', 23, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (24, 1, 'A', 24, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (25, 1, 'A', 25, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (26, 1, 'A', 26, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (27, 1, 'A', 27, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (28, 1, 'A', 28, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (29, 1, 'A', 29, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (30, 1, 'A', 30, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (31, 1, 'A', 31, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (32, 1, 'A', 32, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (33, 1, 'A', 33, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (34, 1, 'A', 34, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (35, 1, 'A', 35, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (36, 1, 'A', 36, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (37, 1, 'A', 37, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (38, 1, 'A', 38, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (39, 1, 'A', 39, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (40, 1, 'A', 40, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (41, 1, 'A', 41, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (42, 1, 'A', 42, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (43, 1, 'A', 43, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (44, 1, 'A', 44, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (45, 1, 'A', 45, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (46, 1, 'A', 46, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (47, 1, 'A', 47, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (48, 1, 'A', 48, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (49, 1, 'A', 49, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (50, 1, 'A', 50, 'VACANT');

INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (51, 1, 'B', 51, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (52, 1, 'B', 52, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (53, 1, 'B', 53, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (54, 1, 'B', 54, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (55, 1, 'B', 55, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (56, 1, 'B', 56, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (57, 1, 'B', 57, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (58, 1, 'B', 58, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (59, 1, 'B', 59, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (60, 1, 'B', 60, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (61, 1, 'B', 61, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (62, 1, 'B', 62, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (63, 1, 'B', 63, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (64, 1, 'B', 64, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (65, 1, 'B', 65, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (66, 1, 'B', 66, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (67, 1, 'B', 67, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (68, 1, 'B', 68, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (69, 1, 'B', 69, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (70, 1, 'B', 70, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (71, 1, 'B', 71, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (72, 1, 'B', 72, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (73, 1, 'B', 73, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (74, 1, 'B', 74, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (75, 1, 'B', 75, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (76, 1, 'B', 76, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (77, 1, 'B', 77, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (78, 1, 'B', 78, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (79, 1, 'B', 79, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (80, 1, 'B', 80, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (81, 1, 'B', 81, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (82, 1, 'B', 82, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (83, 1, 'B', 83, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (84, 1, 'B', 84, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (85, 1, 'B', 85, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (86, 1, 'B', 86, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (87, 1, 'B', 87, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (88, 1, 'B', 88, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (89, 1, 'B', 89, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (90, 1, 'B', 90, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (91, 1, 'B', 91, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (92, 1, 'B', 92, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (93, 1, 'B', 93, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (94, 1, 'B', 94, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (95, 1, 'B', 95, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (96, 1, 'B', 96, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (97, 1, 'B', 97, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (98, 1, 'B', 98, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (99, 1, 'B', 99, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (100, 1, 'B', 100, 'VACANT');

-- Train Schedule ID 2, Section A
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (101, 2, 'A', 101, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (102, 2, 'A', 102, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (103, 2, 'A', 103, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (104, 2, 'A', 104, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (105, 2, 'A', 105, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (106, 2, 'A', 106, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (107, 2, 'A', 107, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (108, 2, 'A', 108, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (109, 2, 'A', 109, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (110, 2, 'A', 110, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (111, 2, 'A', 111, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (112, 2, 'A', 112, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (113, 2, 'A', 113, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (114, 2, 'A', 114, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (115, 2, 'A', 115, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (116, 2, 'A', 116, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (117, 2, 'A', 117, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (118, 2, 'A', 118, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (119, 2, 'A', 119, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (120, 2, 'A', 120, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (121, 2, 'A', 121, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (122, 2, 'A', 122, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (123, 2, 'A', 123, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (124, 2, 'A', 124, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (125, 2, 'A', 125, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (126, 2, 'A', 126, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (127, 2, 'A', 127, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (128, 2, 'A', 128, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (129, 2, 'A', 129, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (130, 2, 'A', 130, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (131, 2, 'A', 131, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (132, 2, 'A', 132, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (133, 2, 'A', 133, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (134, 2, 'A', 134, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (135, 2, 'A', 135, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (136, 2, 'A', 136, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (137, 2, 'A', 137, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (138, 2, 'A', 138, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (139, 2, 'A', 139, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (140, 2, 'A', 140, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (141, 2, 'A', 141, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (142, 2, 'A', 142, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (143, 2, 'A', 143, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (144, 2, 'A', 144, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (145, 2, 'A', 145, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (146, 2, 'A', 146, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (147, 2, 'A', 147, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (148, 2, 'A', 148, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (149, 2, 'A', 149, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (150, 2, 'A', 150, 'VACANT');

-- Train Schedule ID 2, Section B
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (151, 2, 'B', 151, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (152, 2, 'B', 152, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (153, 2, 'B', 153, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (154, 2, 'B', 154, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (155, 2, 'B', 155, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (156, 2, 'B', 156, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (157, 2, 'B', 157, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (158, 2, 'B', 158, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (159, 2, 'B', 159, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (160, 2, 'B', 160, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (161, 2, 'B', 161, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (162, 2, 'B', 162, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (163, 2, 'B', 163, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (164, 2, 'B', 164, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (165, 2, 'B', 165, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (166, 2, 'B', 166, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (167, 2, 'B', 167, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (168, 2, 'B', 168, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (169, 2, 'B', 169, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (170, 2, 'B', 170, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (171, 2, 'B', 171, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (172, 2, 'B', 172, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (173, 2, 'B', 173, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (174, 2, 'B', 174, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (175, 2, 'B', 175, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (176, 2, 'B', 176, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (177, 2, 'B', 177, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (178, 2, 'B', 178, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (179, 2, 'B', 179, 'VACANT');
INSERT INTO Train_Seats (id, train_schedule_id, section_Name, seat_Number, seat_Booking_Status) VALUES (180, 2, 'B', 180, 'VACANT');

CREATE SEQUENCE user_id_seq
    START WITH 2
    INCREMENT BY 1;

CREATE SEQUENCE TRAIN_DETAILS_seq
    START WITH 3
    INCREMENT BY 1;

CREATE SEQUENCE TRAIN_SCHEDULE_seq
    START WITH 3
    INCREMENT BY 1;

CREATE SEQUENCE Train_Seats_seq
    START WITH 201
    INCREMENT BY 1;

CREATE SEQUENCE Train_ticket_seq
    START WITH 1
    INCREMENT BY 1;

