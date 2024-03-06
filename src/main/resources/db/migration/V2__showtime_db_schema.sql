CREATE TABLE "showtime" (
        "id" SERIAL PRIMARY KEY,
        "start_15_00" INTEGER NOT NULL,
        "start_16_30" INTEGER NOT NULL,
        "start_18_00" INTEGER NOT NULL,
        "start_19_30" INTEGER NOT NULL,
        "start_21_00" INTEGER NOT NULL,
        "start_22_30" INTEGER NOT NULL

);

INSERT INTO "showtime" ("start_15_00" ,"start_16_30","start_18_00","start_19_30","start_21_00","start_22_30")
VALUES

  ('24', '14', '4','27','15','17'),
  ('29', '21', '28','25','26','13'),
  ('19', '22', '5','2','6','9'),
  ('7', '3', '16','18','23','11'),
  ('20', '10', '8','1','12','14'),
  ('29', '28', '5','13','17','26'),
  ('4', '9', '2','12','5','22')




