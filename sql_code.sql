--------------------------TRIGGER----------------------------------------------------------
DELIMITER ||
create trigger auto_create_seat after insert on flight
for each row
begin
declare flightno varchar(45);
select new.flight_number into flightno;

insert into seat(position,flight_number,class) value('A1',flightno,'First-Class');
insert into seat(position,flight_number,class) value('A2',flightno,'First-Class');
insert into seat(position,flight_number,class) value('A3',flightno,'First-Class');
insert into seat(position,flight_number,class) value('A4',flightno,'First-Class');
insert into seat(position,flight_number,class) value('A5',flightno,'First-Class');
insert into seat(position,flight_number,class) value('A6',flightno,'First-Class');
insert into seat(position,flight_number,class) value('A7',flightno,'First-Class');

insert into seat(position,flight_number,class) value('B1',flightno,'First-Class');
insert into seat(position,flight_number,class) value('B2',flightno,'First-Class');
insert into seat(position,flight_number,class) value('B3',flightno,'First-Class');
insert into seat(position,flight_number,class) value('B4',flightno,'First-Class');
insert into seat(position,flight_number,class) value('B5',flightno,'First-Class');
insert into seat(position,flight_number,class) value('B6',flightno,'First-Class');
insert into seat(position,flight_number,class) value('B7',flightno,'First-Class');

insert into seat(position,flight_number,class) value('C1',flightno,'First-Class');
insert into seat(position,flight_number,class) value('C2',flightno,'First-Class');
insert into seat(position,flight_number,class) value('C3',flightno,'First-Class');
insert into seat(position,flight_number,class) value('C4',flightno,'First-Class');
insert into seat(position,flight_number,class) value('C5',flightno,'First-Class');
insert into seat(position,flight_number,class) value('C6',flightno,'First-Class');
insert into seat(position,flight_number,class) value('C7',flightno,'First-Class');

insert into seat(position,flight_number,class) value('D1',flightno,'First-Class');
insert into seat(position,flight_number,class) value('D2',flightno,'First-Class');
insert into seat(position,flight_number,class) value('D3',flightno,'First-Class');
insert into seat(position,flight_number,class) value('D4',flightno,'First-Class');
insert into seat(position,flight_number,class) value('D5',flightno,'First-Class');
insert into seat(position,flight_number,class) value('D6',flightno,'First-Class');
insert into seat(position,flight_number,class) value('D7',flightno,'First-Class');

insert into seat(position,flight_number,class) value('E1',flightno,'First-Class');
insert into seat(position,flight_number,class) value('E2',flightno,'First-Class');
insert into seat(position,flight_number,class) value('E3',flightno,'First-Class');
insert into seat(position,flight_number,class) value('E4',flightno,'First-Class');
insert into seat(position,flight_number,class) value('E5',flightno,'First-Class');
insert into seat(position,flight_number,class) value('E6',flightno,'First-Class');
insert into seat(position,flight_number,class) value('E7',flightno,'First-Class');

insert into seat(position,flight_number,class) value('A1',flightno,'Business');
insert into seat(position,flight_number,class) value('A2',flightno,'Business');
insert into seat(position,flight_number,class) value('A3',flightno,'Business');
insert into seat(position,flight_number,class) value('A4',flightno,'Business');
insert into seat(position,flight_number,class) value('A5',flightno,'Business');
insert into seat(position,flight_number,class) value('A6',flightno,'Business');
insert into seat(position,flight_number,class) value('A7',flightno,'Business');

insert into seat(position,flight_number,class) value('B1',flightno,'Business');
insert into seat(position,flight_number,class) value('B2',flightno,'Business');
insert into seat(position,flight_number,class) value('B3',flightno,'Business');
insert into seat(position,flight_number,class) value('B4',flightno,'Business');
insert into seat(position,flight_number,class) value('B5',flightno,'Business');
insert into seat(position,flight_number,class) value('B6',flightno,'Business');
insert into seat(position,flight_number,class) value('B7',flightno,'Business');

insert into seat(position,flight_number,class) value('C1',flightno,'Business');
insert into seat(position,flight_number,class) value('C2',flightno,'Business');
insert into seat(position,flight_number,class) value('C3',flightno,'Business');
insert into seat(position,flight_number,class) value('C4',flightno,'Business');
insert into seat(position,flight_number,class) value('C5',flightno,'Business');
insert into seat(position,flight_number,class) value('C6',flightno,'Business');
insert into seat(position,flight_number,class) value('C7',flightno,'Business');

insert into seat(position,flight_number,class) value('D1',flightno,'Business');
insert into seat(position,flight_number,class) value('D2',flightno,'Business');
insert into seat(position,flight_number,class) value('D3',flightno,'Business');
insert into seat(position,flight_number,class) value('D4',flightno,'Business');
insert into seat(position,flight_number,class) value('D5',flightno,'Business');
insert into seat(position,flight_number,class) value('D6',flightno,'Business');
insert into seat(position,flight_number,class) value('D7',flightno,'Business');

insert into seat(position,flight_number,class) value('E1',flightno,'Business');
insert into seat(position,flight_number,class) value('E2',flightno,'Business');
insert into seat(position,flight_number,class) value('E3',flightno,'Business');
insert into seat(position,flight_number,class) value('E4',flightno,'Business');
insert into seat(position,flight_number,class) value('E5',flightno,'Business');
insert into seat(position,flight_number,class) value('E6',flightno,'Business');
insert into seat(position,flight_number,class) value('E7',flightno,'Business');

insert into seat(position,flight_number,class) value('A1',flightno,'Economy');
insert into seat(position,flight_number,class) value('A2',flightno,'Economy');
insert into seat(position,flight_number,class) value('A3',flightno,'Economy');
insert into seat(position,flight_number,class) value('A4',flightno,'Economy');
insert into seat(position,flight_number,class) value('A5',flightno,'Economy');
insert into seat(position,flight_number,class) value('A6',flightno,'Economy');
insert into seat(position,flight_number,class) value('A7',flightno,'Economy');

insert into seat(position,flight_number,class) value('B1',flightno,'Economy');
insert into seat(position,flight_number,class) value('B2',flightno,'Economy');
insert into seat(position,flight_number,class) value('B3',flightno,'Economy');
insert into seat(position,flight_number,class) value('B4',flightno,'Economy');
insert into seat(position,flight_number,class) value('B5',flightno,'Economy');
insert into seat(position,flight_number,class) value('B6',flightno,'Economy');
insert into seat(position,flight_number,class) value('B7',flightno,'Economy');

insert into seat(position,flight_number,class) value('C1',flightno,'Economy');
insert into seat(position,flight_number,class) value('C2',flightno,'Economy');
insert into seat(position,flight_number,class) value('C3',flightno,'Economy');
insert into seat(position,flight_number,class) value('C4',flightno,'Economy');
insert into seat(position,flight_number,class) value('C5',flightno,'Economy');
insert into seat(position,flight_number,class) value('C6',flightno,'Economy');
insert into seat(position,flight_number,class) value('C7',flightno,'Economy');

insert into seat(position,flight_number,class) value('D1',flightno,'Economy');
insert into seat(position,flight_number,class) value('D2',flightno,'Economy');
insert into seat(position,flight_number,class) value('D3',flightno,'Economy');
insert into seat(position,flight_number,class) value('D4',flightno,'Economy');
insert into seat(position,flight_number,class) value('D5',flightno,'Economy');
insert into seat(position,flight_number,class) value('D6',flightno,'Economy');
insert into seat(position,flight_number,class) value('D7',flightno,'Economy');

insert into seat(position,flight_number,class) value('E1',flightno,'Economy');
insert into seat(position,flight_number,class) value('E2',flightno,'Economy');
insert into seat(position,flight_number,class) value('E3',flightno,'Economy');
insert into seat(position,flight_number,class) value('E4',flightno,'Economy');
insert into seat(position,flight_number,class) value('E5',flightno,'Economy');
insert into seat(position,flight_number,class) value('E6',flightno,'Economy');
insert into seat(position,flight_number,class) value('E7',flightno,'Economy');

end
||
DELIMITER ;

-------------------------TRIGGER-------------------------------------------------------------------------------------------

DELIMITER ||
create trigger auto_create_bill after insert on ticket
for each row
begin
declare ticketno varchar(45);
select new.ticket_number into ticketno;
insert into bill(bill_number,ticket_number) value(ticketno,ticketno);
end
||
DELIMITER ;

----------------------------CREATE TABLE-------------------------------------------------------------------------------------------
CREATE TABLE `bill` (
  `bill_number` varchar(45) NOT NULL,
  `ticket_number` varchar(45) NOT NULL,
  `fee` double DEFAULT NULL,
  `ispaid` tinyint(4) DEFAULT '0',
  `pay_date` date DEFAULT NULL,
  PRIMARY KEY (`bill_number`),
  UNIQUE KEY `bill_number_UNIQUE` (`bill_number`),
  KEY `fk7_idx` (`ticket_number`),
  CONSTRAINT `fk7` FOREIGN KEY (`ticket_number`) REFERENCES `ticket` (`ticket_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `book` (
  `passport_number` varchar(45) NOT NULL,
  `flight_number` varchar(45) NOT NULL,
  `book_date` date DEFAULT NULL,
  PRIMARY KEY (`passport_number`,`flight_number`),
  KEY `fk3_idx` (`flight_number`),
  CONSTRAINT `fk3` FOREIGN KEY (`flight_number`) REFERENCES `flight` (`flight_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk4` FOREIGN KEY (`passport_number`) REFERENCES `passenger` (`passport_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `flight` (
  `flight_number` varchar(45) NOT NULL,
  `departure_city` varchar(45) DEFAULT NULL,
  `arrival_city` varchar(45) DEFAULT NULL,
  `departure_day` date DEFAULT NULL,
  `arrival_day` date DEFAULT NULL,
  `departure_time` time DEFAULT NULL,
  `arrival_time` time DEFAULT NULL,
  `plane_type` varchar(45) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `isCancel` tinyint(4) DEFAULT '0',
  `terminal1` varchar(45) DEFAULT NULL,
  `terminal2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`flight_number`),
  UNIQUE KEY `flight_number_UNIQUE` (`flight_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `passenger` (
  `passport_number` varchar(45) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`passport_number`),
  UNIQUE KEY `passport_number_UNIQUE` (`passport_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `seat` (
  `position` varchar(45) NOT NULL,
  `flight_number` varchar(45) NOT NULL,
  `isbooked` tinyint(4) DEFAULT '0',
  `class` varchar(45) NOT NULL,
  `passport_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`position`,`flight_number`,`class`),
  KEY `fk1_idx` (`flight_number`),
  KEY `fk2_idx` (`passport_number`),
  CONSTRAINT `fk1` FOREIGN KEY (`flight_number`) REFERENCES `flight` (`flight_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`passport_number`) REFERENCES `passenger` (`passport_number`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `ticket` (
  `ticket_number` varchar(45) NOT NULL,
  `passport_number` varchar(45) NOT NULL,
  `flight_number` varchar(45) NOT NULL,
  `baggage_allowance` varchar(45) DEFAULT NULL,
  `special_meal` varchar(45) DEFAULT NULL,
  `class` varchar(45) DEFAULT NULL,
  `baggage_add` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ticket_number`),
  UNIQUE KEY `ticket_number_UNIQUE` (`ticket_number`),
  KEY `fk5_idx` (`flight_number`),
  KEY `fk6_idx` (`passport_number`),
  CONSTRAINT `fk5` FOREIGN KEY (`flight_number`) REFERENCES `flight` (`flight_number`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk6` FOREIGN KEY (`passport_number`) REFERENCES `passenger` (`passport_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1

-------------------------------------------------STORED PROCEDURE----------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `change_baggage`(in ticketno varchar(45),in baggage varchar(45))
BEGIN
update ticket
set baggage_allowance=baggage
where ticket_number=ticketno;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `change_baggage_add`(in ticketno varchar(45),in baggage varchar(45))
BEGIN
update ticket
set baggage_add=baggage
where ticket_number=ticketno;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `change_class`(in ticketno varchar(45),in newclass varchar(45))
BEGIN
update ticket
set class=newclass
where ticket_number=ticketno;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `change_meal`(in ticketno varchar(45),in meal varchar(45))
BEGIN
update ticket
set special_meal=meal
where ticket_number=ticketno;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `is_ticket_and_passport_match`(in ticket varchar(45),in passport varchar(45),out outcome int(1))
BEGIN
declare num int(1);
select count(passport_number) into num
from ticket
where ticket=ticket_number and passport_number=passport;
if(num>0)
then set outcome=1;
else set outcome=0;
end if;
END

------------------------------------------FUNCTION----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` FUNCTION `get_seat_if_booked`(flightno varchar(45),passpo varchar(45)) RETURNS varchar(45) CHARSET latin1
BEGIN
declare pos varchar(45);
declare num int;
select count(position) into num
from seat
where flight_number=flightno and passport_number=passpo;
select position into pos
from seat
where flight_number=flightno and passport_number=passpo;
if(num>0)
then return pos;
else return 'NO';
end if;
END

CREATE DEFINER=`root`@`localhost` FUNCTION `if_paid`(billno varchar(45)) RETURNS int(11)
BEGIN
declare outcome integer;
select ispaid into outcome
from bill
where bill_number=billno;
return outcome;
END

CREATE DEFINER=`root`@`localhost` FUNCTION `is_ticket_number_exist`(ticketno varchar(45)) RETURNS int(11)
BEGIN
declare num int(1);
select count(ticket.ticket_number) into num
from ticket
where ticketno=ticket_number;
if(num>0)
then return 1;
else return 0;
end if;
END