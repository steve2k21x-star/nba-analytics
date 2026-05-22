package com.nba.api.controllers;

import com.nba.api.models.TeamKpi;
import com.nba.api.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "*")
public class TeamController {

  @Autowired
  private TeamService service;

  @GetMapping("/kpi")
  public List<TeamKpi> getTeamKpi() {
    return service.getLatestKpi();
  }
}
