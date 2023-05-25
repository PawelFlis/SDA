INSERT INTO continent (name) VALUES('Europa');
INSERT INTO continent (name) VALUES('Afryka');
INSERT INTO continent (name) VALUES('Azja');
INSERT INTO continent (name) VALUES('Ameryka');
INSERT INTO continent (name) VALUES('Australia i Oceania');

INSERT INTO country (name, continent_id) VALUES('Polska',(SELECT id FROM continent WHERE name='Europa'));
INSERT INTO country (name, continent_id) VALUES('Niemcy',(SELECT id FROM continent WHERE name='Europa'));
INSERT INTO country (name, continent_id) VALUES('Francja',(SELECT id FROM continent WHERE name='Europa'));
INSERT INTO country (name, continent_id) VALUES('Włochy',(SELECT id FROM continent WHERE name='Europa'));
INSERT INTO country (name, continent_id) VALUES('Chorwacja',(SELECT id FROM continent WHERE name='Europa'));
INSERT INTO country (name, continent_id) VALUES('Grecja',(SELECT id FROM continent WHERE name='Europa'));
INSERT INTO country (name, continent_id) VALUES('Czechy',(SELECT id FROM continent WHERE name='Europa'));
INSERT INTO country (name, continent_id) VALUES('Anglia',(SELECT id FROM continent WHERE name='Europa'));
INSERT INTO country (name, continent_id) VALUES('Bułgaria',(SELECT id FROM continent WHERE name='Europa'));
INSERT INTO country (name, continent_id) VALUES('Egipt',(SELECT id FROM continent WHERE name='Afryka'));
INSERT INTO country (name, continent_id) VALUES('RPA',(SELECT id FROM continent WHERE name='Afryka'));
INSERT INTO country (name, continent_id) VALUES('Tunezja',(SELECT id FROM continent WHERE name='Afryka'));
INSERT INTO country (name, continent_id) VALUES('Maroko',(SELECT id FROM continent WHERE name='Afryka'));
INSERT INTO country (name, continent_id) VALUES('USA',(SELECT id FROM continent WHERE name='Ameryka'));
INSERT INTO country (name, continent_id) VALUES('Kanada',(SELECT id FROM continent WHERE name='Ameryka'));
INSERT INTO country (name, continent_id) VALUES('Meksyk',(SELECT id FROM continent WHERE name='Ameryka'));
INSERT INTO country (name, continent_id) VALUES('Argentyna',(SELECT id FROM continent WHERE name='Ameryka'));
INSERT INTO country (name, continent_id) VALUES('Brazylia',(SELECT id FROM continent WHERE name='Ameryka'));

INSERT INTO city (name, country_id) VALUES('Katowice',(SELECT id FROM country WHERE name='Polska'));
/*INSERT INTO city (name, country_id) VALUES('Kraków',(SELECT id FROM country WHERE name='Polska'));
INSERT INTO city (name, country_id) VALUES('Warszawa',(SELECT id FROM country WHERE name='Polska'));
INSERT INTO city (name, country_id) VALUES('Wrocław',(SELECT id FROM country WHERE name='Polska'));
INSERT INTO city (name, country_id) VALUES('Gdańsk',(SELECT id FROM country WHERE name='Polska'));
INSERT INTO city (name, country_id) VALUES('Łódź',(SELECT id FROM country WHERE name='Polska'));
INSERT INTO city (name, country_id) VALUES('Poznań',(SELECT id FROM country WHERE name='Polska'));
INSERT INTO city (name, country_id) VALUES('Berlin',(SELECT id FROM country WHERE name='Niemcy'));
INSERT INTO city (name, country_id) VALUES('Hamburg',(SELECT id FROM country WHERE name='Niemcy'));
INSERT INTO city (name, country_id) VALUES('Monachium',(SELECT id FROM country WHERE name='Niemcy'));
INSERT INTO city (name, country_id) VALUES('Kolonia',(SELECT id FROM country WHERE name='Niemcy'));
INSERT INTO city (name, country_id) VALUES('Paryż',(SELECT id FROM country WHERE name='Francja'));
INSERT INTO city (name, country_id) VALUES('Lyon',(SELECT id FROM country WHERE name='Francja'));
INSERT INTO city (name, country_id) VALUES('Marsylia',(SELECT id FROM country WHERE name='Francja'));
INSERT INTO city (name, country_id) VALUES('Rzym',(SELECT id FROM country WHERE name='Francja'));
INSERT INTO city (name, country_id) VALUES('Wenecja',(SELECT id FROM country WHERE name='Włochy'));
INSERT INTO city (name, country_id) VALUES('Florencja',(SELECT id FROM country WHERE name='Włochy'));
INSERT INTO city (name, country_id) VALUES('Zagrzeb',(SELECT id FROM country WHERE name='Chorwacja'));
INSERT INTO city (name, country_id) VALUES('Split',(SELECT id FROM country WHERE name='Chorwacja'));
INSERT INTO city (name, country_id) VALUES('Ateny',(SELECT id FROM country WHERE name='Grecja'));
INSERT INTO city (name, country_id) VALUES('Larisa',(SELECT id FROM country WHERE name='Grecja'));
INSERT INTO city (name, country_id) VALUES('Saloniki',(SELECT id FROM country WHERE name='Grecja'));
INSERT INTO city (name, country_id) VALUES('Praga',(SELECT id FROM country WHERE name='Czechy'));
INSERT INTO city (name, country_id) VALUES('Londyn',(SELECT id FROM country WHERE name='Anglia'));
INSERT INTO city (name, country_id) VALUES('Sofia',(SELECT id FROM country WHERE name='Bułgaria'));*/
INSERT INTO city (name, country_id) VALUES('Kair',(SELECT id FROM country WHERE name='Egipt'));

INSERT INTO city (name, country_id) VALUES('Nowy Jork',(SELECT id FROM country WHERE name='USA'));
INSERT INTO city (name, country_id) VALUES('Chicago',(SELECT id FROM country WHERE name='USA'));
INSERT INTO city (name, country_id) VALUES('Los Angeles',(SELECT id FROM country WHERE name='USA'));

INSERT INTO airport (name, city_id) SELECT 'Lotnisko ' || name || ' nr 1', id FROM city;
INSERT INTO airport (name, city_id) SELECT 'Lotnisko ' || name || ' nr 2', id FROM city;
INSERT INTO airport (name, city_id) SELECT 'Lotnisko ' || name || ' nr 3', id FROM city;

INSERT INTO hotel (name, city_id, standard) SELECT 'Hotel ' || name || ' standard 3', id, 3 FROM city;
INSERT INTO hotel (name, city_id, standard) SELECT 'Hotel ' || name || ' standard 4', id, 4 FROM city;
INSERT INTO hotel (name, city_id, standard) SELECT 'Hotel ' || name || ' standard 5', id, 5 FROM city;

/*INSERT INTO tour (adult_capacity
                 , adult_cost
                 , child_capacity
                 , child_cost
                 , date_from
                 , date_to
                 , days
                 , is_special
                 , type
                 , airport_from_id
                 , airport_to_id
                 , city_from_id
                 , city_to_id
                 , hotel_id)
VALUES  ( 30 ,1000,5,100,current_date,current_date,1,0,'AI',1,2,1,2,1)*/


INSERT INTO tour (adult_capacity
, adult_cost
, child_capacity
, child_cost
, date_from
, date_to
, days
, is_special
, type
, airport_from_id
, airport_to_id
, city_from_id
, city_to_id
, hotel_id)
SELECT 30 as adult_capacity
,  1000 * h.standard / 2  * case when cnf.id<>cnt.id then 2 when cuf.id<>cut.id then 1.5 else 1 end as adult_cost
,  10 as child_capacity
,  500 * h.standard / 2  * case when cnf.id<>cnt.id then 2 when cuf.id<>cut.id then 1.5 else 1 end as child_cost
, cast(dateadd(day, cast(RAND()*200 - 10 as int), CURRENT_DATE()) as date) as date_from
, CURRENT_DATE() as date_to
, CASE WHEN RAND()<0.2 then 14 WHEN RAND()<0.8 then 7 else 3 END as days
, CASE WHEN RAND()<0.05 then 1 else 0 END as is_special
, CASE WHEN RAND()<0.25 then 'HB' WHEN RAND()<0.25 then 'FB' WHEN RAND()<0.25 then 'BB' else 'AI' END as type
, af.id
, at.id
, cf.id
, ct.id
, h.id
FROM city cf
join country cuf on cf.country_id = cuf.id
join continent cnf on cuf.continent_id = cnf.id
join city ct on cf.id<>ct.id
join country cut on ct.country_id = cut.id
join continent cnt on cut.continent_id = cnt.id
join airport af on cf.id=af.city_id
join airport at on ct.id=at.city_id
join hotel h on h.city_id=ct.id;

update tour
set date_to=dateadd(day,days,date_from);

INSERT INTO client (first_name, last_name, phone, email, birthday) VALUES ('Jan', 'Kowalski', '500-600-700','Janek@gmail.com', '1979-12-12');
INSERT INTO client (first_name, last_name, phone, email, birthday) VALUES ('Ewa', 'Pogodna', '555-666-777','Ewcia102@gmail.com', '1990-12-12');
INSERT INTO client (first_name, last_name, phone, email, birthday) VALUES ('Waldek', 'Kowalski', '505-605-705','waldzio@gmail.com', '1985-01-25');
INSERT INTO client (first_name, last_name, phone, email, birthday) VALUES ('Ania', 'Nowak', '375-433-452','kwiatek@gmail.com', '1999-07-01');
INSERT INTO client (first_name, last_name, phone, email, birthday) VALUES ('Jan', 'Nowak', '501-601-701','JanekNowak@gmail.com', '1980-12-12');

INSERT INTO orders(adults_count, children_count, tour_id, client_id) VALUES(2, 1, 1, 1);
INSERT INTO orders(adults_count, children_count, tour_id, client_id) VALUES(2, 1, 1, 2);
INSERT INTO orders(adults_count, children_count, tour_id, client_id) VALUES(2, 4, 1, 3);
INSERT INTO orders(adults_count, children_count, tour_id, client_id) VALUES(2, 0, 1, 4 );
INSERT INTO orders(adults_count, children_count, tour_id, client_id) VALUES(4, 2, 1, 5 );


