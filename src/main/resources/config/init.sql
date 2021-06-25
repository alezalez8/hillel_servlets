drop table IF EXISTS schedule_service;

create table schedule_service
(
    Id           SERIAL PRIMARY KEY,
    station_from VARCHAR(50) NOT NULL,
    station_to   VARCHAR(50) NOT NULL,
    departure    DATE        NOT NULL,
    arrival      DATE        NOT NULL
);

insert into schedule_service (station_from, station_to, departure, arrival)
values ('Odessa', 'Kiev', '12/3/2021', '13/3/2021'),
       ('Odessa', 'Kiev', '14/3/2021', '15/3/2021'),
       ('Odessa', 'Kiev', '16/3/2021', '17/3/2021'),
       ('Odessa', 'Kiev', '18/3/2021', '19/3/2021'),
       ('Odessa', 'Kiev', '20/3/2021', '21/3/2021'),
       ('Odessa', 'Kiev', '22/3/2021', '23/3/2021'),
       ('Odessa', 'Kiev', '24/3/2021', '25/3/2021'),
       ('Odessa', 'Kiev', '26/3/2021', '27/3/2021'),

       ('Kiev', 'Odessa', '11/3/2021', '12/3/2021'),
       ('Kiev', 'Odessa', '13/3/2021', '14/3/2021'),
       ('Kiev', 'Odessa', '15/3/2021', '16/3/2021'),
       ('Kiev', 'Odessa', '17/3/2021', '18/3/2021'),
       ('Kiev', 'Odessa', '19/3/2021', '20/3/2021'),
       ('Kiev', 'Odessa', '21/3/2021', '22/3/2021'),
       ('Kiev', 'Odessa', '23/3/2021', '24/3/2021'),
       ('Kiev', 'Odessa', '25/3/2021', '26/3/2021'),

       ('Odessa', 'Lviv', '13/3/2021', '15/3/2021'),
       ('Odessa', 'Lviv', '15/3/2021', '17/3/2021'),
       ('Odessa', 'Lviv', '17/3/2021', '19/3/2021'),
       ('Odessa', 'Lviv', '19/3/2021', '21/3/2021'),
       ('Odessa', 'Lviv', '21/3/2021', '23/3/2021'),
       ('Odessa', 'Lviv', '23/3/2021', '25/3/2021'),
       ('Odessa', 'Lviv', '25/3/2021', '27/3/2021'),
       ('Odessa', 'Lviv', '27/3/2021', '29/3/2021'),

       ('Lviv', 'Odessa', '1/3/2021', '3/3/2021'),
       ('Lviv', 'Odessa', '3/3/2021', '5/3/2021'),
       ('Lviv', 'Odessa', '5/3/2021', '7/3/2021'),
       ('Lviv', 'Odessa', '8/3/2021', '10/3/2021'),
       ('Lviv', 'Odessa', '12/3/2021', '14/3/2021'),
       ('Lviv', 'Odessa', '14/3/2021', '16/3/2021'),
       ('Lviv', 'Odessa', '15/3/2021', '17/3/2021'),
       ('Lviv', 'Odessa', '20/3/2021', '22/3/2021'),

       ('Kiev', 'Lviv', '13/3/2021', '14/3/2021'),
       ('Kiev', 'Lviv', '15/3/2021', '15/3/2021'),
       ('Kiev', 'Lviv', '17/3/2021', '18/3/2021'),
       ('Kiev', 'Lviv', '19/3/2021', '20/3/2021'),
       ('Kiev', 'Lviv', '21/3/2021', '22/3/2021'),
       ('Kiev', 'Lviv', '23/3/2021', '24/3/2021'),
       ('Kiev', 'Lviv', '25/3/2021', '26/3/2021'),
       ('Kiev', 'Lviv', '27/3/2021', '28/3/2021'),

       ('Lviv', 'Kiev', '1/3/2021', '2/3/2021'),
       ('Lviv', 'Kiev', '3/3/2021', '4/3/2021'),
       ('Lviv', 'Kiev', '5/3/2021', '6/3/2021'),
       ('Lviv', 'Kiev', '8/3/2021', '8/3/2021'),
       ('Lviv', 'Kiev', '12/3/2021', '13/3/2021'),
       ('Lviv', 'Kiev', '14/3/2021', '15/3/2021'),
       ('Lviv', 'Kiev', '15/3/2021', '16/3/2021'),
       ('Lviv', 'Kiev', '20/3/2021', '21/3/2021');


INSERT INTO stop (id, active, create_date, description, name)
VALUES (1, 'true', '2021-06-22 20:40:23.000000', 'qqq 1', 'stop 1');
INSERT INTO stop (id, active, create_date, description, name)
VALUES (2, 'true', '2021-06-22 20:40:23.000000', 'qqq 2', 'stop 2');
INSERT INTO stop (id, active, create_date, description, name)
VALUES (3, 'true', '2021-06-22 20:40:23.000000', 'qqq 3', 'stop 3');
INSERT INTO stop (id, active, create_date, description, name)
VALUES (4, 'true', '2021-06-22 20:40:23.000000', 'qqq 4', 'stop 4');




/*INSERT INTO public.journey (id, active, create_date, arrival, departure, direction, station_from, station_to,
                            vehicle_id)
VALUES (1, 'true', '2021-05-25 18:05:54.000000', '2021-06-24', '2021-06-27', 'to', 'station 1', 'station 2', 1);
INSERT INTO public.journey (id, active, create_date, arrival, departure, direction, station_from, station_to,
                            vehicle_id)
VALUES (2, 'true', '2021-05-25 18:05:54.000000', '2021-06-01', '2021-05-07', 'to', 'station 3', 'station 4', 2);
INSERT INTO public.journey (id, active, create_date, arrival, departure, direction, station_from, station_to,
                            vehicle_id)
VALUES (3, 'true', '2021-05-25 18:05:54.000000', '2021-06-21', '2021-06-30', 'to', 'station 5', 'station 6', 3);*/
