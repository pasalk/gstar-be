SELECT setval('follower_f_id_seq', (SELECT MAX(f_id) FROM follower));
SELECT setval('followers_players_fp_id_seq', (SELECT MAX(fp_id) FROM followers_players));
SELECT setval('followers_teams_ft_id_seq', (SELECT MAX(ft_id) FROM followers_teams));
SELECT setval('followers_tournaments_ft_id_seq', (SELECT MAX(ft_id) FROM followers_tournaments));
SELECT setval('game_g_id_seq', (SELECT MAX(g_id) FROM game));
SELECT setval('organizer_o_id_seq', (SELECT MAX(o_id) FROM organizer));
SELECT setval('player_p_id_seq', (SELECT MAX(p_id) FROM player));
SELECT setval('round_r_id_seq', (SELECT MAX(r_id) FROM round));
SELECT setval('statistics_s_id_seq', (SELECT MAX(s_id) FROM statistics));
SELECT setval('team_t_id_seq', (SELECT MAX(t_id) FROM team));
SELECT setval('teams_players_tp_id_seq', (SELECT MAX(tp_id) FROM teams_players));
SELECT setval('tournament_t_id_seq', (SELECT MAX(t_id) FROM tournament));
SELECT setval('tournament_structure_ts_id_seq', (SELECT MAX(ts_id) FROM tournament_structure));
SELECT setval('user_u_id_seq', (SELECT MAX(u_id) FROM "user"));