

CREATE TABLE "bookinguser" (
        "id" SERIAL PRIMARY KEY,
        "who_watched" VARCHAR(255) NOT NULL UNIQUE,
        "last_movie_seen" INTEGER NOT NULL,
         "last_movie_time" VARCHAR(255) NOT NULL

);


