

CREATE TABLE "bookinguser" (
        "id" SERIAL PRIMARY KEY,
        "who_watched" VARCHAR(255) NOT NULL UNIQUE,
        "last_movie_seen" INTEGER NOT NULL


);
INSERT INTO "bookinguser" ("who_watched", "last_movie_seen") VALUES
('Andres', '20')

