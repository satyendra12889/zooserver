
package com.satyendra.iris.zoo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="pen")
public class Pen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	public String name;
	
	@ManyToOne
	public Area area;
	
	int serialNo;
	

	@OneToOne(mappedBy = "pen")
	public Stock stock;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	public int getSerialNo() {
		return serialNo;
	}


	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stockl) {
		this.stock = stockl;
	}

}
