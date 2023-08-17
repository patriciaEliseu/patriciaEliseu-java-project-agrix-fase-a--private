package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.controllers.dto.ResponseDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

  /**
   * post.
   */

  @PostMapping()
  public ResponseEntity<Farm> createFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.insertFarm(farmDto.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }

  /**
   * Get.
   */

  @GetMapping
  public List<FarmDto> getAllFarm() {
    List<Farm> allFarms = farmService.getAllFarms();
    return allFarms.stream()
        .map(farm -> new FarmDto(farm.getId(), farm.getName(), farm.getSize()))
        .collect(Collectors.toList());
  }


  /**
   * GetId.
   */


  @GetMapping("/{id}")
  public ResponseEntity<ResponseDto<Farm>> getFarmById(@PathVariable Long id) {
    Optional<Farm> optionalFarm = farmService.getFarmById(id);
    if (optionalFarm.isEmpty()) {
      ResponseDto<Farm> responseDto = new ResponseDto<>(
          String.format("Fazenda não encontrada!", id), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }
    ResponseDto<Farm> responseDto = new ResponseDto<>("Fazenda encontrada!", optionalFarm.get());
    return ResponseEntity.ok(responseDto);
  }
}
