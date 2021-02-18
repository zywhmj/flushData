
-- 创建数据库 vue_login
CREATE DATABASE vue_login;

-- p2p_member表
CREATE TABLE `p2p_member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `user_photo` varchar(150) COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像',
  `user_pass` char(32) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `user_type` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '用户类型 1：个人用户；2：企业用户',
  `user_email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `user_phone` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `user_level` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户等级',
  `level_active_time` int(10) DEFAULT NULL COMMENT '会员等级最新生效时间',
  `degrade_days` int(4) DEFAULT '0' COMMENT '会员等级持续降级天数',
  `credits` bigint(20) NOT NULL DEFAULT '0' COMMENT '经验值',
  `scores` bigint(20) NOT NULL DEFAULT '0' COMMENT '积分',
  `reg_time` int(10) unsigned NOT NULL COMMENT '注册时间',
  `reg_ip` varchar(15) COLLATE utf8_bin NOT NULL COMMENT '注册IP',
  `recommend_id` int(10) unsigned NOT NULL COMMENT '推荐人UID',
  `expand_num` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '推广码',
  `delicated_customer` bigint(20) DEFAULT NULL COMMENT '专属客服',
  `platform` varchar(15) COLLATE utf8_bin NOT NULL DEFAULT 'web' COMMENT '用户来源 web；wap；ios；android',
  `reg_from_seo` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '用户注册上一个页面地址',
  `user_from` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '注册来源平台',
  `fadada_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '法大大Id',
  `auto_sign_contract_id` int(10) DEFAULT NULL COMMENT '开启自动签署合同Id',
  `auto_sign_contract` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否自动签署合同 0：否；1：是',
  `borrower_auto_sign_contract_id` int(10) DEFAULT NULL COMMENT '借款人自动签署合同id',
  `client_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '个推使用clientid来标识每个独立的用户',
  `salt` varchar(12) COLLATE utf8_bin DEFAULT '' COMMENT '盐值',
  `username_update_time` int(10) unsigned DEFAULT NULL COMMENT '用户名修改次数',
  `free_withdraw_num` int(10) DEFAULT '0' COMMENT '免费提现次数',
  `channel` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '应用商店',
  `promote` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '渠道号',
  `plan_contract_id` int(10) DEFAULT NULL COMMENT '计划类产品授权委托书Id',
  `loan_user_phone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '旧标借款人手机号码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_p2p_members_user_name` (`user_name`),
  UNIQUE KEY `idx_p2p_members_user_phone` (`user_phone`,`user_type`),
  UNIQUE KEY `idx_p2p_members_user_email` (`user_email`,`user_type`),
  UNIQUE KEY `idx_p2p_members_expandnumunique` (`expand_num`),
  KEY `idx_p2p_members_reg_time` (`reg_time`),
  KEY `idx_p2p_members_recommend_id` (`recommend_id`),
  KEY `idx_p2p_members_user_level` (`user_level`),
  KEY `idx_p2p_members_client_id` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=732707 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- 插入p2p_member表数据
INSERT INTO `p2p_member` (`id`, `user_name`, `user_photo`, `user_pass`, `user_type`, `user_email`, `user_phone`, `user_level`, `level_active_time`, `degrade_days`, `credits`, `scores`, `reg_time`, `reg_ip`, `recommend_id`, `expand_num`, `delicated_customer`, `platform`, `reg_from_seo`, `user_from`, `fadada_id`, `auto_sign_contract_id`, `auto_sign_contract`, `borrower_auto_sign_contract_id`, `client_id`, `salt`, `username_update_time`, `free_withdraw_num`, `channel`, `promote`, `plan_contract_id`, `loan_user_phone`) VALUES('1','admin','Advert/20171224110028100010.png','a84978163760b2ed80a5b202295eb792','1','183341451@qq.com','18652044823','0','1498185000','0','2232425','500','1368555731','116.227.153.188','0','10',NULL,'',NULL,'rjs','762C99FA6D7008E8','2123','1','237574',NULL,'NgvTrGgHDL',NULL,'5',NULL,NULL,NULL,NULL);
INSERT INTO `p2p_member` (`id`, `user_name`, `user_photo`, `user_pass`, `user_type`, `user_email`, `user_phone`, `user_level`, `level_active_time`, `degrade_days`, `credits`, `scores`, `reg_time`, `reg_ip`, `recommend_id`, `expand_num`, `delicated_customer`, `platform`, `reg_from_seo`, `user_from`, `fadada_id`, `auto_sign_contract_id`, `auto_sign_contract`, `borrower_auto_sign_contract_id`, `client_id`, `salt`, `username_update_time`, `free_withdraw_num`, `channel`, `promote`, `plan_contract_id`, `loan_user_phone`) VALUES('3','sundflj','Advert/20171224110028100010.png','d69e34d475899835da97fe9fc89971a5','1','sundifeng@dlhdx.com',NULL,'0','1473435840','0','10','0','1368588645','59.45.68.18','0',NULL,NULL,'',NULL,'rjs',NULL,NULL,'0',NULL,NULL,'uWCLaHbCrD',NULL,'5',NULL,NULL,NULL,NULL);
INSERT INTO `p2p_member` (`id`, `user_name`, `user_photo`, `user_pass`, `user_type`, `user_email`, `user_phone`, `user_level`, `level_active_time`, `degrade_days`, `credits`, `scores`, `reg_time`, `reg_ip`, `recommend_id`, `expand_num`, `delicated_customer`, `platform`, `reg_from_seo`, `user_from`, `fadada_id`, `auto_sign_contract_id`, `auto_sign_contract`, `borrower_auto_sign_contract_id`, `client_id`, `salt`, `username_update_time`, `free_withdraw_num`, `channel`, `promote`, `plan_contract_id`, `loan_user_phone`) VALUES('4','毛美玲','Advert/20171224110028100010.png','13bc2102d8113cdc38a4685db12d8c35','1','522451386@qq.com','13926579100','0','1473435840','0','40','0','1368603822','117.136.32.46','0','43',NULL,'',NULL,'rjs',NULL,NULL,'0',NULL,NULL,'kKalPijyji',NULL,'5',NULL,NULL,NULL,NULL);
INSERT INTO `p2p_member` (`id`, `user_name`, `user_photo`, `user_pass`, `user_type`, `user_email`, `user_phone`, `user_level`, `level_active_time`, `degrade_days`, `credits`, `scores`, `reg_time`, `reg_ip`, `recommend_id`, `expand_num`, `delicated_customer`, `platform`, `reg_from_seo`, `user_from`, `fadada_id`, `auto_sign_contract_id`, `auto_sign_contract`, `borrower_auto_sign_contract_id`, `client_id`, `salt`, `username_update_time`, `free_withdraw_num`, `channel`, `promote`, `plan_contract_id`, `loan_user_phone`) VALUES('5','adalia','Advert/20171224110028100010.png','9f9f331e8ad75efef7402438a9fc1517','1','730401896@qq.com',NULL,'0','1473435840','0','40','0','1368604942','112.97.33.94','0','177',NULL,'',NULL,'rjs',NULL,NULL,'0',NULL,NULL,'SqDtuLwxLI',NULL,'5',NULL,NULL,NULL,NULL);
INSERT INTO `p2p_member` (`id`, `user_name`, `user_photo`, `user_pass`, `user_type`, `user_email`, `user_phone`, `user_level`, `level_active_time`, `degrade_days`, `credits`, `scores`, `reg_time`, `reg_ip`, `recommend_id`, `expand_num`, `delicated_customer`, `platform`, `reg_from_seo`, `user_from`, `fadada_id`, `auto_sign_contract_id`, `auto_sign_contract`, `borrower_auto_sign_contract_id`, `client_id`, `salt`, `username_update_time`, `free_withdraw_num`, `channel`, `promote`, `plan_contract_id`, `loan_user_phone`) VALUES('7','Eric2512','Advert/20171224110028100010.png','4c0e2aa36de0b2c78fee6272e688fff9','1',NULL,NULL,'0','1473435840','0','0','0','1368622930','113.103.8.235','0',NULL,NULL,'',NULL,'rjs','',NULL,'0',NULL,NULL,'GaiOMJIhSp',NULL,'5',NULL,NULL,NULL,NULL);
INSERT INTO `p2p_member` (`id`, `user_name`, `user_photo`, `user_pass`, `user_type`, `user_email`, `user_phone`, `user_level`, `level_active_time`, `degrade_days`, `credits`, `scores`, `reg_time`, `reg_ip`, `recommend_id`, `expand_num`, `delicated_customer`, `platform`, `reg_from_seo`, `user_from`, `fadada_id`, `auto_sign_contract_id`, `auto_sign_contract`, `borrower_auto_sign_contract_id`, `client_id`, `salt`, `username_update_time`, `free_withdraw_num`, `channel`, `promote`, `plan_contract_id`, `loan_user_phone`) VALUES('8','@qq_suwabe32736','Advert/20171224110028100010.png','5fe7bb51a1c27e2558ce49b5f4f24e61','1',NULL,NULL,'0','1473435840','0','0','0','1368677301','182.131.19.97','0',NULL,NULL,'',NULL,'rjs',NULL,NULL,'0',NULL,NULL,'YzcdawCtvh',NULL,'5',NULL,NULL,NULL,NULL);
INSERT INTO `p2p_member` (`id`, `user_name`, `user_photo`, `user_pass`, `user_type`, `user_email`, `user_phone`, `user_level`, `level_active_time`, `degrade_days`, `credits`, `scores`, `reg_time`, `reg_ip`, `recommend_id`, `expand_num`, `delicated_customer`, `platform`, `reg_from_seo`, `user_from`, `fadada_id`, `auto_sign_contract_id`, `auto_sign_contract`, `borrower_auto_sign_contract_id`, `client_id`, `salt`, `username_update_time`, `free_withdraw_num`, `channel`, `promote`, `plan_contract_id`, `loan_user_phone`) VALUES('9','@qq_angel43594','Advert/20171224110028100010.png','58ce85536e6aa6c88c069ca9392b4dbb','1',NULL,NULL,'0','1473435840','0','0','0','1368685245','116.205.33.156','0',NULL,NULL,'',NULL,'rjs',NULL,NULL,'0',NULL,NULL,'jSDWxvYCai',NULL,'5',NULL,NULL,NULL,NULL);
INSERT INTO `p2p_member` (`id`, `user_name`, `user_photo`, `user_pass`, `user_type`, `user_email`, `user_phone`, `user_level`, `level_active_time`, `degrade_days`, `credits`, `scores`, `reg_time`, `reg_ip`, `recommend_id`, `expand_num`, `delicated_customer`, `platform`, `reg_from_seo`, `user_from`, `fadada_id`, `auto_sign_contract_id`, `auto_sign_contract`, `borrower_auto_sign_contract_id`, `client_id`, `salt`, `username_update_time`, `free_withdraw_num`, `channel`, `promote`, `plan_contract_id`, `loan_user_phone`) VALUES('10','全超','Advert/20171224110028100010.png','785c35b63763bfef732f85b40bb44ef9','1','283841896@qq.com','13926544278','0','1473435840','0','919','0','1368689931','116.205.73.121','0','115704',NULL,'',NULL,'rjs','78E573F7DADF6848','49977','0',NULL,NULL,'SHqVIWcapS',NULL,'5',NULL,NULL,NULL,NULL);
INSERT INTO `p2p_member` (`id`, `user_name`, `user_photo`, `user_pass`, `user_type`, `user_email`, `user_phone`, `user_level`, `level_active_time`, `degrade_days`, `credits`, `scores`, `reg_time`, `reg_ip`, `recommend_id`, `expand_num`, `delicated_customer`, `platform`, `reg_from_seo`, `user_from`, `fadada_id`, `auto_sign_contract_id`, `auto_sign_contract`, `borrower_auto_sign_contract_id`, `client_id`, `salt`, `username_update_time`, `free_withdraw_num`, `channel`, `promote`, `plan_contract_id`, `loan_user_phone`) VALUES('11','shilexyz','Advert/20171224110028100010.png','cbe1928779a3b452362443fbc1260f79','1','shile-xyz520@1631.com',NULL,'0','1473435840','0','10','0','1368757437','116.205.33.156','0',NULL,NULL,'',NULL,'rjs',NULL,NULL,'0',NULL,NULL,'cEmCpHlhsg',NULL,'5',NULL,NULL,NULL,NULL);
INSERT INTO `p2p_member` (`id`, `user_name`, `user_photo`, `user_pass`, `user_type`, `user_email`, `user_phone`, `user_level`, `level_active_time`, `degrade_days`, `credits`, `scores`, `reg_time`, `reg_ip`, `recommend_id`, `expand_num`, `delicated_customer`, `platform`, `reg_from_seo`, `user_from`, `fadada_id`, `auto_sign_contract_id`, `auto_sign_contract`, `borrower_auto_sign_contract_id`, `client_id`, `salt`, `username_update_time`, `free_withdraw_num`, `channel`, `promote`, `plan_contract_id`, `loan_user_phone`) VALUES('12','zhangsan','Advert/20171224110028100010.png','cb12032c069098c2558ece19c9854704','1','454789783@qq.com',NULL,'0','1473435840','0','120','0','1368772543','116.205.33.156','0',NULL,NULL,'',NULL,'rjs',NULL,NULL,'0',NULL,NULL,'dKBOJiGWqm',NULL,'5',NULL,NULL,NULL,NULL);
