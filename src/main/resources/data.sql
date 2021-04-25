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
    (id, name, price, stock, brand, target, created_at, updated_at)
values (1, 'Valen', 80.99, 100, 'British Nights', 'Men', current_timestamp, current_timestamp),
       (2, 'Air Max', 100.99, 6, 'Nike', 'Unisex', current_timestamp, current_timestamp),
       (3, 'Air Force', 66.99, 55, 'Nike', 'Women', current_timestamp, current_timestamp),
       (4, 'Air Max 90', 99.99, 3, 'Nike', 'Men', current_timestamp, current_timestamp);

-- shoes_sizes --
insert into shoes_sizes
    (shoes_id, sizes_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 4),
       (3, 1),
       (4, 2),
       (4, 3),
       (4, 4);

-- shoes_sizes --
insert into shoes_colors
    (shoes_id, colors_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 4),
       (3, 1),
       (4, 2),
       (4, 3),
       (4, 4);

-- categories_shoes --
insert into categories_shoes
    (category_id, shoe_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4);

-- Images --
insert into images
    (id, path, shoe_id, created_at, updated_at)
values (1, 'Sneaker', 1, current_timestamp, current_timestamp),
       (2, 'Sandal', 1, current_timestamp, current_timestamp),
       (3, 'Heel', 2, current_timestamp, current_timestamp),
       (4, 'Boot', 2, current_timestamp, current_timestamp),
       (5, 'Heel', 3, current_timestamp, current_timestamp),
       (6, 'Boot', 3, current_timestamp, current_timestamp),
       (7, 'Heel', 4, current_timestamp, current_timestamp),
       (8, 'Boot', 4, current_timestamp, current_timestamp);

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