create table user
(
	id          bigint auto_increment,
	accountId   bigint not null,
	name        varchar(36) not null,
	phone       varchar(36),
	password    varchar(128) not null,
	avatar_url  varchar(512),
	email       varchar(128) not null,
	token       char(36) not null,
	type        int not null,
	ctime       bigint not null,
	utime       bigint not null,
	constraint user_pk
		primary key (id)
);

comment on table user is '用户';

comment on column user.id is 'id';

comment on column user.accountId is '账户id';

comment on column user.name is '姓名';

comment on column user.phone is '电话';

comment on column user.password is '密码';

comment on column user.avatar_url is '头像';

comment on column user.email is '邮箱';

comment on column user.token is 'token';

comment on column user.type is '类型 0：普通人 1：管理者';

comment on column user.ctime is '创建时间';

comment on column user.utime is '更新时间';