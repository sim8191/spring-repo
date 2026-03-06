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
-- BOARDE = 'N' OFFSET 0, LIMIT 10
SELECT * FROM(
SELECT ROWNUM AS RNUM, T1.*
FROM(
SELECT BOARD_NO,
			BOARD_TITLE, USER_NAME AS BOARD_WRITER,
			COUNT,
			CREATE_DATE
		FROM BOARD B
		LEFT JOIN MEMBER M ON BOARD_WRITER = USER_NO
        WHERE B.STATUS = 'Y' AND BOARD_CD = #{boardCd}
        ORDER BY BOARD_NO DESC) T1)
        WHERE RNUM >= 10 AND RNUM <= 20
--        OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;
        