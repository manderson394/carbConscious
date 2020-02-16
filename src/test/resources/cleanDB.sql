SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS(
      id INT NOT NULL AUTO_INCREMENT,
      first_name VARCHAR(255) DEFAULT NULL,
      last_name VARCHAR(255) DEFAULT NULL,
      user_name VARCHAR(255) NOT NULL,
      email VARCHAR(255) NOT NULL,
      password VARCHAR(255) NOT NULL,
      --user_role_id INT NOT NULL,  TODO Add this column in when when the user role table is created
      creation_datetime DATETIME NOT NULL,
      update_datetime DATETIME NOT NULL,
      PRIMARY KEY(id),
      UNIQUE KEY (user_name),
      UNIQUE KEY (email)
);
SET FOREIGN_KEY_CHECKS=1;
--DELETE FROM USERS;