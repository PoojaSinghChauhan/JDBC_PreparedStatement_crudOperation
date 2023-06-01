package com.jsp.jdbc_preparedStatement_crud_operation.dto;

public class Country {
	private int countryId;
	private String countryName;
	private String countryCapital;
	private int countryStates;
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countyId) {
		this.countryId = countyId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	public int getCountryStates() {
		return countryStates;
	}
	public void setCountryStates(int countryStates) {
		this.countryStates = countryStates;
	}
	@Override
	public String toString() {
		System.out.println();
		return "countryId=" + countryId + "\n countryName=" + countryName + "\n countryCapital=" + countryCapital
				+ "\n countryStates=" + countryStates + "]";
	}
	
	
}
