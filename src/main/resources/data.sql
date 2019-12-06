use oomall;

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(31) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  `is_default` tinyint(1) unsigned DEFAULT '0',
  `is_enabled` tinyint(1) unsigned DEFAULT '0',
  `start_time` datetime(2) DEFAULT NULL,
  `end_time` datetime(2) DEFAULT NULL,
  `gmt_create` datetime(2) DEFAULT NULL,
  `gmt_modified` datetime(2) DEFAULT NULL,
  `is_deleted` tinyint(1) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
);

insert into ad(link, name, content, pic_url, is_default, is_enabled, start_time, end_time, gmt_create, gmt_modified, is_deleted) VALUES
(null,'活动 美食节','活动 美食节','https://designmodo.com/wp-content/uploads/2011/08/Vintage-Retro-Advertisements-32.jpg',
 0,0,'2008-08-08 22:28:21','2008-08-11 22:28:21',now(),now(),0);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(11) unsigned DEFAULT NULL,
  `ip` varchar(31) DEFAULT NULL,
  `type` tinyint(4) unsigned DEFAULT NULL,
  `action` varchar(63) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `gmt_create` datetime(2) DEFAULT NULL,
  `gmt_modified` datetime(2) DEFAULT NULL,
  `action_id` bigint(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
);

insert into log(admin_id, ip, type, action, status, gmt_create, gmt_modified, action_id) values
(100,'127.0.0.1',1,'登录',1,now(),now(),1),
(100,'127.0.0.1',1,'登录',0,now(),now(),1),
(100,'127.0.0.1',1,'退出',1,now(),now(),1);