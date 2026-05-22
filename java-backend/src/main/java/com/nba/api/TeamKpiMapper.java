package com.nba.api.mappers;

import com.nba.api.models.TeamKpi;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamKpiMapper implements RowMapper<TeamKpi> {
  @Override
  public TeamKpi mapRow(ResultSet rs, int rowNum) throws SQLException {
    TeamKpi k = new TeamKpi();
    k.setKpiDate(rs.getDate("kpi_date").toLocalDate());
    k.setTeam(rs.getString("team"));
    k.setOffensiveRating(rs.getDouble("offensive_rating"));
    k.setDefensiveRating(rs.getDouble("defensive_rating"));
    k.setNetRating(rs.getDouble("net_rating"));
    return k;
  }
}
