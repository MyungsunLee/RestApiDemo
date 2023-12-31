CREATE TABLE IF NOT EXISTS COMMENT
(
    ID int(11) AUTO_INCREMENT NOT NULL PRIMARY KEY,
    BOARD_ID int(11),
    PARENT_ID int(11),
    CREATE_DATE DATETIME(6) DEFAULT CURRENT_TIMESTAMP,
    UPDATE_DATE DATETIME(6) DEFAULT CURRENT_TIMESTAMP,
    DELETE_YN CHAR DEFAULT 'N',
    DELETE_DATE DATETIME(6),
    CONSTRAINT FK_BOARD_ID_FK FOREIGN KEY(BOARD_ID) REFERENCES BOARD(ID)
    );
CREATE SEQUENCE IF NOT EXISTS COMMENT_ID_SEQ START WITH 1 INCREMENT BY 1;