/* Exercise1 */
SELECT title FROM movie WHERE director LIKE "%Spielberg%";

/* Exercise2 */
SELECT DISTINCT movie.year FROM movie INNER JOIN rating ON movie.mID = rating.mID WHERE stars BETWEEN 4 AND 5 ORDER BY year asc;

/* Exercise3 */
SELECT movie.title FROM movie LEFT JOIN rating ON movie.mID = rating.mID WHERE rID IS NULL;

/* Exercise4 */
SELECT DISTINCT reviewer.name
FROM reviewer
LEFT JOIN rating
ON reviewer.rID = rating.rID
WHERE rating.ratingDate IS null;

/* Exercise5 */
SELECT reviewer.name, movie.title, rating.stars, rating.ratingDate
FROM movie
INNER JOIN rating
ON movie.mID = rating.mID
INNER JOIN reviewer
ON reviewer.rID = rating.rID
ORDER BY reviewer.name ASC,
movie.title ASC,
rating.stars ASC;

/* Exercise6 */
SELECT reviewer.name, movie.title
FROM movie
INNER JOIN rating
    ON movie.mID = rating.mID 
INNER JOIN reviewer
    ON reviewer.rID = rating.rID
INNER JOIN rating AS secondRating 
	ON movie.mID = secondRating.mID
	AND reviewer.rID = secondRating.rID
WHERE secondRating.stars > rating.stars
    AND secondRating.ratingDate > rating.ratingDate;
	
/* Exercise7 */
SELECT movie.title, MAX(rating.stars) AS "max stars"
FROM movie
INNER JOIN rating
    ON movie.mID = rating.mID 
INNER JOIN reviewer
    ON reviewer.rID = rating.rID
WHERE rating.stars IS NOT null
GROUP BY movie.title
ORDER BY movie.title;

/* Exercise8 */
SELECT movie.title, MAX(rating.stars) - MIN(rating.stars) AS rating_spread
FROM movie
INNER JOIN rating
	ON movie.mID = rating.mID
INNER JOIN reviewer
	ON reviewer.rID = rating.rID
WHERE rating.stars IS NOT null
GROUP BY movie.title
ORDER BY rating_spread DESC;

/* Exercise9 */

SELECT (
	(SELECT AVG (eachAVG) 
    FROM 
        (SELECT title, AVG (stars) AS eachAVG
        FROM movie
        INNER JOIN rating
            ON movie.mID = rating.mID
            WHERE year < 1980 
        GROUP BY movie.title
        ) AS grandAVG
	)
	-
	(SELECT AVG (eachAVG) 
    FROM 
        (SELECT title, AVG (stars) AS eachAVG
        FROM movie
        INNER JOIN rating
            ON movie.mID = rating.mID
            WHERE year > 1980 
        GROUP BY movie.title
        ) AS grandAVG
	)
) AS result ;


