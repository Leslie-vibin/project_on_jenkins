package com.comcast.crm.generic.databaseutility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

   
public class Databaseutility {
	Connection con;
	
	
	public void getDBconnection(String url,String username,String password) throws SQLException{
		
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con=DriverManager.getConnection(url,username,password);}
		catch(Exception e) {}
		
	}
public void getDBconnection() throws SQLException{
		
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");}
		catch(Exception e) {}
		
	}
	public void colseDbconnection() throws SQLException {
		try {con.close();
			
		} catch (Exception e) {
		
		}
		
	}
	public ResultSet Executeselectquery(String Query) throws SQLException {
		ResultSet res = null;
		try {
	Statement s=	con.createStatement();
     res=s.executeQuery(Query);}
		catch(Exception e) {
			
		}
     
     return res;
	}
	public int Executenonselectquery(String Query) throws SQLException {
		int res = 0 ;
		try {
	Statement s=con.createStatement();
     res=s.executeUpdate(Query);}
		catch(Exception e) {
			
		}
     
     return res;
	}

}
