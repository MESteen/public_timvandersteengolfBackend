/*create table role
(
  id bigint not null auto_increment,
  description varchar(255),
  name varchar(255),
  primary key (id)
);

create table user_roles
(
  user_id bigint not null,
  role_id bigint not null,
  primary key (user_id, role_id)
);

CREATE TABLE Product
(
  product_id              INT 	NOT NULL AUTO_INCREMENT,
  name            	 VARCHAR(150) 	NOT NULL,
  beschrijving    	 VARCHAR(300) 	NULL,
  kleur		  	 VARCHAR(150) 	NULL,
  icon		  	 VARCHAR(150) 	NULL,
  eenheid         	 VARCHAR(150)  	NOT NULL,
  price		  	 FLOAT	       	NOT NULL,
  PRIMARY KEY     	 (product_id)
);

CREATE TABLE Partner
(
  partner_id             INT unsigned 	NOT NULL AUTO_INCREMENT,
  brand           	 VARCHAR(150)	NOT NULL,
  image		  	 TEXT	      	NOT NULL,
  href		  	 TEXT	       	NULL,
  PRIMARY KEY     	 (partner_id)
);

CREATE TABLE Game
(
  wedstrijd_id           INT unsigned 	NOT NULL AUTO_INCREMENT,
  course_naam		 VARCHAR(150) 	NOT NULL,
  wedstrijd_naam	 VARCHAR(150) 	NOT NULL,
  aantal_dagen		 INT	 	NULL,
  wedstrijdbaan_image	 TEXT	 	NULL,
  wedstrijd_link	 TEXT	      	NULL,
  baan_logo		 TEXT	 	NULL,
  datum	  		 DATE 		NULL,
  gespeeld 		 BOOLEAN 	NOT NULL DEFAULT 0,
  PRIMARY KEY     	 (wedstrijd_id)
);

INSERT INTO role (id, description, name) VALUES (4, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (5, 'User role', 'USER');

CREATE TABLE Coach
(
  coach_id             INT unsigned 	NOT NULL AUTO_INCREMENT,
  name           	   VARCHAR(150)   	NOT NULL,
  image		  	       TEXT	        	NOT NULL,
  type_of_coach		   VARCHAR(150)     NOT NULL,
  insta_link           TEXT         	NULL,
  fb_link		  	   TEXT	        	NULL,
  twitter_link		   TEXT	        	NULL,
  PRIMARY KEY     	 (coach_id)
);

  CREATE TABLE order_item
(
  product_id              INT 	NOT NULL AUTO_INCREMENT,
  name            	 VARCHAR(150) 	NOT NULL,
  beschrijving    	 VARCHAR(300) 	NULL,
  kleur		  	 VARCHAR(150) 	NULL,
  icon		  	 VARCHAR(150) 	NULL,
  eenheid         	 VARCHAR(150)  	NOT NULL,
  price		  	 FLOAT	       	NOT NULL,
  PRIMARY KEY     	 (product_id)
);

-----------------------------
-----------------------------
//REST IS AUTO
CREATE TABLE Orders
(
  order_id            	 INT 	NOT NULL AUTO_INCREMENT,
  created_datum           DATE   	NULL,
  total_price		 FLOAT  	NOT NULL,
  user_id		 BIGINT  	NOT NULL,
  PRIMARY KEY     	 (order_id)
);

create table order_products
(
  order_id bigint not null,
  product_id bigint not null,
  primary key (order_id, product_id)
);
  */