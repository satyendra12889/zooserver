package com.satyendra.iris.zoo.response.dto;

public class StockDto {
	
	int stockId;
	
	String stockName;

    AnimalDto animal;

    PenDto penResponse;

    AreaDto areaResponse;

    int asisgned;

    public int getAsisgned() {
        return asisgned;
    }

    public void setAsisgned(int asisgned) {
        this.asisgned = asisgned;
    }

    public PenDto getPenResponse() {
        return penResponse;
    }

    public void setPenResponse(PenDto penResponse) {
        this.penResponse = penResponse;
    }

    public AreaDto getAreaResponse() {
        return areaResponse;
    }

    public void setAreaResponse(AreaDto areaResponse) {
        this.areaResponse = areaResponse;
    }

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public AnimalDto getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalDto animal) {
		this.animal = animal;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

}
