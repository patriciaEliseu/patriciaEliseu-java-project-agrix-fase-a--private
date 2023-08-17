package com.betrybe.agrix.controllers;


import com.betrybe.agrix.controllers.dto.FarmDTO;
import com.betrybe.agrix.controllers.dto.ResponseDTO;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * class.
 */


@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping()
  public ResponseEntity<Farm> createFarm(@RequestBody FarmDTO farmDTO) {
    Farm newFarm = farmService.insertFarm(farmDTO.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }

  @GetMapping
  public List<FarmDTO> getAllFarm() {
    List<Farm> allFarms = farmService.getAllFarms();
    return allFarms.stream()
        .map(farm -> new FarmDTO(farm.getId(), farm.getName(), farm.getSize()))
        .collect(Collectors.toList());
  }
}
