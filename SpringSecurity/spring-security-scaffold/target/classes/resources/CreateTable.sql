CREATE TABLE `user`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
    `user_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT 'USER NAME',
    `nick_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT 'NICK NAME',
    `password` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT 'PASSWORD',
    `status` CHAR(1) DEFAULT '0' COMMENT 'ACCOUNT STATUS (0:ACTIVE,1:INACTIVE)',
    `email` VARCHAR(64) DEFAULT 'NULL' COMMENT 'EMAIL',
    `phone_number` VARCHAR(32) DEFAULT 'NULL' COMMENT 'PHONE NUMBER',
    `sex` CHAR(1) DEFAULT NULL COMMENT 'SEX 0:Male 1:Female 2:Unknown',
    `avatar` VARCHAR(128) DEFAULT 'NULL' COMMENT 'AVATAR',
    `user_type` CHAR(1) NOT NULL DEFAULT '1' COMMENT 'USER TYPE(0:ADMINISTRATOR,1:USER)',
    `user_id` VARCHAR(32) DEFAULT 'NULL' COMMENT 'USER ID',
    `create_time` VARCHAR(32) DEFAULT 'NULL' COMMENT 'CREATE TIME',
    `update_time` VARCHAR(32) DEFAULT 'NULL' COMMENT 'UPDATE TIME',
    PRIMARY KEY(`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='USER TABLE'

# Test Data
INSERT INTO rhino_blog.USER (user_name,nick_name,password,status,sex) VALUES("Allen","GeekS","$2a$10$Gf9WKL1SOuiqLsbWSzFBC./TicaBXFR0yNybeze6FN61j/wELq5ya","0","0");

CREATE TABLE `sys_menu`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `menu_name` varchar(64) NOT NULL DEFAULT 'NULL' COMMENT 'MENU',
    `path` varchar(200) DEFAULT NULL COMMENT 'ROUTE PATH',
    `component` varchar(255) DEFAULT NULL COMMENT 'COMPONENT PATH',
    `visible` char(1) DEFAULT '0' COMMENT '0:visible 1:invisible',
    `status` char(1) DEFAULT '0' COMMENT '0:active 1:inactive',
    `perms` varchar(100) DEFAULT NULL COMMENT 'permission flag',
    `icon` varchar(100) DEFAULT '#' COMMENT 'menu symbol',
    `create_time` VARCHAR(32) DEFAULT 'NULL' COMMENT 'CREATE TIME',
    `update_time` VARCHAR(32) DEFAULT 'NULL' COMMENT 'UPDATE TIME',
    `remark` varchar(500) DEFAULT NULL COMMENT 'comment',
    PRIMARY KEY(`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='MENU TABLE'
INSERT INTO rhino_blog.sys_menu(id,menu_name,path,component,visible,status,perms,icon) VALUES(1,"Management","dept","system/dept/index",'0','0',"system/dept/index","#");
INSERT INTO rhino_blog.sys_menu(id,menu_name,path,component,visible,status,perms,icon) VALUES(1,"Test","test","system/test/index",'0','0',"system/test/index","#");

CREATE TABLE `sys_role` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(128) DEFAULT NULL,
    `role_key` varchar(100) DEFAULT NULL COMMENT 'Character Permission String',
    `status` char(1) DEFAULT '0' COMMENT '0:active 1:inactive',
    `create_time` VARCHAR(32) DEFAULT 'NULL' COMMENT 'CREATE TIME',
    `update_time` VARCHAR(32) DEFAULT 'NULL' COMMENT 'UPDATE TIME',
    `remark` varchar(500) DEFAULT NULL COMMENT 'comment',
    PRIMARY KEY(`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='MENU TABLE'
INSERT INTO rhino_blog.sys_role(id,name,role_key,status) VALUES(1,"CEO","ceo",'0');
INSERT INTO rhino_blog.sys_role(id,name,role_key,status) VALUES(2,"Coder","coder",'0');

CREATE TABLE `sys_role_menu`(
    `role_id` bigint(200) NOT NULL AUTO_INCREMENT COMMENT 'Character Id',
    `menu_id` bigint(200) NOT NULL DEFAULT '0' COMMENT 'Menu Id',
    PRIMARY KEY(`role_id`,`menu_id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='MENU TABLE'
INSERT INTO rhino_blog.sys_role_menu(role_id,menu_id) VALUE(1,1);
INSERT INTO rhino_blog.sys_role_menu(role_id,menu_id) VALUE(1,2);

CREATE TABLE `sys_user`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
    `user_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT 'USER NAME',
    `nick_name` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT 'NICK NAME',
    `password` VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT 'PASSWORD',
    `status` CHAR(1) DEFAULT '0' COMMENT 'ACCOUNT STATUS (0:ACTIVE,1:INACTIVE)',
    `email` VARCHAR(64) DEFAULT 'NULL' COMMENT 'EMAIL',
    `phone_number` VARCHAR(32) DEFAULT 'NULL' COMMENT 'PHONE NUMBER',
    `sex` CHAR(1) DEFAULT NULL COMMENT 'SEX 0:Male 1:Female 2:Unknown',
    `avatar` VARCHAR(128) DEFAULT 'NULL' COMMENT 'AVATAR',
    `user_type` CHAR(1) NOT NULL DEFAULT '1' COMMENT 'USER TYPE(0:ADMINISTRATOR,1:USER)',
    `user_id` VARCHAR(32) DEFAULT 'NULL' COMMENT 'USER ID',
    `create_time` VARCHAR(32) DEFAULT 'NULL' COMMENT 'CREATE TIME',
    `update_time` VARCHAR(32) DEFAULT 'NULL' COMMENT 'UPDATE TIME',
    PRIMARY KEY(`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='USER TABLE'

CREATE TABLE `sys_user_role` (
    `user_id` bigint(200) NOT NULL AUTO_INCREMENT COMMENT 'user Id',
    `role_id` bigint(200) NOT NULL DEFAULT '0' COMMENT 'character Id',
    PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO rhino_blog.sys_user_role (user_id,role_id) values(2,1);