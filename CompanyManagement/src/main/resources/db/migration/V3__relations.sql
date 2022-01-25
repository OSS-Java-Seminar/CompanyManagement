ALTER TABLE item ADD category_id char(36) NULL;

ALTER TABLE item ADD CONSTRAINT FK_ITEM_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE item_category DROP FOREIGN KEY FKjlvge1dms1hf66yi8dkard983;

ALTER TABLE item_category DROP FOREIGN KEY FKpikirirfdxnbcpd4lod4ig34c;

ALTER TABLE items_categories DROP FOREIGN KEY fk_itecat_on_category;

ALTER TABLE items_categories DROP FOREIGN KEY fk_itecat_on_item;

DROP TABLE item_category;

DROP TABLE items_categories;