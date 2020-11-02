use artemis;
-- ----------------------------
-- Table structure for xl_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`        int(8) not null auto_increment comment 'id',
    `userid`    varchar(32) unique default null comment '用户id',
    `password`  varchar(64)        default null comment '密码',
    `username`  varchar(32)        default null comment '真实姓名',
    `email`     varchar(32)        default null comment '邮箱',
    `bu`        varchar(32)        default null comment '部门',
    `user_role` varchar(10)        default null comment '权限角色',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# DROP TABLE IF EXISTS `user_role`;
# CREATE TABLE `user_role` (
#                         `id` int auto_increment ,
#                         `user_role` varchar(10) not null unique ,
#                         `user_role_desc` varchar(10) default null,
#                         PRIMARY KEY (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of sysUser
-- ----------------------------
# INSERT INTO `sys_user` VALUES (1, 'eamon', '123QWEasd','唐一鸣','3467637442@qq.com','研发组','ADMIN');

-- ----------------------------
-- Records of xl_user_role
-- ----------------------------
# INSERT INTO `user_role` VALUES ('1', 'admin', '管理员');
# INSERT INTO `user_role` VALUES ('2', 'qa', '测试');