package com.nba.api.services;

import com.nba.api.mappers.PlayerMetricMapper;
import com.nba.api.models.PlayerMetric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

  @Autowired
  private JdbcTemplate jdbc;

  public List<PlayerMetric> getTopPlayers() {
    String sql = "SELECT * FROM advanced_metrics ORDER BY per DESC LIMIT 20";
    return jdbc.query(sql, new PlayerMetricMapper());
  }
}
