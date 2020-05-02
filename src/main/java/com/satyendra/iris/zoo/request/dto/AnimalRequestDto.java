package com.satyendra.iris.zoo.request.dto;

import com.satyendra.iris.zoo.model.AnimalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalRequestDto {
    String animalName;
    AnimalType type; 
    Integer penId;
}
