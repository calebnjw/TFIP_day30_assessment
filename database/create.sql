-- Task 1
-- Write SQL statements in this file to create the brewery database and 
-- populate the database with the given SQL files
CREATE DATABASE brewerydb;
USE brewerydb;
SOURCE breweries.sql;
SOURCE categories.sql;
SOURCE styles.sql;
SOURCE geocodes.sql;
SOURCE beers.sql;