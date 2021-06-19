insert into category
values (1, 'WEST', 'Western'),
       (2, 'ADVENT', 'Adventure'),
       (3, 'HOR', 'Horror'),
       (4, 'COM', 'Comedy'),
       (5, 'CART', 'Cartoon'),
       (6, 'DOC', 'Documentary'),
       (7, 'DR', 'Drama'),
       (8, 'FANT', 'Fantasy'),
       (9, 'MUS', 'Musical'),
       (10, 'RACE', 'Race'),
       (11, 'SP', 'Sport'),
       (12, 'SUP', 'Superhero');

insert into users
values (1, 'admin', 'admin', 'ROLE_ADMIN'),
       (2, 'user', 'user', 'ROLE_USER'),
       (3, 'kesha', '12345', 'ROLE_USER'),
       (4, 'niavchik', '12345', 'ROLE_USER'),
       (5, 'zhorzhetta', '12345', 'ROLE_USER'),
       (6, 'marietta', '12345', 'ROLE_USER'),
       (7, 'kolietta', 'admin', 'ROLE_USER');

insert into movie
values (1, 'Rocky', 'John G. Avildsen', 'It tells the rags to riches American Dream story of Rocky Balboa'),
--                          sport, drama
       (2, 'Seven Pounds', 'Gabriele Muccino',
        'A man with a fateful secret embarks on an extraordinary journey of redemption by forever changing the lives of seven strangers'),
--                          drama
       (3, 'Avengers', 'Joss Whedon',
        'American superhero film based on the Marvel Comics superhero team of the same name'),
-- superhero
       (4, 'How to Train Your Dragon', 'Chris Sanders',
        'The story takes place in a mythical Viking world where a young Viking teenager named Hiccup aspires to follow his tribe''s tradition of becoming a dragon slayer'),
--                          Cartoon
       (5, 'Forrest Gump', 'Robert Zemeckis',
        'The story depicts several decades in the life of Forrest Gump (Hanks), a slow-witted but kind-hearted man from Alabama who witnesses and unwittingly influences several defining historical events in the 20th century United States'),
--                          Drama
       (6, 'Avatar', 'James Cameron',
        'The film is set in the mid-22nd century when humans are colonizing Pandora, a lush habitable moon of a gas giant in the Alpha Centauri star system, in order to mine the valuable mineral unobtanium'),
--                          fantasy
       (7, 'The Intouchables', 'Olivier Nakache',
        'The story of the friendship between the two men is then told as a flashback: Philippe, a wealthy quadriplegic who owns a luxurious hôtel particulier, and his assistant Magalie are interviewing candidates to be his live-in caregiver');
-- comedy, drama

insert into movie_category
values (1, 7),
       (1, 11),
       (2, 7),
       (3, 12),
       (4, 5),
       (5, 11),
       (6, 8),
       (7, 11),
       (7, 4);

insert into feedback
values (1, 'some comment', false, 1, 7),
       (2, 'some comment', true, 2, 6),
       (3, 'some comment', true, 3, 5),
       (4, 'some comment', true, 4, 4),
       (5, 'some comment', false, 5, 3),
       (6, 'some comment', true, 6, 2),
       (7, 'some comment', true, 7, 2),
       (8, 'some comment', true, 7, 5),
       (9, 'some comment', false, 6, 7),
       (10, 'some comment', true, 5, 6),
       (11, 'some comment', false, 4, 5),
       (12, 'some comment', true, 3, 6),
       (13, 'some comment', true, 2, 5),
       (14, 'some comment', false, 1, 3),
       (15, 'some comment', true, 2, 2),
       (16, 'some comment', true, 3, 2),
       (17, 'some comment', true, 4, 4),
       (18, 'some comment', true, 5, 4),
       (19, 'some comment', true, 5, 6);

insert into rate
values (1, 1.00, 2, 1),
       (2, 10.00, 3, 2),
       (3, 10.00, 3, 3),
       (4, 6.67, 3, 4),
       (5, 7.50, 4, 5),
       (6, 1, 2, 6),
       (7, 10, 2, 7);