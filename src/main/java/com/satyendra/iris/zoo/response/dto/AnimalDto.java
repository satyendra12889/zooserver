package com.satyendra.iris.zoo.response.dto;

import java.util.List;

public class AnimalDto {
	
	int animalId;

    String type;
    int typeId;
    
    String animalName;
    
    List<StockDto> stocks;
    
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

    public List<StockDto> getStocks() {
		return stocks;
	}

	public void setStocks(List<StockDto> stocks) {
		this.stocks = stocks;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

}
