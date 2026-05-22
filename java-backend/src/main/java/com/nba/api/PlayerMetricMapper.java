package com.nba.api.mappers;

import com.nba.api.models.PlayerMetric;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMetricMapper implements RowMapper<PlayerMetric> {
  @Override
  public PlayerMetric mapRow(ResultSet rs, int rowNum) throws SQLException {
    PlayerMetric p = new PlayerMetric();
    p.setGameId(rs.getInt("game_id"));
    p.setPlayerId(rs.getInt("player_id"));
    p.setPlayerName(rs.getString("player_name"));
    p.setTeam(rs.getString("team"));
    p.setTs(rs.getDouble("ts"));
    p.setPer(rs.getDouble("per"));
    return p;
  }
}
