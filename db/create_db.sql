create database db_viewer;
create user 'db_viewer_user'@'%' identified by 'db_viewer_pass';
grant all on db_viewer.* to 'db_viewer_user'@'%';

create database client_db1;
create user 'db_viewer_user_1'@'%' identified by 'db_viewer_pass1';
grant all on client_db1.* to 'db_viewer_user_1'@'%';

CREATE TABLE MyGuests
(
    id        INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(30) NOT NULL,
    lastname  VARCHAR(30) NOT NULL,
    email     VARCHAR(50),
    reg_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

create database client_db2;
create user 'db_viewer_user_2'@'%' identified by 'db_viewer_pass2';
grant all on client_db2.* to 'db_viewer_user_2'@'%';


