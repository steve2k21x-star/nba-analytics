package com.nba.api.services;

import com.nba.api.mappers.TeamKpiMapper;
import com.nba.api.models.TeamKpi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

  @Autowired
  private JdbcTemplate jdbc;

  public List<TeamKpi> getLatestKpi() {
    String sql = "SELECT * FROM team_kpi_summary ORDER BY kpi_date DESC LIMIT 30";
    return jdbc.query(sql, new TeamKpiMapper());
  }
}
