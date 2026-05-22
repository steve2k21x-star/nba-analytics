CREATE TABLE IF NOT EXISTS raw_games (
  game_id INT PRIMARY KEY,
  game_date DATE,
  home_team VARCHAR,
  visitor_team VARCHAR,
  home_score INT,
  visitor_score INT
);

CREATE TABLE IF NOT EXISTS player_stats (
  game_id INT,
  player_id INT,
  player_name VARCHAR,
  team VARCHAR,
  pts INT,
  reb INT,
  ast INT,
  stl INT,
  blk INT,
  tov INT,
  fga INT,
  fta INT,
  PRIMARY KEY (game_id, player_id)
);

CREATE TABLE IF NOT EXISTS advanced_metrics (
  game_id INT,
  player_id INT,
  player_name VARCHAR,
  team VARCHAR,
  ts NUMERIC,
  per NUMERIC,
  PRIMARY KEY (game_id, player_id)
);

CREATE TABLE IF NOT EXISTS team_kpi_summary (
  kpi_date DATE,
  team VARCHAR,
  offensive_rating NUMERIC,
  defensive_rating NUMERIC,
  net_rating NUMERIC,
  PRIMARY KEY (kpi_date, team)
);
