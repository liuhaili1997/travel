create table landscape
(
	id              bigint auto_increment,
	creator         bigint not null,
	title           varchar(128) not null,
	open_time       varchar(256) not null,
	address         varchar(256) not null,
	description     text not null,
	price           decimal,
	img_url         varchar(512) not null,
	view_count      bigint default 0,
	comment_count   bigint default 0,
	score           double,
	tag             varchar(256) not null,
	ctime           bigint not null,
	utime           bigint not null,
	constraint landscape_pk
		primary key (id)
);

comment on table landscape is '景区';

comment on column landscape.id is 'id';

comment on column landscape.creator is '管理员id';

comment on column landscape.title is '景区名';

comment on column landscape.open_time is '开放时间';

comment on column landscape.address is '地址';

comment on column landscape.description is '景区介绍';

comment on column landscape.price is '价钱，可以免费';

comment on column landscape.img_url is '照片';

comment on column landscape.view_count is '浏览人数';

comment on column landscape.comment_count is '评论人数';

comment on column landscape.score is '评分';

comment on column landscape.ctime is '创建时间';

comment on column landscape.utime is '更新时间';