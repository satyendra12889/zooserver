package com.satyendra.iris.zoo.request.dto;

public class StockRequestDto {
	String name;
	int id;
	int animaId;
    int penId;
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnimaId() {
		return animaId;
	}
	public void setAnimaId(int animaId) {
		this.animaId = animaId;
	}
	public int getPenId() {
		return penId;
	}
	public void setPenId(int penId) {
		this.penId = penId;
	}
    
    
    
}
