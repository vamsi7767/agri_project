package com.crop.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "crop")
public class Crop {

    @Id
    private String id;
    private String name;
    private String type;
    private String season;
    private double price;
    private int quantity;
    private String quality;
    private String description;
    private String img;
}
