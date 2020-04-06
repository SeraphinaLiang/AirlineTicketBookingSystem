------------------------------------------------------------------------------------------------------
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

---------------------------------------------------------------------------------------------------------------------------------

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

-----------------------------------------------------------------------------------------------------------------------------------