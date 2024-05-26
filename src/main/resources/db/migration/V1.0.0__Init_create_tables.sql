CREATE TABLE user_type
(
    ut_id BIGSERIAL PRIMARY KEY,
    value VARCHAR(255)
);

CREATE TABLE tournament_format
(
    tf_id BIGSERIAL PRIMARY KEY,
    value VARCHAR(255)
);
CREATE TABLE result_type
(
    rt_id BIGSERIAL PRIMARY KEY,
    value VARCHAR(255)
);
CREATE TABLE statistics_type
(
    st_id BIGSERIAL PRIMARY KEY,
    value VARCHAR(255)
);
CREATE TABLE tournament_status
(
    ts_id BIGSERIAL PRIMARY KEY,
    value VARCHAR(255)
);

CREATE TABLE statistics
(
    s_id               BIGSERIAL PRIMARY KEY,
    statistics_type_id INT references statistics_type (st_id)
);

CREATE TABLE "user"
(
    u_id            BIGSERIAL PRIMARY KEY,
    username        VARCHAR(255) UNIQUE,
    email           VARCHAR(255),
    password        VARCHAR(255),
    user_type_id    INT references user_type (ut_id),
    user_subtype_id INT references user_type (ut_id)
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
    rules                  TEXT,
    tournament_format_id   INT references tournament_format (tf_id),
    max_team_number        INT,
    participation_criteria TEXT
);

CREATE TABLE point_system
(
    ps_id                   BIGSERIAL PRIMARY KEY,
    tournament_structure_id INT REFERENCES tournament_structure (ts_id),
    result_type_id          INT REFERENCES result_type (rt_id),
    value                   INT

);

CREATE TABLE tournament
(
    t_id                    BIGSERIAL PRIMARY KEY,
    name                    VARCHAR(255),
    tournament_structure_id INT REFERENCES tournament_structure (ts_id),
    start_date              TIMESTAMP,
    end_date                TIMESTAMP,
    prize_fond              TEXT,
    tournament_status_id INT references tournament_status (ts_id),
    organizer_id            INT REFERENCES organizer (o_id)
);

CREATE TABLE tournament_team
(
    tt_id         BIGSERIAL PRIMARY KEY,
    tournament_id INT REFERENCES tournament (t_id),
    team_id       INT REFERENCES team (t_id),
    points        INT
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

CREATE TABLE result
(
    r_id         BIGSERIAL PRIMARY KEY,
    winner_id    INT REFERENCES team (t_id),
    first_score  INT,
    second_score INT
);

CREATE TABLE game
(
    g_id           BIGSERIAL PRIMARY KEY,
    first_team_id  INT REFERENCES team (t_id),
    second_team_id INT REFERENCES team (t_id),
    date           TIMESTAMP,
    result_id INT references result (r_id),
    round_id       INT REFERENCES round (r_id)
);



