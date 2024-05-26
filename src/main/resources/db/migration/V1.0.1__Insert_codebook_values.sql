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