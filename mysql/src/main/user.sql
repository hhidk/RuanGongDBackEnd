create table literaturesys.user
(
    userId       char(8) charset utf8      not null
        primary key,
    userIdentity tinyint                   not null,
    username     varchar(20) charset utf8  not null,
    phoneNumber  varchar(20) charset utf8  null,
    password     varchar(16) charset utf8  not null,
    emailAddress varchar(50) charset utf8  not null,
    image        varchar(100) charset utf8 not null,
    organization varchar(50) charset utf8  null,
    introduction varchar(150) charset utf8 null,
    realName     varchar(50) charset utf8  null,
    userDegree   tinyint                   null
);

