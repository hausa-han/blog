-- -usage: sudo mysql -u root -p < xx.sql
USE
blog;-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE
    IF
    EXISTS `user`;
CREATE TABLE `user`
(
    `id`         INT ( 11 ) UNSIGNED NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(255) DEFAULT NULL,
    `password`   VARCHAR(255) DEFAULT NULL,
    `created`    datetime    NOT NULL,
    `updated`    datetime    NOT NULL,
    `email`      VARCHAR(64) NOT NULL,
    `last_login` datetime    NOT NULL,
    `statu`      INT ( 5 ) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8;
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (''1 '', ''Hausa_'', ''$2a$10$n2vGPN1iUwGq97fw7mtbFe80jwX0i9fWJdYvvBS/exjuGumuJPfPC'',
        ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''572157852@qq.com'', ''2021 - 11 - 14 00:00:00'',
        ''0 '');
-- ---------------------------
-- Table structure for role
-- ---------------------------
DROP TABLE
    IF
    EXISTS `role`;
CREATE TABLE `role`
(
    `id`      INT ( 11 ) NOT NULL auto_increment,
    `name`    VARCHAR(64) NOT NULL,
    `code`    VARCHAR(64) NOT NULL,
    `remark`  VARCHAR(255) DEFAULT NULL,
    `created` datetime    NOT NULL,
    `updated` datetime     DEFAULT NULL,
    `statu`   INT ( 5 ) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` ( `name` ) USING BTREE,
    UNIQUE KEY `code` ( `code` ) USING BTREE
) ENGINE = INNODB auto_increment = 3 DEFAULT charset = utf8;
-- --------------------------
-- Records of role
-- --------------------------
-- -
INSERT INTO `role`
VALUES (''1 '', ''admin'', ''admin'', ''admin'', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
INSERT INTO `role`
VALUES (''2 '', ''visitor'', ''visitor'', ''visitor'', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'',
        ''0 '');
-- ---------------------------
-- Table structure for user_role
-- ---------------------------
DROP TABLE
    IF
    EXISTS `user_role`;
CREATE TABLE `user_role`
(
    `id`      INT ( 11 ) NOT NULL auto_increment,
    `user_id` INT ( 11 ) NOT NULL,
    `role_id` INT ( 11 ) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = INNODB auto_increment = 1 DEFAULT charset = utf8;
-- --------------------------
-- Records of user_role
-- --------------------------
-- -
INSERT INTO `user_role`
VALUES (''1 '', ''1 '', ''1 '');
-- --------------------------
-- Table structure for role_menu
-- --------------------------
DROP TABLE
    IF
    EXISTS `role_menu`;
CREATE TABLE `role_menu`
(
    `id`      INT ( 11 ) NOT NULL auto_increment,
    `role_id` INT ( 11 ) NOT NULL,
    `menu_id` INT ( 11 ) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = INNODB auto_increment = 3 DEFAULT charset = utf8;
-- --------------------------
-- Record of role_menu
-- -
INSERT INTO `role_menu`
VALUES (''1 '', ''1 '', ''1 '');
INSERT INTO `role_menu`
VALUES (''2 '', ''2 '', ''1 '');
INSERT INTO `role_menu`
VALUES (''3 '', ''2 '', ''2 '');
INSERT INTO `role_menu`
VALUES (''4 '', ''2 '', ''3 '');
INSERT INTO `role_menu`
VALUES (''5 '', ''2 '', ''4 '');
INSERT INTO `role_menu`
VALUES (''6 '', ''2 '', ''5 '');
INSERT INTO `role_menu`
VALUES (''7 '', ''2 '', ''6 '');
INSERT INTO `role_menu`
VALUES (''8 '', ''2 '', ''7 '');
INSERT INTO `role_menu`
VALUES (''9 '', ''2 '', ''8 '');
INSERT INTO `role_menu`
VALUES (''10 '', ''2 '', ''9 '');
INSERT INTO `role_menu`
VALUES (''11 '', ''2 '', ''10 '');
INSERT INTO `role_menu`
VALUES (''12 '', ''2 '', ''11 '');
INSERT INTO `role_menu`
VALUES (''13 '', ''2 '', ''12 '');
INSERT INTO `role_menu`
VALUES (''14 '', ''2 '', ''13 '');
INSERT INTO `role_menu`
VALUES (''15 '', ''2 '', ''14 '');
INSERT INTO `role_menu`
VALUES (''16 '', ''2 '', ''15 '');
INSERT INTO `role_menu`
VALUES (''17 '', ''2 '', ''16 '');
INSERT INTO `role_menu`
VALUES (''18 '', ''2 '', ''17 '');
-- ---------------------------
-- Table structure for menu
-- ---------------------------
DROP TABLE
    IF
    EXISTS `menu`;
CREATE TABLE `menu`
(
    `id`        INT ( 11 ) NOT NULL auto_increment,
    `parent_id` BIGINT ( 20 ) DEFAULT NULL,
    `name`      VARCHAR(64)  NOT NULL,
    `path`      VARCHAR(255) NOT NULL,
    `perms`     VARCHAR(255) DEFAULT NULL COMMENT '' for auth,
    such as: user :list,
    user:create,
    view create change delete fullis: list '',
    `component` VARCHAR(255) NOT NULL,
    `type`      INT ( 5 ) NOT NULL COMMENT '' types, 0
    :
    directory, 1
    :
    menu, 2
    :
    button
    '',
    `orderNum`  INT ( 11 ) DEFAULT NULL COMMENT '' order '',
    `created`   datetime     NOT NULL,
    `updated`   datetime     NOT NULL,
    `statu`     INT ( 5 ) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` ( `name` ) USING BTREE
) ENGINE = INNODB auto_increment = 4 DEFAULT charset = utf8;
-- --------------------------
-- Record of menu
-- -
INSERT INTO `menu`
VALUES (''1 '', ''0 '', ''Development'', '' / index '', ''admin:list'', ''AppIndex'', ''0 '', ''1 '',
        ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
INSERT INTO `menu`
VALUES (''2 '', ''1 '', ''DevelopmentAlgorithm'', '' / development / algorithm '', ''visitor:view'',
        ''common/mainviews/DevelopAlgorithm'', ''0 '', ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'',
        ''0 '');
INSERT INTO `menu`
VALUES (''3 '', ''1 '', ''DevelopmentWeb'', '' / development / web '', ''visitor:view'',
        ''common/mainviews/DevelopWeb'', ''0 '', ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'',
        ''0 '');
INSERT INTO `menu`
VALUES (''4 '', ''1 '', ''DevelopmentIot'', '' / development / iot '', ''visitor:view'',
        ''common/mainviews/DevelopIot'', ''0 '', ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'',
        ''0 '');
INSERT INTO `menu`
VALUES (''5 '', ''1 '', ''DevelopmentPython'', '' / development / python '', ''visitor:view'',
        ''common/mainviews/DevelopPython'', ''0 '', ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'',
        ''0 '');
INSERT INTO `menu`
VALUES (''6 '', ''0 '', ''Security'', '' / index '', ''visitor:view'', ''AppIndex'', ''0 '', ''1 '',
        ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
INSERT INTO `menu`
VALUES (''7 '', ''6 '', ''SecurityCtf'', '' / security / ctf '', ''visitor:view'', ''common/mainviews/SecurityCtf'',
        ''0 '', ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
INSERT INTO `menu`
VALUES (''8 '', ''6 '', ''SecurityWeb'', '' / security / web '', ''visitor:view'', ''common/mainviews/SecurityWeb'',
        ''0 '', ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
INSERT INTO `menu`
VALUES (''9 '', ''6 '', ''SecurityPentest'', '' / security / pentest '', ''visitor:view'',
        ''common/mainviews/SecurityPentest'', ''0 '', ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'',
        ''0 '');
INSERT INTO `menu`
VALUES (''10 '', ''0 '', ''Misc'', '' / index '', ''visitor:view'', ''AppIndex'', ''0 '', ''1 '',
        ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
INSERT INTO `menu`
VALUES (''11 '', ''10 '', ''MiscReading'', '' / misc / reading '', ''visitor:view'', ''common/mainviews/MiscReading'',
        ''0 '', ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
INSERT INTO `menu`
VALUES (''12 '', ''10 '', ''MiscThinking'', '' / misc / thinking '', ''visitor:view'',
        ''common/mainviews/MiscThinking'', ''0 '', ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'',
        ''0 '');
INSERT INTO `menu`
VALUES (''13 '', ''10 '', ''MiscInteresting'', '' / misc / interesting '', ''visitor:view'',
        ''common/mainviews/MiscInteresting'', ''0 '', ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'',
        ''0 '');
INSERT INTO `menu`
VALUES (''14 '', ''0 '', ''Category'', '' / category '', ''visitor:view'', ''common/mainviews/Category'', ''0 '',
        ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
INSERT INTO `menu`
VALUES (''15 '', ''0 '', ''Column'', '' / column '', ''visitor:view'', ''common/mainviews/Column'', ''0 '', ''1 '',
        ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
INSERT INTO `menu`
VALUES (''16 '', ''0 '', ''Friendlink'', '' / friendlink '', ''visitor:view'', ''common/mainviews/FriendLink'', ''0 '',
        ''1 '', ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
INSERT INTO `menu`
VALUES (''17 '', ''0 '', ''Reward'', '' / reward '', ''visitor:view'', ''common/mainviews/Reward'', ''0 '', ''1 '',
        ''2021 - 11 - 14 00:00:00'', ''2021 - 11 - 14 00:00:00'', ''0 '');
-- --------------------------
-- - Table structure for posts
-- --------------------------
-- - 1: normal,  2: draft,  3: rubbish
-- --------------------------
DROP TABLE
    IF
    EXISTS `post`;
CREATE TABLE `post`
(
    `id`         INT ( 11 ) NOT NULL auto_increment,
    `title`      VARCHAR(255) NOT NULL,
    `src`        VARCHAR(64)  NOT NULL,
    `created`    datetime     NOT NULL,
    `updated`    datetime     NOT NULL,
    `password`   VARCHAR(255) DEFAULT NULL,
    `statu`      INT ( 5 ) NOT NULL,
    `read_times` INT ( 11 ) NOT NULL,
    `like_times` INT ( 11 ) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = INNODB auto_increment = 1 DEFAULT charset = utf8;
-- --------------------------
-- - Table structure for categpry
-- --------------------------
DROP TABLE
    IF
    EXISTS `category`;
CREATE TABLE `category`
(
    `id`         INT ( 11 ) NOT NULL auto_increment,
    `name`       VARCHAR(255) NOT NULL,
    `created`    datetime     NOT NULL,
    `read_times` INT ( 11 ) NOT NULL,
    `like_times` INT ( 11 ) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = INNODB auto_increment = 1 DEFAULT charset = utf8;
-- --------------------------
-- - Table structure for post_cate
-- --------------------------
DROP TABLE
    IF
    EXISTS `post_cate`;
CREATE TABLE `post_cate`
(
    `id`          INT ( 11 ) NOT NULL auto_increment,
    `post_id`     INT ( 11 ) NOT NULL,
    `category_id` INT ( 11 ) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = INNODB auto_increment = 1 DEFAULT charset = utf8;
