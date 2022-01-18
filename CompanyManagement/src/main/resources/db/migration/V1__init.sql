CREATE TABLE customer (
  id char(36) NOT NULL,
  customer_name VARCHAR(35) NOT NULL,
  surname VARCHAR(35) NOT NULL,
  oib BIGINT NOT NULL,
  address VARCHAR(50) NULL,
  telephone VARCHAR(35) NULL,
  city VARCHAR(50) NULL,
  CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE employee (
  id char(36) NOT NULL,
  employee_name VARCHAR(35) NOT NULL,
  surname VARCHAR(35) NOT NULL,
  oib BIGINT NOT NULL,
  address VARCHAR(50) NULL,
  email VARCHAR(255) NULL,
  passwd VARCHAR(255) NULL,
  CONSTRAINT pk_employee PRIMARY KEY (id)
);

CREATE TABLE invoice (
  id char(36) NOT NULL,
  invoice_number INT NOT NULL,
  total_amount FLOAT NOT NULL,
  date_of_issue VARCHAR(23) NOT NULL,
  due_date VARCHAR(23) NOT NULL,
  vat FLOAT NOT NULL,
  discount FLOAT NULL,
  payment_status VARCHAR(10) NOT NULL,
  payment_method VARCHAR(15) NOT NULL,
  customer_id char(36) NOT NULL,
  employee_id char(36) NOT NULL,
  CONSTRAINT pk_invoice PRIMARY KEY (id)
);

CREATE TABLE invoice_items (
  invoice_id char(36) NOT NULL,
  items_id char(36) NOT NULL,
  CONSTRAINT pk_invoice_items PRIMARY KEY (invoice_id, items_id)
);

CREATE TABLE item (
  id char(36) NOT NULL,
  price INT NOT NULL,
  item_name VARCHAR(50) NOT NULL,
  CONSTRAINT pk_item PRIMARY KEY (id)
);

CREATE TABLE item_invoices (
  item_id char(36) NOT NULL,
  invoices_id char(36) NOT NULL,
  CONSTRAINT pk_item_invoices PRIMARY KEY (item_id, invoices_id)
);

CREATE TABLE user_role (
  id char(36) NOT NULL,
  role_name VARCHAR(20) NOT NULL,
  CONSTRAINT pk_userrole PRIMARY KEY (id)
);

CREATE TABLE users_roles (
  role_id char(36) NOT NULL,
  user_id char(36) NOT NULL,
  CONSTRAINT pk_users_roles PRIMARY KEY (role_id, user_id)
);

ALTER TABLE customer ADD CONSTRAINT uc_customer_oib UNIQUE (oib);

ALTER TABLE employee ADD CONSTRAINT uc_employee_email UNIQUE (email);

ALTER TABLE employee ADD CONSTRAINT uc_employee_oib UNIQUE (oib);

ALTER TABLE invoice ADD CONSTRAINT uc_invoice_invoicenumber UNIQUE (invoice_number);

ALTER TABLE user_role ADD CONSTRAINT uc_userrole_rolename UNIQUE (role_name);

ALTER TABLE invoice ADD CONSTRAINT FK_INVOICE_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE invoice ADD CONSTRAINT FK_INVOICE_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employee (id);

ALTER TABLE invoice_items ADD CONSTRAINT fk_invite_on_invoice FOREIGN KEY (invoice_id) REFERENCES invoice (id);

ALTER TABLE invoice_items ADD CONSTRAINT fk_invite_on_item FOREIGN KEY (items_id) REFERENCES item (id);

ALTER TABLE item_invoices ADD CONSTRAINT fk_iteinv_on_invoice FOREIGN KEY (invoices_id) REFERENCES invoice (id);

ALTER TABLE item_invoices ADD CONSTRAINT fk_iteinv_on_item FOREIGN KEY (item_id) REFERENCES item (id);

ALTER TABLE users_roles ADD CONSTRAINT fk_userol_on_employee FOREIGN KEY (user_id) REFERENCES employee (id);

ALTER TABLE users_roles ADD CONSTRAINT fk_userol_on_user_role FOREIGN KEY (role_id) REFERENCES user_role (id);