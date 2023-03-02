drop database if exists classroom_management;
create database classroom_management;
use classroom_management;

CREATE TABLE `Account` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `username` varchar(50) NOT NULL UNIQUE,
                           `date_of_birth` DATE NOT NULL,
                           `address` varchar(255) NOT NULL,
                           `password` varchar(50) NOT NULL,
                           `full_name` varchar(50),
                           `role` enum('ADMIN', 'MENTOR', 'TUTOR', 'STUDENT') NOT NULL,
                           `phone_number` varchar(12) NOT NULL UNIQUE,
                           `email` varchar(50) NOT NULL UNIQUE,
                           `facebook` varchar(50) NOT NULL UNIQUE,
                           `information` varchar(255),
                           `class_id` int,
                           PRIMARY KEY (`id`)
);

CREATE TABLE `zoom` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` varchar(50) NOT NULL UNIQUE,
                        `link` varchar(100) NOT NULL UNIQUE,
                        `description` varchar(500),
                        `note` varchar(500),
                        `meeting_id` varchar(15) NOT NULL UNIQUE,
                        `pass_code` varchar(15) NOT NULL,
                        PRIMARY KEY (`id`)
);

CREATE TABLE `class_room` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `name` varchar(50) NOT NULL UNIQUE,
                              `address` varchar(100) NOT NULL,
                              `note` varchar(500),
                              size int,
                              PRIMARY KEY (`id`)
);

CREATE TABLE `class` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `class_name` varchar(50) NOT NULL UNIQUE,
                         `start_date` DATE NOT NULL,
                         `end_date` DATE NOT NULL,
                         `class_status` enum('PENDING', 'IN_PROGRESS','CLOSED') NOT NULL,
                         `teaching_form` enum ('ONLINE', 'OFFLINE', 'ALL') NOT NULL,
                         `mentor_id` int NOT NULL,
                         `zoom_id` int NOT NULL,
                         `class_zoom_id` int NOT NULL,
                         `description` varchar(255),
                         `schedule` varchar(255) NOT NULL,
                         PRIMARY KEY (`id`)
);

ALTER TABLE `Account` ADD CONSTRAINT `Account_fk0` FOREIGN KEY (`class_id`) REFERENCES `class`(`id`);

ALTER TABLE `class` ADD CONSTRAINT `class_fk0` FOREIGN KEY (`mentor_id`) REFERENCES `Account`(`id`);

ALTER TABLE `class` ADD CONSTRAINT `class_fk1` FOREIGN KEY (`zoom_id`) REFERENCES `zoom`(`id`);

ALTER TABLE `class` ADD CONSTRAINT `class_fk2` FOREIGN KEY (`class_zoom_id`) REFERENCES `class_room`(`id`);


-- Data table Zoom
INSERT INTO `classroom_management`.`zoom` 	(`name`, 		`link`, 																`meeting_id`, 	`pass_code`)
VALUES 						('Zoom 1', 'https://us02web.zoom.us/j/89265216009?pwd=Mkxpa1VVUUpmT3psTlFyZWxKM2w4QT09', '89265216009', '2021'),
                              ('Zoom 2', 'https://us02web.zoom.us/j/81136162133?pwd=N0psR1VDVUFmOUtqYnF3bUNaWlJEQT09', '81136162133', '2021'),
                              ('Zoom 3', 'https://us02web.zoom.us/j/84969503241?pwd=WG1BbGFORUd5WTZ3WFp2YXlNUGFhdz09', '84969503241', '2021');

-- Data table class_room
INSERT INTO `classroom_management`.`class_room` 	(`name`, 		`address`, 			`size`)
VALUES 								('Paris ', 		'19 Lê Thanh Nghị', '10'),
                                      ('Singapore', 	'19 Lê Thanh Nghị', '15'),
                                      ('Big Data', 	'Duy Tân', 			'16'),
                                      ('London', 		'Mễ Trì Hạ', 		'10');

-- Account
INSERT INTO `classroom_management`.`Account`
(`username`, `date_of_birth`, `address`, `password`, `full_name`, `role`, `phone_number`, `email`, `facebook`)
VALUES 		('vanuoc', '1996-03-02', 'Hưng Yên', '123456', 'Vũ Văn Ước', 'MENTOR', '0377106297', 'vanuoc9xhy@gmail.com', 'https://www.facebook.com/uoc96/'),
              ('thanh', '1997-09-12', 'Nam Định', '123456', 'Lê Hồng Thanh', 'TUTOR', '0123456789', 'thanh01@gmail.com', 'https://www.facebook.com/thanh/'),
              ('minh', '1995-09-12', 'Hà Nội', '123456', 'Nguyễn Anh Minh', 'STUDENT', '0123456788', 'minh@gmail.com', 'https://www.facebook.com/minh/'),
              ('thao', '1999-09-12', 'Hải Dương', '123456', 'Đỗ Lương Thảo', 'STUDENT', '0234356547', 'thao', 'https://www.facebook.com/thao/');

-- class
INSERT INTO `classroom_management`.`class` (`class_name`, `start_date`, `end_date`, `class_status`, `teaching_form`, `mentor_id`, `zoom_id`, `class_zoom_id`, `schedule`)
VALUES ('Railway 59', '2022-09-12', '2023-03-12', 'IN_PROGRESS', 'ALL', '1', '1', '1', 'T3 - T5 - T7: 19.00-22.00 (VNT) tương đương 21.00 - 00h (JPT)'),
       ('Railway 60', '2022-09-12', '2023-03-12', 'IN_PROGRESS', 'ALL', '1', '2', '2', 'T3 - T5 - T7: 19.00-22.00 (VNT) tương đương 21.00 - 00h (JPT)'),
       ('Railway 61', '2022-09-12', '2023-03-12', 'PENDING', 'ONLINE', '1', '3', '3', 'T3 - T5 - T7: 19.00-22.00 (VNT) tương đương 21.00 - 00h (JPT)');