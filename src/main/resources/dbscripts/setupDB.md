## Steps for setting up Database for the API

1.Start the mysql database.  
2.Login to mysql and create table "brightbytes".  
3.Run /src/main/java/com/brightbytes/foodapi/FoodapiApplication.java, this will:  
- create table dish with all the required collumns.
  4.Now Insert records into the DB using the following:


select *,b.b_calories + l.l_calories + d.d_calories as total_calories from (
(select id as b_id, calories as b_calories from dish WHERE
mealtype = "Breakfast") as b
JOIN
(select id as l_id, calories as l_calories from dish WHERE
mealtype = "Lunch") as l
JOIN
(select id as d_id, calories as d_calories from dish WHERE
mealtype = "Dinner") as d
) WHERE b.b_calories + l.l_calories + d.d_calories <= 2000
ORDER BY total_calories desc LIMIT 1;

DROP VIEW IF EXISTS plan_view;

CREATE VIEW plan_view AS
select *, b_calories + l_calories + d_calories as total_calories from (
(select id as b_id, name as b_name, category as b_category, mealtype as b_mealtype, calories as b_calories, recipelink as b_recipelink, imagelink as b_imagelink, allergens as b_allergens from dish WHERE
mealtype = "Breakfast") as b
JOIN
(select id as l_id, name as l_name, category as l_category, mealtype as l_mealtype, calories as l_calories, recipelink as l_recipelink, imagelink as l_imagelink, allergens as l_allergens from dish WHERE
mealtype = "Lunch") as l
JOIN
(select id as d_id, name as d_name, category as d_category, mealtype as d_mealtype, calories as d_calories, recipelink as d_recipelink, imagelink as d_imagelink, allergens as d_allergens from dish WHERE
mealtype = "Dinner") as d
) ORDER BY total_calories desc;

select * from plan_view;

select * from(
select b_id as id , b_calories as calories from plan_view where total_calories <= 2000 LIMIT 1
UNION
select l_id as id , l_calories as calories from plan_view where total_calories <= 2000 LIMIT 1
UNION
select d_id as id , d_calories as calories from plan_view where total_calories <= 2000 LIMIT 1
)
;

(select b_id as id, b_name as name, b_category as category, b_mealtype as mealtype, b_calories as calories, b_recipelink as recipelink, b_imagelink as imagelink, b_allergens as allergens from
plan_view where total_calories <= 3360 ORDER BY total_calories desc LIMIT 1)
UNION
(select l_id as id, l_name as name, l_category as category, l_mealtype as mealtype, l_calories as calories, l_recipelink as recipelink, l_imagelink as imagelink, l_allergens as allergens from
plan_view where total_calories <= 3360 ORDER BY total_calories desc LIMIT 1)
UNION
(select d_id as id, d_name as name, d_category as category, d_mealtype as mealtype, d_calories as calories, d_recipelink as recipelink, d_imagelink as imagelink, d_allergens as allergens from 
plan_view where total_calories <= 3360 ORDER BY total_calories desc LIMIT 1);



INSERT INTO dish (name,category,mealtype,calories,recipelink,imagelink,allergens) VALUES
('Hummus Pocket Sandwich','veg', 'Lunch', 445,'https://www.eatthismuch.com/recipe/nutrition/hummus-pocket-sandwich,33542/', 'https://images.eatthismuch.com/img/33542_erin_m_84b9af6c-9e50-4ec2-a052-f20b379f94f7.png', 'none'),
('Kung Pao Tempeh','veg', 'Dinner', 986,'https://www.eatthismuch.com/recipe/nutrition/kung-pao-tempeh,374006/', 'https://images.eatthismuch.com/img/374006_erin_m_f5582f14-9e0e-4623-9b29-7af957a274b6.png', 'peanut');