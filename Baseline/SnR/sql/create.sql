drop table if exists mvn_artifact;
drop table if exists mvn_dependency;
drop table if exists mvn_class;
drop table if exists mvn_interface;
drop table if exists mvn_field;
drop table if exists mvn_method;



create table mvn_artifact (
    id int primary key auto_increment not null,
    groupid varchar(255),
    artifactid varchar(255),
    version varchar(255),
    unique (groupid, artifactid, version)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table mvn_dependency (
    id int primary key auto_increment not null,
    base_id int,
    depd_id int,
    unique (base_id, depd_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table mvn_class (
    id int primary key auto_increment not null,
    artifact_id int,
    name varchar(255),
    modifiers int(32),
    super_class varchar(255),
    signature varchar(1024),
    entry varchar(1024),
    unique (artifact_id, name, modifiers, super_class)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table mvn_interface (
    id int primary key auto_increment not null,
    class_id int,
    interface varchar(255)
    /*unique (class_id, interface)*/
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table mvn_field (
    id int primary key auto_increment not null,
    class_id int,
    modifiers int(32),
    type varchar(255),
    name varchar(255),
    signature varchar(1024)
    /*unique (class_id, type, name, modifiers)*/
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table mvn_method (
    id int primary key auto_increment not null,
    class_id int,
    modifiers int(32),
    name varchar(255),
    return_type varchar(255),
    param_type varchar(1024),
    param_num int,
    signature varchar(1024)
    /*unique (class_id, name, return_type, param_type, modifiers)*/
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
