# Insert data into the USERS Table
INSERT INTO USERS VALUES (1, 'Matt', 'Anderson', 'mattanderson', 'matt@gmail.com', 'testing', '2020-1-1', '2020-1-2');
INSERT INTO USERS VALUES (2, 'Drew', 'Peterson', 'drewPeterson', 'drew@madisoncollege.edu', 'testing1', '2020-1-4', '2020-1-5');
INSERT INTO USERS VALUES (3, 'Nicole', 'Sannes', 'nicoleSannes', 'nicole@aol.com', 'testing2', '2020-1-7', '2020-1-8');
INSERT INTO USERS VALUES (4, 'Shelley', 'Anderson', 'shelleyAnderson1', 'shelley@live.com', 'testing3', '2020-1-7', '2020-1-8');
INSERT INTO USERS VALUES (5, 'Rich', 'Anderson', 'richAnderson2', 'rich@gmail.com', 'testing3', '2020-1-10', '2020-1-23');

# Insert data into the USER_ROLES Table
INSERT INTO USER_ROLES VALUES (1, 'User', 'mattanderson', '2020-1-1');
INSERT INTO USER_ROLES VALUES (2, 'User', 'drewPeterson', '2020-1-4');
INSERT INTO USER_ROLES VALUES (3, 'Administrator', 'nicoleSannes', '2020-1-7');
INSERT INTO USER_ROLES VALUES (4, 'User', 'shelleyAnderson1', '2020-1-7');
INSERT INTO USER_ROLES VALUES (5, 'Administrator', 'richAnderson2', '2020-1-10');