package com.betrybe.agrix.controllers;

import static org.springframework.web.servlet.function.ServerResponse.status;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FarmService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * class.
 */

@RestController
@RequestMapping(value = "/crops")
public class CropController {
  private CropService cropService;
  private FarmService farmService;

  @Autowired
  public CropController(CropService cropService, FarmService farmService) {
    this.cropService = cropService;
    this.farmService = farmService;
  }


  /**
   * getCrop.
   */


  @GetMapping()
  public List<CropDto> getAllCrops() {
    List<Crop> listCrops = cropService.getAllCrops();
    Stream<CropDto> cropDtoStream = listCrops.stream()
        .map(crop -> new CropDto(
            crop.getId(), crop.getName(), crop.getPlantedArea(), crop.getFarm().getId()));
    return cropDtoStream.toList();
  }
}
