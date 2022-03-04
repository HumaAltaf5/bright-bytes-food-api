DROP VIEW IF EXISTS plan_view;

CREATE VIEW plan_view AS
select *, b_calories + l_calories + d_calories as total_calories from (
(select id as b_id, name as b_name, category as b_category, mealtype as b_mealtype, calories as b_calories, recipelink as b_recipelink, imagelink as b_imagelink, allergens as b_allergens from dish WHERE
category = "Breakfast") as b
JOIN
(select id as l_id, name as l_name, category as l_category, mealtype as l_mealtype, calories as l_calories, recipelink as l_recipelink, imagelink as l_imagelink, allergens as l_allergens from dish WHERE
category = "Lunch") as l
JOIN
(select id as d_id, name as d_name, category as d_category, mealtype as d_mealtype, calories as d_calories, recipelink as d_recipelink, imagelink as d_imagelink, allergens as d_allergens from dish WHERE
category = "Dinner") as d
) ORDER BY total_calories desc;