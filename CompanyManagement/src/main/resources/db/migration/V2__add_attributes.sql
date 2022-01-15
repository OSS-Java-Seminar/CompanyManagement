ALTER TABLE employee ADD email VARCHAR(255) NULL;

ALTER TABLE employee ADD passwd VARCHAR(255) NULL;

ALTER TABLE employee ADD CONSTRAINT uc_employee_email UNIQUE (email);