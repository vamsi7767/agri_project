package com.crop.controller;

import com.crop.model.Crop;
import com.crop.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
@CrossOrigin(origins = "http://localhost:4200")
public class CropController {

    @Autowired
    private CropService cropService;

    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crop> getCropById(@PathVariable String id) {
        Crop crop = cropService.getCropById(id);
        if (crop != null) {
            return new ResponseEntity<>(crop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Crop> createCrop(@RequestBody Crop crop) {
        Crop createdCrop = cropService.createCrop(crop);
        return new ResponseEntity<>(createdCrop, HttpStatus.CREATED);
    }
    
    

    @PutMapping("/{id}")
    public ResponseEntity<Crop> updateCrop(@PathVariable String id, @RequestBody Crop cropDetails) {
        Crop updatedCrop = cropService.updateCrop(id, cropDetails);
        if (updatedCrop != null) {
            return new ResponseEntity<>(updatedCrop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrop(@PathVariable String id) {
        cropService.deleteCrop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
