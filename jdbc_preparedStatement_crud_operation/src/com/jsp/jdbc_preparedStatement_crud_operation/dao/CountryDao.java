package com.jsp.jdbc_preparedStatement_crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.jdbc_preparedStatement_crud_operation.connection.CountryConnection;
import com.jsp.jdbc_preparedStatement_crud_operation.dto.Country;

public class CountryDao {
	Connection connection=CountryConnection.getCountryCounnection();
	public Country saveCountry(Country country) {
		String insertCountryQuery="insert into country values(?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(insertCountryQuery);
			preparedStatement.setInt(1, country.getCountryId());
			preparedStatement.setString(2, country.getCountryName());
			preparedStatement.setString(3,country.getCountryCapital());
			preparedStatement.setInt(4, country.getCountryStates());
			preparedStatement.execute();
			System.out.println("Data inserted");
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return country;
		
	}
	public Country getCountryById(int id) {
		String displayQuery="select *from country where countryId="+id;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(displayQuery);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				 Country country =new Country();
				 country.setCountryId(resultSet.getInt("countryId"));
				 country.setCountryName(resultSet.getString("countryName"));
				 country.setCountryCapital(resultSet.getString("countryCapital"));
				 country.setCountryStates(resultSet.getInt("countryStates"));
				 
				 return country;
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return null;
	}
	public void deleteById(int id) {
		String deleteQuery="delete from country where countryId= ?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("data deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int updateById(int id, String name) {
		String updateQuery="update country set countryCapital=?where countryId=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);
			preparedStatement.setString(1,name);
			preparedStatement.setInt(2, id);
			return preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public List<Country> dispalayDetails(Country country){
		String displayQuery="select*from country";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(displayQuery);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<Country>countryCollection=new ArrayList<>();
			while(resultSet.next()) {
				int id=resultSet.getInt("countryId");
				String name=resultSet.getString("countryName");
				String capital=resultSet.getString("countryCapital");
				int states=resultSet.getInt("countryStates");
				Country c=new Country();
				c.setCountryId(id);
				c.setCountryName(name);
				c.setCountryCapital(capital);
				c.setCountryStates(states);
				countryCollection.add(c);
			}
			return countryCollection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
