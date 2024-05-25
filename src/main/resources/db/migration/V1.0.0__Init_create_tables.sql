CREATE TYPE user_type AS ENUM ('ADMIN', 'PLAYER', 'ORGANIZER', 'FOLLOWER', 'ANALYZER');
CREATE TYPE tournament_format AS ENUM ('GROUP', 'DROP OUT', 'EACH');
CREATE TYPE result_type AS ENUM ('WIN', 'DRAW', 'LOSE');
CREATE TYPE statistics_type AS ENUM ('PLAYER', 'TEAM');
CREATE TYPE tournament_status AS ENUM ('REGISTRATION', 'ACTIVE', 'FINISHED');

CREATE TABLE statistics
(
    s_id            BIGSERIAL PRIMARY KEY,
    statistics_type statistics_type
);

CREATE TABLE "user"
(
    u_id         BIGSERIAL PRIMARY KEY,
    username     VARCHAR(255) UNIQUE,
    email        VARCHAR(255),
    password     VARCHAR(255),
    user_type    user_type,
    user_subtype user_type
);

CREATE TABLE player
(
    p_id            BIGSERIAL PRIMARY KEY,
    user_id         INT REFERENCES "user" (u_id),
    name            VARCHAR(255),
    surname         VARCHAR(255),
    avatar          VARCHAR(255),
    biography       TEXT,
    preferred_games TEXT[],
    statistics_id   INT REFERENCES statistics (s_id)
);

CREATE TABLE team
(
    t_id          BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255),
    statistics_id INT REFERENCES statistics (s_id)
);

CREATE TABLE teams_players
(
    tp_id     BIGSERIAL PRIMARY KEY,
    player_id INT REFERENCES player (p_id),
    team_id   INT REFERENCES team (t_id)
);

CREATE TABLE organizer
(
    o_id    BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255),
    surname VARCHAR(255),
    user_id INT REFERENCES "user" (u_id)
);

CREATE TABLE follower
(
    f_id    BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255),
    surname VARCHAR(255),
    user_id INT REFERENCES "user" (u_id)
);

CREATE TABLE followers_players
(
    fp_id       BIGSERIAL PRIMARY KEY,
    follower_id INT REFERENCES follower (f_id),
    player_id   INT REFERENCES player (p_id)
);

CREATE TABLE followers_teams
(
    ft_id       BIGSERIAL PRIMARY KEY,
    follower_id INT REFERENCES follower (f_id),
    team_id     INT REFERENCES team (t_id)
);

CREATE TABLE tournament_structure
(
    ts_id                  BIGSERIAL PRIMARY KEY,
    game_genre             VARCHAR(255),
    game_name              VARCHAR(255),
    rules                  JSONB,
    tournament_format      tournament_format,
    max_team_number        INT,
    participation_criteria TEXT,
    point_system           JSONB
);

CREATE TABLE tournament
(
    t_id                    BIGSERIAL PRIMARY KEY,
    name                    VARCHAR(255),
    tournament_structure_id INT REFERENCES tournament_structure (ts_id),
    start_date              TIMESTAMP,
    end_date                TIMESTAMP,
    rang_list               JSONB,
    prize_fond              TEXT,
    tournament_status       tournament_status,
    organizer_id            INT REFERENCES organizer (o_id)
);

CREATE TABLE followers_tournaments
(
    ft_id         BIGSERIAL PRIMARY KEY,
    follower_id   INT REFERENCES follower (f_id),
    tournament_id INT REFERENCES tournament (t_id)
);

CREATE TABLE round
(
    r_id          BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255),
    start_date    TIMESTAMP,
    end_date      TIMESTAMP,
    tournament_id INT REFERENCES tournament (t_id)
);

CREATE TABLE game
(
    g_id           BIGSERIAL PRIMARY KEY,
    first_team_id  INT REFERENCES team (t_id),
    second_team_id INT REFERENCES team (t_id),
    date           TIMESTAMP,
    result         JSONB,
    round_id       INT REFERENCES round (r_id)
);


