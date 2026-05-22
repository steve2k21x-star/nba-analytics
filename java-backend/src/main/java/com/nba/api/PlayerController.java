package com.nba.api.controllers;

import com.nba.api.models.PlayerMetric;
import com.nba.api.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "*")
public class PlayerController {

  @Autowired
  private PlayerService service;

  @GetMapping("/top")
  public List<PlayerMetric> getTopPlayers() {
    return service.getTopPlayers();
  }
}
