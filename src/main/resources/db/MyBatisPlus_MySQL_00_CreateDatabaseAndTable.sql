CREATE
DATABASE `mybatis_plus` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

use
`mybatis_plus`;
-- 用户表
CREATE TABLE `t_user`
(
    `uid`   bigint(20) NOT NULL COMMENT '主键ID',
    `name`  varchar(30) DEFAULT NULL COMMENT '姓名',
    `age`   int(11) DEFAULT NULL COMMENT '年龄',
    `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (`uid`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

ALTER TABLE mybatis_plus.t_user MODIFY COLUMN uid bigint auto_increment NOT NULL COMMENT '主键ID';
ALTER TABLE mybatis_plus.t_user
    ADD is_deleted INT DEFAULT 0 NULL;

-- 商品表
CREATE TABLE t_product
(
    id      BIGINT(20) NOT NULL COMMENT '主键ID',
    NAME    VARCHAR(30) NULL DEFAULT NULL COMMENT '商品名称',
    price   INT(11) DEFAULT 0 COMMENT '价格',
    VERSION INT(11) DEFAULT 0 COMMENT '乐观锁版本号',
    PRIMARY KEY (id)
);