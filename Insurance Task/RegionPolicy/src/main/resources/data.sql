insert into state
 (id,name,factor)
 values
 (1,"state 1",1.7),
 (2,"state 2",1.5);


 insert into county
 (id,name,state_id,factor)
 values
 (1,"county 1",2,1.5),
 (2,"county 2",2,1.7),
 (3,"county 3",1,1.3),
 (4,"county 4",1,1.4);

 insert into city
 (id,name,county_id)
 values
 (1,"city 1",1),
 (2,"city 2",2),
 (3,"city 3",3),
 (4,"city 4",4);

insert into location
 (id,name,city_id,postal_code)
 values
 (1,"location 1",1,555),
 (2,"location 2",2,666),
 (3,"location 3",3,777),
 (4,"location 4",4,888);
