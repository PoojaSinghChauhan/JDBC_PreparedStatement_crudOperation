package com.jsp.jdbc_preparedStatement_crud_operation.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.jdbc_preparedStatement_crud_operation.dto.Country;
import com.jsp.jdbc_preparedStatement_crud_operation.service.CountryService;

public class CountryController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		Country country=new Country();
		CountryService countryService=new CountryService();
		
		while(true) {
			System.out.println("1.insert\n2.delete\n3.update capital name\n4.display\n5.display by id\n6.exit");
			System.out.println("enter choice:");
			int ch=sc.nextInt();
			switch(ch) {
				case 1:{
					System.out.println("enter country id:");
					int id=sc.nextInt();
					country.setCountryId(id);
			
					System.out.println("enter country name:");
					String name=sc.next();
					country.setCountryName(name);
			
					System.out.println("enter the country capital:");
					String capital=sc.next();
					country.setCountryCapital(capital);
			
					System.out.println("enter number of states:");
					int states=sc.nextInt();
					country.setCountryStates(states);
			
					countryService.saveCountryService(country);
			
				}
				break;
				case 2:{
					System.out.println("enter id to delete the record");
					int id=sc.nextInt();
					countryService.deleteByIdService(id);
					
				}
				break;
				case 3: {
					System.out.println("Enter id to update the record");
					int id=sc.nextInt();
					System.out.println("enter capital name");
					
					String name=sc.next();
					name=name+sc.nextLine();
					int i=countryService.updateByIdService(id, name);
					if(i==1)
						System.out.println("data updated successfully");
					
				
				}
				break;
				case 4: {
//					List<Country>countryCollection=countryService.displayDetailService(country);
//					System.out.println("The details are:");
//					for(Country c:countryCollection) {
//						System.out.println(c);
//						System.out.println("country id: "+c.getCountryId());
//						System.out.println("country name: "+c.getCountryName());
//						System.out.println("country capital: "+c.getCountryCapital());
//						System.out.println("no. of districts: "+c.getCountryStates());
//						System.out.println();
//					}
						
						for(Country c:countryService.displayDetailService(country)) {
							System.out.println(c);
						}
				}
				break;
				case 5:{
					System.out.println("enter the id to retrive the record:");
					int id=sc.nextInt();
					Country c=countryService.getByIdService(id);
					if(c!=null) {
						
						System.out.println(country);
					}
				}
				break;
				case 6: {
					System.exit(0);
				}
				break;
				
				default :
					System.out.println("please enter a valid choice");
			}
		}

	}

}
