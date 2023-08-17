package com.betrybe.agrix.service;


import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class.
 */

@Service
public class FarmService {
  private final FarmRepository farmRepository;

  @Autowired

  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  Farm farm;

  public Farm insertFarm(Farm farm) {
    return farmRepository.save(farm);
  }
}
