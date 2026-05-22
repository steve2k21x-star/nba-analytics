package com.nba.api.models;

public class PlayerMetric {
  private int gameId;
  private int playerId;
  private String playerName;
  private String team;
  private double ts;
  private double per;

  // getters and setters
  public int getGameId() { return gameId; }
  public void setGameId(int gameId) { this.gameId = gameId; }
  public int getPlayerId() { return playerId; }
  public void setPlayerId(int playerId) { this.playerId = playerId; }
  public String getPlayerName() { return playerName; }
  public void setPlayerName(String playerName) { this.playerName = playerName; }
  public String getTeam() { return team; }
  public void setTeam(String team) { this.team = team; }
  public double getTs() { return ts; }
  public void setTs(double ts) { this.ts = ts; }
  public double getPer() { return per; }
  public void setPer(double per) { this.per = per; }
}
