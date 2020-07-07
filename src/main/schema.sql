create database oneShotWeb;

use oneShotWeb;

create table products (
`oneShot_id` bigint not null AUTO_INCREMENT comment '商品库存id',
`name` varchar(120) not null comment '商品名',
`number` int not null comment '库存数量',
`start_time` timestamp not null comment '秒杀起始时间',
`end_time` timestamp not null comment '秒杀结束时间',
`create_time` timestamp not null default current_timestamp comment '创建时间',
primary key (oneShot_id),
key index_start_time(start_time),
key index_end_time(end_time),
key index_create_time(create_time)
) engine=InnoDB auto_increment=1000 default charset=utf8 comment='秒杀库存表';

insert into products(name, number, start_time, end_time)
values ('switch动森限定', 100, '2020-07-05 00:00:00', '2020-07-06 00:00:00'),
('2077限定Xbox', 200,  '2020-07-05 00:00:00', '2020-07-06 00:00:00'),
('塞尔达大师之书', 1000,  '2020-07-05 00:00:00', '2020-07-06 00:00:00'),
('光明优加牛奶', 300,  '2020-07-05 00:00:00', '2020-07-06 00:00:00');

-- 用户登陆认证表
create table success_shot (
`oneShot_id` bigint not null comment '秒杀商品id',
`user_phone` bigint not null comment '用户手机号',
`state` tinyint not null default -1 comment '状态',
`create_time` timestamp not null default current_timestamp comment '创建时间',
primary key (oneShot_id, user_phone),
key index_create_time(create_time)
)engine=InnoDB default charset=utf8 comment='秒杀成功表';

