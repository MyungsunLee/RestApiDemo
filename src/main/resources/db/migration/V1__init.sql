CREATE TABLE IF NOT EXISTS `MEMBERS` (
                           `MEMBER_ID` int(11) NOT NULL AUTO_INCREMENT,
                           `CREATE_DATE` datetime(6) DEFAULT CURRENT_TIMESTAMP,
                           `DELETE_YN` char(1) DEFAULT 'N',
                           `MEMBER_NAME` varchar(255) DEFAULT NULL,
                           `PASSWORD` varchar(255) NOT NULL,
                           `UPDATE_DATE` datetime(6) DEFAULT CURRENT_TIMESTAMP,
                           PRIMARY KEY (`MEMBER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
CREATE SEQUENCE IF NOT EXISTS MEMBER_ID_SEQ START WITH 1 INCREMENT BY 1;