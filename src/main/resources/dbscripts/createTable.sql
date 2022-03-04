DROP TABLE dish;

create table dish (
id int NOT NULL AUTO_INCREMENT,
name VARCHAR(255) NOT NULL UNIQUE,
calories int,
mealtype VARCHAR(40),
category VARCHAR(40),
recipelink TEXT,
Imagelink TEXT,
allergens VARCHAR(15),
PRIMARY KEY (id)
);