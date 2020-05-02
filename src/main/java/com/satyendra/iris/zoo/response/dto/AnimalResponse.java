package com.satyendra.iris.zoo.response.dto;

public class AnimalResponse {

    int animalId;

    String type;

    String animalName;

    PenResponse penResponse;

    AreaResponse areaResponse;

    int asisgned;

    

    
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAsisgned() {
        return asisgned;
    }

    public void setAsisgned(int asisgned) {
        this.asisgned = asisgned;
    }

    public PenResponse getPenResponse() {
        return penResponse;
    }

    public void setPenResponse(PenResponse penResponse) {
        this.penResponse = penResponse;
    }

    public AreaResponse getAreaResponse() {
        return areaResponse;
    }

    public void setAreaResponse(AreaResponse areaResponse) {
        this.areaResponse = areaResponse;
    }

    
    
}
