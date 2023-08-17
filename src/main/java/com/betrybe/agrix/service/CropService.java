package com.betrybe.agrix.service;

import com.betrybe.agrix.models.repositories.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class.
 */


@Service
public class CropService {
  private CropRepository cropRepository;

  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }
  
}
