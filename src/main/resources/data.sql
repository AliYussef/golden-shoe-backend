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

-- Products --
insert into products
    (id, name, brand, image_path, price, target, created_at, updated_at)
values (1, 'Valen', 'British Nights',
        'https://martinvalen.com/3052-home_default/martin-valen-women-high-sole-sneakers-in-whiteblack.jpg', 80.99,
        'MEN', current_timestamp, current_timestamp),
       (2, 'Air Max', 'Nike',
        'https://img01.ztat.net/article/spp-media-p1/4a6cb8adb1f93133b4a2f2512462b98e/0f1ddd8d5cd84425aff7507dc649ba0d.jpg',
        100.99, 'UNISEX', current_timestamp, current_timestamp),
       (3, 'Air Force', 'Nike',
        'https://img01.ztat.net/article/spp-media-p1/2cefcf9e949d3a0bba92ebd5562c434a/32a8e0430dea4c32856173957cd838f7.jpg',
        66.99, 'WOMEN', current_timestamp, current_timestamp),
       (4, 'Air Max 90', 'Nike',
        'https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/zwxes8uud05rkuei1mpt/air-max-90-product-dlXJdc.png',
        99.99, 'MEN', current_timestamp, current_timestamp);

-- product_variants --
insert into product_variants
(id, price, stock, product_id, color_id, size_id, created_at, updated_at)
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

-- categories_products --
insert into categories_products
    (category_id, product_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4);

-- Images --
insert into images
    (id, path, product_variant_id, created_at, updated_at)
values (1, 'https://martinvalen.com/3052-home_default/martin-valen-women-high-sole-sneakers-in-whiteblack.jpg', 1,
        current_timestamp, current_timestamp),
       (2, 'https://martinvalen.com/3052-home_default/martin-valen-women-high-sole-sneakers-in-whiteblack.jpg', 2,
        current_timestamp, current_timestamp),
       (3,
        'https://img01.ztat.net/article/spp-media-p1/4a6cb8adb1f93133b4a2f2512462b98e/0f1ddd8d5cd84425aff7507dc649ba0d.jpg',
        5, current_timestamp, current_timestamp),
       (4,
        'https://img01.ztat.net/article/spp-media-p1/4a6cb8adb1f93133b4a2f2512462b98e/0f1ddd8d5cd84425aff7507dc649ba0d.jpg',
        6, current_timestamp, current_timestamp),
       (5,
        'https://img01.ztat.net/article/spp-media-p1/2cefcf9e949d3a0bba92ebd5562c434a/32a8e0430dea4c32856173957cd838f7.jpg',
        9, current_timestamp, current_timestamp),
       (6,
        'https://img01.ztat.net/article/spp-media-p1/2cefcf9e949d3a0bba92ebd5562c434a/32a8e0430dea4c32856173957cd838f7.jpg',
        10, current_timestamp, current_timestamp),
       (7,
        'https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/zwxes8uud05rkuei1mpt/air-max-90-product-dlXJdc.png',
        13, current_timestamp, current_timestamp),
       (8,
        'https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/zwxes8uud05rkuei1mpt/air-max-90-product-dlXJdc.png',
        14, current_timestamp, current_timestamp);

-- Payment Methods --
insert into payment_methods
    (name, created_at, updated_at)
values ('Credit Card', current_timestamp, current_timestamp),
       ('PayPal', current_timestamp, current_timestamp),
       ('iDEAL', current_timestamp, current_timestamp);

-- Shippers --
insert into shippers
    (name, price, delivery_duration_in_days, created_at, updated_at)
values ('DHL', 4.50, 3, current_timestamp, current_timestamp),
       ('POST NL', 3.50, 2, current_timestamp, current_timestamp),
       ('DPD', 7.90, 4, current_timestamp, current_timestamp);


-- Vouchers --
insert into vouchers
(id, code, discount_percentage, is_active, expiry_date, created_at, updated_at)
values (1, 'DDD', 10, true, '2021-04-30', current_timestamp, current_timestamp),
       (2, 'AAA', 10, false, '2021-06-06', current_timestamp, current_timestamp),
       (3, 'BBB', 15, true, '2021-06-06', current_timestamp, current_timestamp);


-- Return_processes --
insert into return_processes
    (step, title, description, created_at, updated_at)
values (1, 'Log into your customer account',
        'Log into your account, go to ‘Return Item’, click on ‘Return your products now’ and select the items you wish to return. At this stage you can schedule a home pick-up or choose your nearest Hermes ParcelShop.',
        current_timestamp, current_timestamp),
       (2, 'Pack the box',
        'Simply stick the return label that you received with your order to the top of the parcel, making sure to cover the delivery label.',
        current_timestamp, current_timestamp),
       (3, 'Return it',
        'Head to your nearest Hermes ParcelShop (this can be any UK-wide Hermes ParcelShop) or simply wait at home for the courier to come and collect it at the prearranged time you have chosen.',
        current_timestamp, current_timestamp),
       (4, 'Refund',
        'Once we have received your returned items, your refund will be processed immediately. As a rule it takes up to 48 hours to appear on your card statement. In extremely rare cases it can take up to 14 days. If you paid by debit or credit card, the money will be refunded to the bank account linked with the card. If you used PayPal, your refund will appear on your PayPal account.',
        current_timestamp, current_timestamp);