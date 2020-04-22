create table hotel
(
	id              bigint auto_increment,
	name            varchar(256) not null,
	creator         bigint not null,
	score           double,
	address         varchar(256) not null,
	price           decimal not null,
	description     text not null,
	comment_count   bigint default 0,
	view_count      bigint default 0,
	tag             varchar(256) not null,
	ctime           bigint not null,
	utime           bigint not null
);

comment on table hotel is '酒店';

comment on column hotel.id is 'id';

comment on column hotel.name is '名字';

comment on column hotel.score is '评分';

comment on column hotel.creator is '与user中accountId一致';

comment on column hotel.address is '地址';

comment on column hotel.price is '价钱';

comment on column hotel.description is '描述';

comment on column hotel.comment_count is '评论数';

comment on column hotel.view_count is '浏览数';

comment on column hotel.tag is '标签';

comment on column hotel.ctime is '创建时间';

comment on column hotel.utime is '更新时间';

