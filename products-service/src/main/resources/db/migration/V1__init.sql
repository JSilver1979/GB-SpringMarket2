CREATE TABLE IF NOT EXISTS products (id bigserial primary key, title varchar(255), price int);
INSERT INTO products(title, price)
VALUES
    ('Apple', 100),
    ('Orange', 200),
    ('Carrot', 50),
    ('Brokkoli', 150),
    ('Tomato', 150),
    ('Potato', 30),
    ('Cucumber', 70),
    ('Watermelon', 25),
    ('Pineapple', 300),
    ('Kiwi', 90),
    ('Grapefruit', 220),
    ('Lemon', 99),
    ('Milk', 16),
    ('Bread', 10),
    ('Juice', 100),
    ('Mineral Water', 98),
    ('Cheese', 230),
    ('Fish', 300),
    ('Meat', 247),
    ('Chicken', 176),
    ('Pizza', 290);