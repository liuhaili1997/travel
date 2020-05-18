create table reservation
(
	id          bigint auto_increment,
	user_id     bigint not null,
	view_id     bigint not null,
	view_name   varchar(128) not null,
	view_price  DECIMAL,
	user_name   varchar(36) not null,
	email       varchar(128) not null,
	phone       varchar(36),
	ctime       bigint not null,
	utime       bigint not null,
	constraint reservation_pk
		primary key (id)
);

comment on column reservation.user_id is 'accountId';

comment on column reservation.view_id is 'view表的ID';

comment on column reservation.view_name is '景区名称';

comment on column reservation.view_price is '价格';

comment on column reservation.email is '邮箱';

comment on column reservation.ctime is '创建时间';

comment on column reservation.utime is '更新时间';
