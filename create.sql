
    create table interest (
        interestid bigserial not null,
        userid bigint,
        interest varchar(255),
        primary key (interestid)
    );

    create table location (
        latitude float(53),
        longitude float(53),
        locationid bigserial not null,
        timestamp timestamp(6),
        userid bigint,
        primary key (locationid)
    );

    create table match (
        matched_timestamp timestamp(6),
        matchid bigserial not null,
        user1id bigint,
        user2id bigint,
        primary key (matchid)
    );

    create table message (
        messageid bigserial not null,
        receiverid bigint,
        senderid bigint,
        timestamp timestamp(6),
        message varchar(255),
        primary key (messageid)
    );

    create table users (
        birthday date,
        userid bigserial not null,
        bio varchar(255),
        email varchar(255),
        gender varchar(255),
        password varchar(255),
        profile_picture varchar(255),
        username varchar(255),
        primary key (userid)
    );

    alter table if exists interest 
       add constraint FKih6wwelsgpd1ws956u634syyw 
       foreign key (userid) 
       references users;

    alter table if exists location 
       add constraint FKf7wycjkxacakl60obb0ulh604 
       foreign key (userid) 
       references users;

    alter table if exists match 
       add constraint FKktjwi7t9y3m9ku1nc0njahh03 
       foreign key (user1id) 
       references users;

    alter table if exists match 
       add constraint FKs1ux7yr0ag4ccs6q02ws5h8mj 
       foreign key (user2id) 
       references users;

    alter table if exists message 
       add constraint FKbn3kml0f86u2jp1of74h5rp6r 
       foreign key (receiverid) 
       references users;

    alter table if exists message 
       add constraint FKmbmfoyayyix0xheh6opry914n 
       foreign key (senderid) 
       references users;
