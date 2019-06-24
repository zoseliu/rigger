DROP TABLE IF EXISTS `lg_worker_info`;
DROP TABLE IF EXISTS `lg_worker_tag_info`;
DROP TABLE IF EXISTS `lg_worker_tag`;
DROP TABLE IF EXISTS `lg_worker_rates`;
DROP TABLE IF EXISTS `lg_worker_image`;
DROP TABLE IF EXISTS `lg_worker_area_info`;
DROP TABLE IF EXISTS `lg_worker_content`;
DROP TABLE IF EXISTS `lg_employer_addr`;
DROP TABLE IF EXISTS `lg_worker_area`;
DROP TABLE IF EXISTS `lg_employer_info`;

CREATE TABLE `lg_worker_info` (
`user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '微信用户ID',
`openid` varchar(50) NULL COMMENT '微信openid',
`nick_name` varchar(50) NULL COMMENT '用户昵称',
`status` char(1) NULL COMMENT '状态(1:提交申请 0:申请完成)',
`image_addr` varchar(255) NULL COMMENT '用户头像地址',
`sex` char(1) NULL COMMENT '性别(1:男 2:女 3:未知)',
`user_addr` varchar(100) NULL COMMENT '用户地址',
`phone_num` varchar(11) NULL COMMENT '联系电话',
`user_intro` varchar(255) NULL COMMENT '用户简介',
`create_time` datetime NULL COMMENT '创建时间',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`is_delete` char(1) NULL COMMENT '是否删除(0:未删除 1:已删除)',
PRIMARY KEY (`user_id`) 
)
COMMENT = '零工用户信息';
CREATE TABLE `lg_worker_tag_info` (
`tag_id` int(11) NOT NULL COMMENT 'service_id',
`tag_type` char(1) NULL COMMENT '服务类别(1:服务项目 2:服务工种)',
`tag_name` varchar(50) NULL COMMENT '服务名称',
`parent_id` int(11) NULL COMMENT '父id',
`create_time` datetime NULL COMMENT '创建时间',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`is_delete` char(1) NULL COMMENT '是否删除(0:未删除 1:已删除)',
PRIMARY KEY (`tag_id`) 
)
COMMENT = '标签信息';
CREATE TABLE `lg_worker_tag` (
`user_tag_id` int(11) NOT NULL COMMENT '用户服务关系id',
`user_id` int(11) NULL COMMENT '用户id',
`tag_id` int(11) NULL COMMENT '服务id',
`create_time` datetime NULL COMMENT '创建时间',
PRIMARY KEY (`user_tag_id`) 
)
COMMENT = '用户标签关系';
CREATE TABLE `lg_worker_rates` (
`rates_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'rates_id',
`user_id` int(11) NULL COMMENT '用户id',
`rates_type` char(1) NULL COMMENT '收费标准类型(1:服务条目 2:销售配件)',
`rates_name` varchar(100) NULL COMMENT '收费名称',
`rates_desc` varchar(100) NULL COMMENT '收费标准',
`price` bigint(20) NULL COMMENT '价格:单位分',
`create_time` datetime NULL COMMENT '创建时间',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`is_delete` char(1) NULL COMMENT '是否删除(0:未删除 1:已删除)',
PRIMARY KEY (`rates_id`) 
)
COMMENT = '用户收费标准';
CREATE TABLE `lg_worker_image` (
`image_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户简介图片',
`user_id` int(11) NOT NULL COMMENT 'wxuser表中user_id',
`image_addr` varchar(255) NULL COMMENT '图片地址',
`show_order` int(11) NULL COMMENT '排序',
`image_type` char(1) NULL COMMENT '证件照类型(1:正面 2:背面 3:手持身份证 4:其他证件照 5:个人简介 6:服务内容)',
`create_time` datetime NULL COMMENT '创建时间',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`is_delete` char(1) NULL COMMENT '是否删除(0:未删除 1:已删除)',
PRIMARY KEY (`image_id`) 
)
COMMENT = '用户证件照片';
CREATE TABLE `lg_worker_area_info` (
`area_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'area_id',
`area_name` varchar(50) NULL COMMENT '服务区域',
`create_time` datetime NULL COMMENT '创建时间',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`is_delete` char(1) NULL COMMENT '是否删除(0:未删除 1:已删除)',
PRIMARY KEY (`area_id`) 
)
COMMENT = '区域信息';
CREATE TABLE `lg_worker_content` (
`user_tag_id` int(11) NOT NULL COMMENT '用户服务关系id',
`user_id` int(11) NULL COMMENT '用户id',
`content_desc` text NULL COMMENT '服务内容',
`create_time` datetime NULL COMMENT '创建时间',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`is_delete` char(1) NULL COMMENT '是否删除(0:未删除 1:已删除)',
PRIMARY KEY (`user_tag_id`) 
)
COMMENT = '用户服务内容';
CREATE TABLE `lg_employer_addr` (
`addr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'area_id',
`user_id` int(11) NULL COMMENT '用户id',
`street` varchar(100) NULL COMMENT '街道名称',
`room_number` varchar(100) NULL COMMENT '房间号',
`user_name` varchar(50) NULL COMMENT '用户名称',
`phone_num` varchar(20) NULL COMMENT '联系方式',
`is_default` char(255) NULL COMMENT '是否默认(1:是 0:否)',
`create_time` datetime NULL COMMENT '创建时间',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`is_delete` char(1) NULL COMMENT '是否删除(0:未删除 1:已删除)',
PRIMARY KEY (`addr_id`) 
)
COMMENT = '雇主地址信息
';
CREATE TABLE `lg_worker_area` (
`user_area_id` int(11) NOT NULL COMMENT '用户区域关系id',
`user_id` int(11) NULL COMMENT '用户id',
`area_id` int(11) NULL COMMENT '服务id',
`create_time` datetime NULL COMMENT '创建时间',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`is_delete` char(1) NULL COMMENT '是否删除(0:未删除 1:已删除)',
PRIMARY KEY (`user_area_id`) 
)
COMMENT = '用户区域关系';
CREATE TABLE `lg_employer_info` (
`user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '微信用户ID',
`openid` varchar(50) NULL COMMENT '微信openid',
`nick_name` varchar(50) NULL COMMENT '用户昵称',
`status` char(1) NULL COMMENT '状态(1:提交申请 0:申请完成)',
`image_addr` varchar(255) NULL COMMENT '用户头像地址',
`sex` char(1) NULL COMMENT '性别(1:男 2:女 3:未知)',
`create_time` datetime NULL COMMENT '创建时间',
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`is_delete` char(1) NULL COMMENT '是否删除(0:未删除 1:已删除)',
PRIMARY KEY (`user_id`) 
)
COMMENT = '雇主用户信息';

