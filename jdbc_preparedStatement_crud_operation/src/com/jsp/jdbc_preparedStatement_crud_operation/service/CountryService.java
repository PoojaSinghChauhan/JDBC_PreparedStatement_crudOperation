package com.jsp.jdbc_preparedStatement_crud_operation.service;

import java.util.ArrayList;
import java.util.List;

import com.jsp.jdbc_preparedStatement_crud_operation.dao.CountryDao;
import com.jsp.jdbc_preparedStatement_crud_operation.dto.Country;
import com.jsp.jdbc_preparedStatement_crud_operation.exeption.IdNotFoundException;

public class CountryService {
	CountryDao countryDao=new CountryDao();
	Country country=new Country();
	public Country saveCountryService(Country country) {
		int id=country.getCountryId();
		int count=0;
		while(id>0) {
			count++;
			id/=10;
			
		}
		int state=country.getCountryStates();
		String countryCapital=country.getCountryCapital();
		if((count>=2&&count<=5)&&(state>10&&state<30)&&(countryCapital.length()>=10)) {
			return countryDao.saveCountry(country);
		}
		else {
			System.out.println("there is something invalid");
			return null;
		}
//		if(count>=2&&count<=5) {
//			if(state >10&&state<30) {
//				if(countryCapital.length()>=10) {
//					return countryDao.saveCountry(country);
//				}else {
//					System.out.println("the number of states should be greater than 10 or less than 30 ");
//					return null;
//				}
//			} else {
//				System.out.println("the length of capital should be less than or equal to 10");
//				return null;
//			}
//		}
//		else {
//			System.out.println("please enter the id within range 2-5");
//			return null;
//		}
	
		

	}
	public void deleteByIdService(int id) {
		Country country=countryDao.getCountryById(id);
		if(country!=null) {
			countryDao.deleteById(id);
		}
		else {
			System.out.println("please enter a valid id");
		}
	}
	public int updateByIdService(int id,String name) {
		Country country=getByIdService(id);
		if(country!=null) {
			countryDao.updateById(id, name);
			return countryDao.updateById(id, name);
		}
		else {
			try {
				throw new IdNotFoundException("id not found");
			}catch(Exception e) {
				e.getMessage();
				return 0;
			}
			
		}
	}
	public List<Country> displayDetailService(Country country){
		List<Country> countryCollection=countryDao.dispalayDetails(country);
		if(countryCollection!=null) {
			return countryCollection;
		}
		return null;
	}
	public Country getByIdService(int id) {
		Country country= countryDao.getCountryById(id);
		if(country!=null) {
			return country;
		}
		else {
			try {
				throw new IdNotFoundException("Id not found please check it");
			}catch(IdNotFoundException e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		
	}
}
