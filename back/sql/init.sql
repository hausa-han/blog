-- -usage: sudo mysql -u root -p < xx.sql

use blog;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `created` datetime not null,
  `updated` datetime not null,
  `email` varchar(64) not null,
  `last_login` datetime not null,
  `statu` int(5) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Hausa_', '$2a$10$n2vGPN1iUwGq97fw7mtbFe80jwX0i9fWJdYvvBS/exjuGumuJPfPC', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '572157852@qq.com', '2021-11-14 00:00:00', '0');


-- ---------------------------
-- Table structure for role
-- ---------------------------
drop table if exists `role`;
create table `role` (
  `id` int(11) not null auto_increment,
  `name` varchar(64) not null,
  `code` varchar(64) not null,
  `remark` varchar(255) default null,
  `created` datetime not null,
  `updated` datetime default null,
  `statu` int(5) not null,
  primary key (`id`),
  unique key `name` (`name`) using btree,
  unique key `code` (`code`) using btree
) engine=InnoDB auto_increment=3 default charset=utf8;
-- --------------------------
-- Records of role
-- --------------------------
-- -
insert into `role` values ('1', 'admin', 'admin', 'admin', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `role` values ('2', 'visitor', 'visitor', 'visitor', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');

-- ---------------------------
-- Table structure for user_role
-- ---------------------------
drop table if exists `user_role`;
create table `user_role` (
  `id` int(11) not null auto_increment,
  `user_id` int(11) not null,
  `role_id` int(11) not null,
  primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=utf8;
-- --------------------------
-- Records of user_role
-- --------------------------
-- -
insert into `user_role` values ('1', '1', '1');



-- --------------------------
-- Table structure for role_menu
-- --------------------------
drop table if exists `role_menu`;
create table `role_menu` (
  `id` int(11) not null auto_increment,
  `role_id` int(11) not null,
  `menu_id` int(11) not null,
  primary key (`id`)
) engine=InnoDB auto_increment=3 default charset=utf8;
-- --------------------------
-- Record of role_menu
-- -
insert into `role_menu` values ('1', '1', '1');
insert into `role_menu` values ('2', '2', '1');
insert into `role_menu` values ('3', '2', '2');
insert into `role_menu` values ('4', '2', '3');
insert into `role_menu` values ('5', '2', '4');
insert into `role_menu` values ('6', '2', '5');
insert into `role_menu` values ('7', '2', '6');
insert into `role_menu` values ('8', '2', '7');
insert into `role_menu` values ('9', '2', '8');
insert into `role_menu` values ('10', '2', '9');
insert into `role_menu` values ('11', '2', '10');
insert into `role_menu` values ('12', '2', '11');
insert into `role_menu` values ('13', '2', '12');
insert into `role_menu` values ('14', '2', '13');
insert into `role_menu` values ('15', '2', '14');
insert into `role_menu` values ('16', '2', '15');
insert into `role_menu` values ('17', '2', '16');
insert into `role_menu` values ('18', '2', '17');

-- ---------------------------
-- Table structure for menu
-- ---------------------------
drop table if exists `menu`;
create table `menu` (
  `id` int(11) not null auto_increment,
  `parent_id` bigint(20) default null,
  `name` varchar(64) not null,
  `path` varchar(255) not null,
  `perms` varchar(255) default null comment 'for auth, such as: user:list,user:create, view create change delete fullis: list',
  `component` varchar(255) not null,
  `type` int(5) not null comment 'types, 0:directory, 1:menu, 2:button',
  `orderNum` int(11) default null comment 'order',
  `created` datetime not null,
  `updated` datetime not null,
  `statu` int(5) not null,
  primary key (`id`),
  unique key `name` (`name`) using BTREE
) engine=InnoDB auto_increment=4 default charset=utf8;
-- --------------------------
-- Record of menu
-- -
insert into `menu` values ('1', '0', 'Development', '/index', 'admin:list', 'AppIndex', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('2', '1', 'DevelopmentAlgorithm', '/development/algorithm', 'visitor:view', 'common/mainviews/DevelopAlgorithm', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('3', '1', 'DevelopmentWeb', '/development/web', 'visitor:view', 'common/mainviews/DevelopWeb', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('4', '1', 'DevelopmentIot', '/development/iot', 'visitor:view', 'common/mainviews/DevelopIot', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('5', '1', 'DevelopmentPython', '/development/python', 'visitor:view', 'common/mainviews/DevelopPython', '0', '1', '2021-11-14 00:00:00', '0', '1', '2021-11-14 00:00:00', '0');
insert into `menu` values ('6', '0', 'Security', '/index', 'visitor:view', 'AppIndex', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('7', '6', 'SecurityCtf', '/security/ctf', 'visitor:view', 'common/mainviews/SecurityCtf', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('8', '6', 'SecurityWeb', '/security/web', 'visitor:view', 'common/mainviews/SecurityWeb', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('9', '6', 'SecurityPentest', '/security/pentest', 'visitor:view', 'common/mainviews/SecurityPentest', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('10', '0', 'Misc', '/index', 'visitor:view', 'AppIndex', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('11', '10', 'MiscReading', '/misc/reading', 'visitor:view', 'common/mainviews/MiscReading', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('12', '10', 'MiscThinking', '/misc/thinking', 'visitor:view', 'common/mainviews/MiscThinking', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('13', '10', 'MiscInteresting', '/misc/interesting', 'visitor:view', 'common/mainviews/MiscInteresting', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('14', '0', 'Category', '/category', 'visitor:view', 'common/mainviews/Category', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('15', '0', 'Column', '/column', 'visitor:view', 'common/mainviews/Column', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('16', '0', 'Friendlink', '/friendlink', 'visitor:view', 'common/mainviews/FriendLink', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');
insert into `menu` values ('17', '0', 'Reward', '/reward', 'visitor:view', 'common/mainviews/Reward', '0', '1', '2021-11-14 00:00:00', '2021-11-14 00:00:00', '0');


-- --------------------------
-- - Table structure for posts
-- --------------------------
-- - 1: normal,  2: draft,  3: rubbish
-- --------------------------
drop table if exists `post`;
create table `post` (
  `id` int(11) not null auto_increment,
  `title` varchar(255) not null,
  `src` varchar(64) not null,
  `created` datetime not null,
  `updated` datetime not null,
  `password` varchar(255) default null,
  `statu` int(5) not null,
  `read_times` int(11) not null,
  `like_times` int(11) not null,
  primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=utf8;


-- --------------------------
-- - Table structure for categpry
-- --------------------------
drop table if exists `category`;
create table `category` (
  `id` int(11) not null auto_increment,
  `name` varchar(255) not null,
  `created` datetime not null,
  `read_times` int(11) not null,
  `like_times` int(11) not null,
  primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=utf8;


-- --------------------------
-- - Table structure for post_cate
-- --------------------------
drop table if exists `post_cate`;
create table `post_cate` (
 `id` int(11) not null auto_increment,
 `post_id` int(11) not null,
 `category_id` int(11) not null,
  primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=utf8;

















