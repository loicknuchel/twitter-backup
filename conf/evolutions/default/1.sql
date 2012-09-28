# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table mention (
  id                        bigint auto_increment not null,
  screen_name               varchar(255),
  name                      varchar(255),
  user_id                   bigint,
  constraint uq_mention_1 unique (user_id),
  constraint pk_mention primary key (id))
;

create table twitt (
  id                        bigint auto_increment not null,
  text                      varchar(255),
  user_id                   bigint,
  created_at                varchar(255),
  truncated                 tinyint(1) default 0,
  in_reply_to_status_id     bigint,
  in_reply_to_user_id       bigint,
  in_reply_to_screen_name   varchar(255),
  retweet_count             integer,
  favorited                 tinyint(1) default 0,
  retweeted                 tinyint(1) default 0,
  constraint pk_twitt primary key (id))
;

create table url (
  id                        bigint auto_increment not null,
  url                       varchar(255),
  expanded_url              varchar(255),
  display_url               varchar(255),
  constraint uq_url_1 unique (url),
  constraint pk_url primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  screen_name               varchar(255),
  url                       varchar(255),
  description               varchar(255),
  followers_count           integer,
  friends_count             integer,
  listed_count              integer,
  created_at                varchar(255),
  favourites_count          integer,
  statuses_count            integer,
  profile_image_url         varchar(255),
  constraint pk_user primary key (id))
;


create table twitt_url (
  twitt_id                       bigint not null,
  url_id                         bigint not null,
  constraint pk_twitt_url primary key (twitt_id, url_id))
;

create table twitt_mention (
  twitt_id                       bigint not null,
  mention_id                     bigint not null,
  constraint pk_twitt_mention primary key (twitt_id, mention_id))
;
alter table twitt add constraint fk_twitt_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_twitt_user_1 on twitt (user_id);



alter table twitt_url add constraint fk_twitt_url_twitt_01 foreign key (twitt_id) references twitt (id) on delete restrict on update restrict;

alter table twitt_url add constraint fk_twitt_url_url_02 foreign key (url_id) references url (id) on delete restrict on update restrict;

alter table twitt_mention add constraint fk_twitt_mention_twitt_01 foreign key (twitt_id) references twitt (id) on delete restrict on update restrict;

alter table twitt_mention add constraint fk_twitt_mention_mention_02 foreign key (mention_id) references mention (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table mention;

drop table twitt;

drop table twitt_url;

drop table twitt_mention;

drop table url;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

