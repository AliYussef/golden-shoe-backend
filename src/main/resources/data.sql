-- Sizes --
insert into sizes
    (id, size, created_at, updated_at)
values (1, 40, current_timestamp, current_timestamp),
       (2, 41, current_timestamp, current_timestamp),
       (3, 42, current_timestamp, current_timestamp),
       (4, 43, current_timestamp, current_timestamp);

-- Colors --
insert into colors
    (id, name, created_at, updated_at)
values (1, 'Black', current_timestamp, current_timestamp),
       (2, 'White', current_timestamp, current_timestamp),
       (3, 'Blue', current_timestamp, current_timestamp),
       (4, 'Brown', current_timestamp, current_timestamp);

-- Categories --
insert into categories
    (id, name, created_at, updated_at)
values (1, 'Sneaker', current_timestamp, current_timestamp),
       (2, 'Sandal', current_timestamp, current_timestamp),
       (3, 'Heel', current_timestamp, current_timestamp),
       (4, 'Boot', current_timestamp, current_timestamp);

-- Shoes --
insert into shoes
    (id, name, brand, target, created_at, updated_at)
values (1, 'Valen', 'British Nights', 'MEN', current_timestamp, current_timestamp),
       (2, 'Air Max', 'Nike', 'UNISEX', current_timestamp, current_timestamp),
       (3, 'Air Force', 'Nike', 'WOMEN', current_timestamp, current_timestamp),
       (4, 'Air Max 90', 'Nike', 'MEN', current_timestamp, current_timestamp);

-- shoe_specific --
insert into shoe_variants
    (id, price, stock, shoe_id, color_id, size_id, created_at, updated_at)
values (1, 80.99, 100, 1, 1, 1, current_timestamp, current_timestamp),
       (2, 100.99, 6, 1, 2, 2, current_timestamp, current_timestamp),
       (3, 66.99, 55, 1, 3, 3, current_timestamp, current_timestamp),
       (4, 99.99, 3, 1, 4, 4, current_timestamp, current_timestamp),
       (5, 80.99, 100, 2, 1, 1, current_timestamp, current_timestamp),
       (6, 100.99, 6, 2, 2, 2, current_timestamp, current_timestamp),
       (7, 66.99, 55, 2, 3, 3, current_timestamp, current_timestamp),
       (8, 99.99, 3, 2, 4, 4, current_timestamp, current_timestamp),
       (9, 80.99, 100, 3, 1, 1, current_timestamp, current_timestamp),
       (10, 100.99, 6, 3, 2, 2, current_timestamp, current_timestamp),
       (11, 66.99, 55, 3, 3, 3, current_timestamp, current_timestamp),
       (12, 99.99, 3, 3, 4, 4, current_timestamp, current_timestamp),
       (13, 80.99, 100, 4, 1, 1, current_timestamp, current_timestamp),
       (14, 100.99, 6, 4, 2, 2, current_timestamp, current_timestamp),
       (15, 66.99, 55, 4, 3, 3, current_timestamp, current_timestamp),
       (16, 99.99, 3, 4, 4, 4, current_timestamp, current_timestamp);

-- categories_shoes --
insert into categories_shoes
    (category_id, shoe_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4);

-- Images --
insert into images
    (id, path, shoe_variant_id, created_at, updated_at)
values (1, 'Sneaker', 1, current_timestamp, current_timestamp),
       (2, 'Sandal', 2, current_timestamp, current_timestamp),
       (3, 'Heel', 5, current_timestamp, current_timestamp),
       (4, 'Boot', 6, current_timestamp, current_timestamp),
       (5, 'Heel', 9, current_timestamp, current_timestamp),
       (6, 'Boot', 10, current_timestamp, current_timestamp),
       (7, 'Heel', 13, current_timestamp, current_timestamp),
       (8, 'Boot', 14, current_timestamp, current_timestamp);

-- Payment Methods --
insert into payment_methods
    (name, created_at, updated_at)
values ('Credit Card', current_timestamp, current_timestamp),
       ('PayPal', current_timestamp, current_timestamp),
       ('iDEAL', current_timestamp, current_timestamp);

-- Shippers --
insert into shippers
    (name, price, created_at, updated_at)
values ('DHL', 4.50, current_timestamp, current_timestamp),
       ('POST NL', 3.50, current_timestamp, current_timestamp),
       ('DPD', 7.90, current_timestamp, current_timestamp);