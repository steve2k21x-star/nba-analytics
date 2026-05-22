CREATE OR REPLACE VIEW v_top_players AS
SELECT player_name, team, AVG(per) AS avg_per, AVG(ts) AS avg_ts
FROM advanced_metrics
GROUP BY player_name, team
ORDER BY avg_per DESC;
