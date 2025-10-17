CREATE TABLE app_user
(
    id        INTEGER NOT NULL,
    firstname VARCHAR(255),
    lastname  VARCHAR(255),
    email     VARCHAR(255),
    password  VARCHAR(255),
    CONSTRAINT pk_appuser PRIMARY KEY (id)
);

ALTER TABLE app_user
    ADD CONSTRAINT uc_user_email UNIQUE (email);