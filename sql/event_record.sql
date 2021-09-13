



DROP TABLE IF EXISTS `t_event_record`;
CREATE TABLE `t_event_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '事件记录ID',
  `event_code` varchar(50) NOT NULL COMMENT '事件标识',
  `event_time` datetime NOT NULL COMMENT '事件时间',
  `distinct_id` varchar(32) NOT NULL DEFAULT '' COMMENT '独特的ID',
  `anonymous_id` varchar(32) NOT NULL DEFAULT '' COMMENT '匿名的ID',
  `summary` varchar(300) NOT NULL DEFAULT '' COMMENT '摘要',
  `client_id` varchar(40) NOT NULL DEFAULT '' COMMENT '客户端的ID',
  `client_app_id` varchar(40) NOT NULL DEFAULT '' COMMENT '客户端的应用的ID',
  `client_device_id` varchar(40) NOT NULL DEFAULT '' COMMENT '客户端的设备的ID',
  `client_user_agent` varchar(500) NOT NULL DEFAULT '' COMMENT '客户端的用户代理',
  `client_net_address` varchar(60) NOT NULL DEFAULT '' COMMENT '客户端的网络地址',
  `interface_id` varchar(100) NOT NULL DEFAULT '' COMMENT '被访问的接口的ID',
  `server_id` varchar(40) NOT NULL DEFAULT '' COMMENT '服务器的ID',
  `server_app_id` varchar(40) NOT NULL DEFAULT '' COMMENT '服务器的应用的ID',
  `properties_json` text COMMENT '属性JSON',
  `creator_id` varchar(32) DEFAULT 'system' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater_id` varchar(32) DEFAULT 'system' COMMENT '修改者',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `alive_flag` tinyint(4) DEFAULT '1' COMMENT '数据状态',
  PRIMARY KEY (`id`),
  KEY `idx_event_code` (`event_code`) USING BTREE,
  KEY `idx_event_time` (`event_time`) USING BTREE,
  KEY `idx_distinct_id` (`distinct_id`) USING BTREE,
  KEY `idx_anonymous_id` (`anonymous_id`) USING BTREE,
  KEY `idx_client_app_id` (`client_app_id`) USING BTREE,
  KEY `idx_client_net_address` (`client_net_address`) USING BTREE,
  KEY `idx_interface_id` (`interface_id`) USING BTREE,
  KEY `idx_server_id` (`server_id`) USING BTREE,
  KEY `idx_server_app_id` (`server_app_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000010001 DEFAULT CHARSET=utf8mb4 COMMENT='事件记录表';





