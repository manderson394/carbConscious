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

# Insert data into the MENU_APIS Table

INSERT INTO MENU_APIS VALUES (1, 'Spoonacular', '2020-3-14');
INSERT INTO MENU_APIS VALUES (2, 'Tester', '2019-12-23');

# Insert data into RESTAURANTS Table

INSERT INTO RESTAURANTS VALUES (1, 'Pancake House', '123 Street', 'WI', '55555', '608-608-6088', 1, 3131, '2020-3-14');
INSERT INTO RESTAURANTS VALUES (2, 'Mom and Pop', '456 Drive', 'MI', '77777', '715-715-7155', 2, 3333, '2020-2-10');
INSERT INTO RESTAURANTS VALUES (3, 'Ol Diner', '789 Boulevard', 'NY', '12345', '715-715-7151', 1, 4141, '2020-3-15');

# Insert data into MENU_ITEMS Table

INSERT INTO MENU_ITEMS VALUES (1, 'Blueberry Pancakes', 'yummy pancakes', 1, 22, 1, '2020-3-14');
INSERT INTO MENU_ITEMS VALUES (2, 'Pumpkin Pancakes', 'more pancakes', 1, 33, 1, '2020-3-14');
INSERT INTO MENU_ITEMS VALUES (3, 'Butter', '', 1, 32, 1, '2020-3-14');
INSERT INTO MENU_ITEMS VALUES (4, 'Burger', 'lettuce, tomato, beef, buns!',2, 32, 2, '2020-2-10');
INSERT INTO MENU_ITEMS VALUES (5, 'Meat Loaf', '', 1, 1, 3, '2020-3-15');

# Insert data into OUTCOMES Table

INSERT INTO OUTCOMES VALUES (0, 'LOW', '2020-3-14');
INSERT INTO OUTCOMES VALUES (1, 'IN_RANGE', '2020-3-14');
INSERT INTO OUTCOMES VALUES (2, 'HIGH', '2020-3-14');

# Insert data into USER_FAVORITES Table

INSERT INTO USER_FAVORITES VALUES (1, 1, 1, 1);
INSERT INTO USER_FAVORITES VALUES (2, 1, 2, 2);
INSERT INTO USER_FAVORITES VALUES (3, 1, 3, 3);
INSERT INTO USER_FAVORITES VALUES (4, 2, 1, 1);
INSERT INTO USER_FAVORITES VALUES (5, 2, 2, 2);
INSERT INTO USER_FAVORITES VALUES (6, 3, 1, 4);

# Insert data into CARBOHYDRATE_ESTIMATES Table

INSERT INTO CARBOHYDRATE_ESTIMATES VALUES (1, 1, 75, 1, 1, '2020-3-14', '2020-3-14');
INSERT INTO CARBOHYDRATE_ESTIMATES VALUES (2, 2, 45, 2, 1, '2020-3-14', '2020-3-14');
INSERT INTO CARBOHYDRATE_ESTIMATES VALUES (3, 1, 85, 0, 2, '2020-3-15', '2020-3-15');
INSERT INTO CARBOHYDRATE_ESTIMATES VALUES (4, 5, 40, 1, 3, '2020-3-15', '2020-3-15');
INSERT INTO CARBOHYDRATE_ESTIMATES VALUES (5, 3, 0, 1, 3, '2020-3-15', '2020-3-15');
INSERT INTO CARBOHYDRATE_ESTIMATES VALUES (6, 3, 1, 1, 3, '2020-3-16', '2020-3-16');