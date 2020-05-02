
package com.satyendra.iris.zoo.request.dto;

import lombok.Getter;
import lombok.Setter;


public class PenRequestDto {
    
    String penName;
    int zooId;
	public String getPenName() {
		return penName;
	}
	public void setPenName(String penName) {
		this.penName = penName;
	}
	public int getZooId() {
		return zooId;
	}
	public void setZooId(int zooId) {
		this.zooId = zooId;
	}
    
    

}
