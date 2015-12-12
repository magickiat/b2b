-- select p.product_picture_big, p.product_picture_medium from b2b.product p;

update b2b.product set product_picture_big = replace(product_picture_big, '.png', '.jpg')
, product_picture_medium = replace(product_picture_medium, '.png', '.jpg')