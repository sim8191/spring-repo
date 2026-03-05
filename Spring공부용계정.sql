CREATE TABLE AUTHORITIES(
    USER_NO NUMBER REFERENCES MEMBER,
    AUTHORITY VARCHAR2(15),
    PRIMARY KEY(USER_NO, AUTHORITY)
);

INSERT INTO authorities VALUES(10, 'ROLE_ADMIN');
INSERT INTO authorities VALUES(10, 'ROLE_USER');

COMMIT;
--------------
CREATE TABLE persistent_logins (
                username        VARCHAR(64)  NOT NULL,
                series          VARCHAR(64)  PRIMARY KEY,
                token           VARCHAR(64)  NOT NULL,
                last_used       TIMESTAMP    NOT NULL
            );

            CREATE INDEX idx_persistent_logins_username
            ON persistent_logins(username);
--------------
