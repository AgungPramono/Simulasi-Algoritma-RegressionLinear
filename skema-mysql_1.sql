create database prediksi_nilai;
use prediksi_nilai;

create table nilai(
    id int(11) NOT NULL AUTO_INCREMENT,
    uas double(19,2) not null,
    un double(19,2)not null,
    PRIMARY KEY (`id`)
)engine=InnoDB;

create table testing(
    id int(11) NOT NULL AUTO_INCREMENT,
    uas double(19,2) not null,
    PRIMARY KEY (`id`)
)engine=InnoDB;
