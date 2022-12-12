CREATE TABLE IF NOT EXISTS orders
(
    id bigserial primary key,
    total_price int
);

CREATE TABLE IF NOT EXISTS orders_products
(
    id bigserial primary key,
    order_id bigint,
    product_id bigint,
    quantity int,
    price_per_product int,
    price int,
    constraint fk_orders foreign key (order_id) references orders(id),
    constraint fk_products foreign key (product_id) references products(id)
);