package com.nba.api.models;

import java.time.LocalDate;

public class TeamKpi {
  private LocalDate kpiDate;
  private String team;
  private double offensiveRating;
  private double defensiveRating;
  private double netRating;

  // getters and setters
  public LocalDate getKpiDate() { return kpiDate; }
  public void setKpiDate(LocalDate kpiDate) { this.kpiDate = kpiDate; }
  public String getTeam() { return team; }
  public void setTeam(String team) { this.team = team; }
  public double getOffensiveRating() { return offensiveRating; }
  public void setOffensiveRating(double offensiveRating) { this.offensiveRating = offensiveRating; }
  public double getDefensiveRating() { return defensiveRating; }
  public void setDefensiveRating(double defensiveRating) { this.defensiveRating = defensiveRating; }
  public double getNetRating() { return netRating; }
  public void setNetRating(double netRating) { this.netRating = netRating; }
}
