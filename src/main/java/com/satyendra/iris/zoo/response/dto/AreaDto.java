package com.satyendra.iris.zoo.response.dto;

import java.util.List;

public class AreaDto {
	
		int areaId;
		
		String areaName;
		
		List<PenDto> allPens;

		public int getAreaId() {
			return areaId;
		}

		public void setAreaId(int areaId) {
			this.areaId = areaId;
		}

		public String getAreaName() {
			return areaName;
		}

		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}
		
		public List<PenDto> getAllPens() {
			return allPens;
		}

		public void setAllPens(List<PenDto> allPens) {
			this.allPens = allPens;
		}

}
