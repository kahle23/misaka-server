



DROP TABLE IF EXISTS `t_bank_card_issuer`;
CREATE TABLE `t_bank_card_issuer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bank_name` varchar(50) NOT NULL COMMENT '银行名称',
  `organization_code` varchar(50) NOT NULL COMMENT '机构代码',
  `bank_card_name` varchar(50) NOT NULL COMMENT '银行卡名称',
  `bank_card_type` varchar(50) NOT NULL COMMENT '银行卡类型',
  `bank_card_number_length` varchar(50) NOT NULL COMMENT '银行卡号长度',
  `issuer_identification_number` varchar(50) NOT NULL COMMENT '发卡机构标识码',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `creator_id` varchar(32) NOT NULL COMMENT '创建者ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updater_id` varchar(32) NOT NULL COMMENT '更新者ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `alive_flag` tinyint(4) NOT NULL DEFAULT '1' COMMENT '数据状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001001 DEFAULT CHARSET=utf8mb4 COMMENT='银行卡发行商表';




