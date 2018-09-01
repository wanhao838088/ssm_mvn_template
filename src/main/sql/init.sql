CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm_template` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `ssm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `mobile` char(11) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `login_token` varchar(40) DEFAULT NULL,
  `head_img_url` mediumtext,
  `register_time` datetime DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `ssm_user` */

insert  into `ssm_user`(`id`,`username`,`mobile`,`password`,`login_token`,`head_img_url`,`register_time`,`login_time`,`is_delete`) values (1,'yihao','13566677788','1111','wwwww',NULL,NULL,NULL,0),(2,'erhao','13566677789','2222',NULL,NULL,NULL,NULL,0),(3,'sa','13566677788','33333',NULL,NULL,NULL,NULL,0);
