INSERT INTO user_type (value)
VALUES ('ADMIN'),
       ('PLAYER'),
       ('ORGANIZER'),
       ('FOLLOWER'),
       ('ANALYZER');

INSERT INTO tournament_format(value)
VALUES ('GROUP'),
       ('DROP OUT'),
       ('EACH');

INSERT INTO result_type(value)
VALUES ('WIN'),
       ('DRAW'),
       ('LOSE');

INSERT INTO statistics_type(value)
VALUES ('PLAYER'),
       ('TEAM');

INSERT INTO tournament_status(value)
VALUES ('REGISTRATION'),
       ('ACTIVE'),
       ('FINISHED');

INSERT INTO tournament_structure(game_genre, game_name, rules, tournament_format_id, max_team_number,
                                 participation_criteria)
VALUES ('CARD GAME', 'BELOT', null, 2, 25, null),
       ('BOARD GAME', 'AZUL', null, 1, 16, null),
       ('VIDEO GAME', 'LEAGUE OF LEGENDS', null, 3, 20, null);

