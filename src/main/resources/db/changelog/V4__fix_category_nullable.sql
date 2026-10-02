-- V2-dəki səhvi düzəldir: category məcburi (NOT NULL) idi, optional olmalıdır
ALTER TABLE products
    ALTER COLUMN category DROP NOT NULL;

ALTER TABLE products
    ALTER COLUMN category DROP DEFAULT;
