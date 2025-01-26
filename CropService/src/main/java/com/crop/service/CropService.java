package com.crop.service;

import com.crop.model.Crop;
import com.crop.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public Crop getCropById(String id) {
        Optional<Crop> crop = cropRepository.findById(id);
        return crop.orElse(null);
    }

    public Crop createCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public Crop updateCrop(String id, Crop cropDetails) {
        Optional<Crop> cropOptional = cropRepository.findById(id);
        if (cropOptional.isPresent()) {
            Crop crop = cropOptional.get();
            crop.setName(cropDetails.getName());
            crop.setType(cropDetails.getType());
            crop.setSeason(cropDetails.getSeason());
            crop.setPrice(cropDetails.getPrice());
            crop.setQuantity(cropDetails.getQuantity());
            crop.setQuality(cropDetails.getQuality());
            return cropRepository.save(crop);
        }
        return null;
    }

    public void deleteCrop(String id) {
        cropRepository.deleteById(id);
    }
}
