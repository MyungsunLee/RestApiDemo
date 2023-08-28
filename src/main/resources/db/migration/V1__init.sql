CREATE TABLE IF NOT EXISTS `members` (
                           `member_id` int(11) NOT NULL AUTO_INCREMENT,
                           `create_date` datetime(6) NOT NULL,
                           `delete_yn` char(1) NOT NULL,
                           `member_name` varchar(255) DEFAULT NULL,
                           `password` varchar(255) NOT NULL,
                           `update_date` datetime(6) DEFAULT NULL,
                           PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
CREATE SEQUENCE IF NOT EXISTS MEMBER_ID_SEQ START WITH 1 INCREMENT BY 1;