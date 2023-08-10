CREATE DATABASE `mybatis_plus` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

use `mybatis_plus`;

CREATE TABLE `t_user` (
                          `uid` bigint(20) NOT NULL COMMENT '主键ID',
                          `name` varchar(30) DEFAULT NULL COMMENT '姓名',
                          `age` int(11) DEFAULT NULL COMMENT '年龄',
                          `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
                          PRIMARY KEY (`uid`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

ALTER TABLE mybatis_plus.t_user MODIFY COLUMN uid bigint auto_increment NOT NULL COMMENT '主键ID';
ALTER TABLE mybatis_plus.t_user ADD is_deleted INT DEFAULT 0 NULL;
