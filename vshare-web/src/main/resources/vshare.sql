drop database if exists vshare;
create database vshare;
use vshare;

drop table if exists user;
create table user(
	user_id bigint(20) not null auto_increment,
    user_email varchar(255),
    user_name varchar(255),
    user_password varchar(255),
    primary key (user_id)
);
insert into user(user_email, user_password, user_name) values ('admin@gmail.com', 'admin', 'admin');
insert into user(user_email, user_password, user_name) values ('user@gmail.com', 'user', 'user');
drop table if exists authority;
create table authority (
	user_id bigint(20) not null,
    authority varchar(40) not null,
    primary key (user_id, authority),
    foreign key (user_id) references user(user_id)
);
insert into authority values(1, "ROLE_USER");
INSERT INTO authority VALUES (1, "ROLE_ADMIN");
insert into authority values(2, "ROLE_USER");

DROP TABLE IF EXISTS storage;
CREATE TABLE `storage` (
  `storage_id`   BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id`      BIGINT(20),
  `max_size`     BIGINT(20),
  `current_size` BIGINT(20),
  PRIMARY KEY (`storage_id`),
  FOREIGN KEY (user_id) REFERENCES user (user_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO storage (user_id, max_size, current_size) VALUES (1, 999999999, 0);

CREATE TABLE `folder` (
  `folder_id`     BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `folder_parent` BIGINT(20)            DEFAULT NULL,
  `folder_name`   VARCHAR(250) NOT NULL,
  `storage_id`    BIGINT(20)            DEFAULT NULL,
  `privacy`       VARCHAR(250)          DEFAULT NULL,
  `status`        VARCHAR(250)          DEFAULT NULL,
  PRIMARY KEY (`folder_id`),
  FOREIGN KEY (storage_id) REFERENCES storage (storage_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS file;
CREATE TABLE `file` (
  `file_id`            BIGINT(20) NOT NULL AUTO_INCREMENT,
  `file_original_name` VARCHAR(250)        DEFAULT NULL,
  `file_physical_name` VARCHAR(250)        DEFAULT NULL,
  `file_address`       VARCHAR(250)        DEFAULT NULL,
  `storage_id`         BIGINT(20)          DEFAULT NULL,
  `folder_id`          BIGINT(20)          DEFAULT NULL,
  `privacy`            VARCHAR(250)        DEFAULT NULL,
  `status`             VARCHAR(250)        DEFAULT NULL,
  `file_size`          BIGINT(20),
  PRIMARY KEY (`file_id`),
  FOREIGN KEY (folder_id) REFERENCES folder (folder_id),
  FOREIGN KEY (storage_id) REFERENCES storage (storage_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS server;
CREATE TABLE server (
  server_ip           VARCHAR(255) NOT NULL,
  server_size         BIGINT(20)   NOT NULL,
  server_useable_size BIGINT(20)   NOT NULL,
  server_user         VARCHAR(255) NOT NULL,
  server_alias        VARCHAR(255) NOT NULL,
  server_password     VARCHAR(255),
  PRIMARY KEY (server_ip)
);

DROP TABLE IF EXISTS file_server_meta;
CREATE TABLE file_server_meta (
  server_ip VARCHAR(255) NOT NULL,
  file_id   BIGINT(20)   NOT NULL,
  PRIMARY KEY (server_ip, file_id),
  FOREIGN KEY (server_ip) REFERENCES server (server_ip),
  FOREIGN KEY (file_id) REFERENCES file (file_id)
);

DROP TABLE IF EXISTS premium_card;
CREATE TABLE premium_card (
  card_serial   VARCHAR(255) NOT NULL,
  card_code     VARCHAR(255) NOT NULL,
  created       DATETIME,
  point         BIGINT(20),
  last_modified DATETIME,
  card_status   VARCHAR(100),
  PRIMARY KEY (card_serial)
);

CREATE TABLE premium_card_log (
  card_serial VARCHAR(255) NOT NULL,
  user_id     BIGINT(20)   NOT NULL,
  actived     DATETIME     NOT NULL,
  FOREIGN KEY (card_serial) REFERENCES premium_card (card_serial),
  FOREIGN KEY (user_id) REFERENCES user (user_id),
  PRIMARY KEY (card_serial)
);

CREATE TABLE premium_data (
  user_id BIGINT(20),
  point   BIGINT(20),
  dueTo   DATETIME,
  PRIMARY KEY (user_id),
  FOREIGN KEY (user_id) REFERENCES user (user_id)
);