

CREATE TABLE "movie" (
        "id" SERIAL PRIMARY KEY,
        "moviename" VARCHAR(255) NOT NULL UNIQUE,
        "agelimit" VARCHAR(255) NOT NULL,
        "duration" VARCHAR(255) NOT NULL,
        "language" VARCHAR(255) NOT NULL

);

INSERT INTO "movie" ("moviename", "agelimit" ,"duration","language")
VALUES







  ('The Shawshank Redemption', '15', '142', 'English'),
  ('The Godfather', '15', '175', 'English'),
  ('Citizen Kane', 'A', '119', 'English'),
  ('12 Angry Men', 'U', '96', 'English'),
  ('Schindlers List', '15', '195', 'English'),
  ('The Good, the Bad and the Ugly ', '18', '148', 'English'),
  ('Star Wars: Episode V - The Empire Strikes Back', 'U', '124', 'English'),
  ('The Lord of the Rings: The Return of the King', '12A', '201', 'English'),
  ('The Dark Knight', '12A', '152', 'English'),
  ('The Godfather Part II', 'X', '202', 'English'),
  ('Pulp Fiction', '18', '154', 'English'),
  ('Fight Club', '15', '139', 'English'),
  ('Psycho', '15', '109', 'English'),
  ('Metropolis', 'A', '153', 'German'),
  ('Star Wars: Episode IV - A New Hope', 'U', '121', 'English'),
  ('The Lord of the Rings: The Fellowship of the Ring', 'PG', '178', 'English'),
  ('The Matrix', '15', '136', 'English'),
  ('Les yeux sans visage', '15', '90', 'French'),
  ('Le Samouraï', '15', 'A', 'French'),
  ('La règle du jeu', 'PG', '110', 'French'),
  ('Les parapluies de Cherbourg', 'A', '91', 'French'),
  ('Das Boot', 'AA', '149', 'German'),
  ('Der Baader Meinhof Komplex', '18', '150', 'German'),
  ('Nosferatu', 'A', '94', 'German'),
  ('Untergang', '15', '156', 'German'),
  ('November', '15', '115', 'Estonian'),
  ('Nähtamatu võitlus', '15', '115', 'Estonian'),
  ('Tõde ja õigus', '15', '165', 'Estonian'),
  ('Nukitsamees', 'L', '75', 'Estonian');


CREATE TABLE "genre" (
   "id" SERIAL PRIMARY KEY,
   "movie_id" INTEGER NOT NULL,
   "genre" VARCHAR(255)
   );

INSERT INTO "genre" ("movie_id", "genre")
VALUES
  ('1','Drama'),
  ('2','Crime'),
  ('2','Drama'),
  ('3','Drama'),
  ('3','Mystery'),
  ('4','Crime'),
  ('4','Drama'),
  ('5','Biography'),
  ('5','Drama'),
  ('5','History'),
  ('6','Adventure'),
  ('6','Western'),
  ('7','Action'),
  ('7','Adventure'),
  ('7','Fantasy'),
  ('7','Sci-Fi'),
  ('8','Action'),
  ('8','Adventure'),
  ('8','Drama'),
  ('8','Fantasy'),
  ('9','Action'),
  ('9','Crime'),
  ('9','Drama'),
  ('9','Thriller'),
  ('10','Crime'),
  ('10','Drama'),
  ('11','Crime'),
  ('11','Drama'),
  ('12','Drama'),
  ('13','Horror'),
  ('13','Mystery'),
  ('13','Thriller'),
  ('14','Drama'),
  ('14','Sci-Fi'),
  ('15','Action'),
  ('15','Adventure'),
  ('15','Fantasy'),
  ('15','Sci-Fi'),
  ('16','Action'),
  ('16','Adventure'),
  ('16','Drama'),
  ('16','Fantasy'),
  ('17','Action'),
  ('17','Sci-Fi'),
  ('18','Drama'),
  ('18','Horror'),
  ('19','Crime'),
  ('19','Drama'),
  ('19','Thriller'),
  ('20','Comedy'),
  ('20','Drama'),
  ('21','Drama'),
  ('21','Musical'),
  ('21','Romance'),
  ('22','War'),
  ('22','Drama'),
  ('23','Action'),
  ('23','Biography'),
  ('23','Crime'),
  ('23','Drama'),
  ('23','History'),
  ('23','Thriller'),
  ('24','Fantasy'),
  ('24','Horror'),
  ('25','Biography'),
  ('25','Drama'),
  ('25','History'),
  ('25','War'),
  ('26','Drama'),
  ('26','Fantasy'),
  ('26','Horror'),
  ('26','Romance'),
  ('27','Action'),
  ('27','Comedy'),
  ('28','Drama'),
  ('29','Family'),
  ('29','Fantasy'),
  ('29','Musical')



