create table users(
	user_id varchar2(20) primary key,
	user_name varchar2(10 char) not null,
	user_birth date not null
);

insert into users values('inji', '이인지', to_date('991005', 'YYMMDD'));

select * from users where user_id = 'inji';

create sequence tasks_seq;

drop table users cascade constraint purge;
drop table tasks cascade constraint purge;
drop sequence tasks_seq;

create table tasks(
	t_no number(3) primary key,
	t_title varchar2(10 char) not null,
	t_description varchar2(20 char),
	t_status char(3 char) not null,
	t_priority char(1 char) not null,
	t_startdate date not null,
	t_duedate date not null,
	t_user_id varchar2(20) not null,
	constraint tasks_maker foreign key(t_user_id) references users(user_id) on delete cascade
);

select * from tasks;

insert into tasks values(tasks_seq.nextval, '놀기', '술먹고 노래방가기', '미완료', '상', to_date('20240822','YYYYMMDD'), to_date('20240825', 'YYYYMMDD'), 'inji');
insert into tasks values(tasks_seq.nextval, '자기', '술먹고 자기', '미완료', '상', to_date('20240822','YYYYMMDD'), to_date('20240825', 'YYYYMMDD'), 'inji');

delete from users where user_id = 'inji';
delete from users where user_id = 'inji';