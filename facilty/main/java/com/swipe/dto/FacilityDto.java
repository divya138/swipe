package com.swipe.dto;

import com.sun.istack.NotNull;
public class FacilityDto {
	
	
	@NotNull
	private String facilityBranch;
	@NotNull
	private String facilityCity;
	@NotNull
	private String facilityName;
	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getFacilityBranch() {
		return facilityBranch;
	}

	public void setFacilityBranch(String facilityBranch) {
		this.facilityBranch = facilityBranch;
	}

	public String getFacilityCity() {
		return facilityCity;
	}

	public void setFacilityCity(String facilityCity) {
		this.facilityCity = facilityCity;
	}
}