package com.comcast.crm.orgtest;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.comcast.crm.generic.databaseutility.Databaseutility;

public class Jdbctest_withutility {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Databaseutility db= new Databaseutility();
		db.getDBconnection();
		String Query ="select * from employee";
	ResultSet res= 	db.Executeselectquery(Query);
		while(res.next())
		  {
	  System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));
}
		db.colseDbconnection();

	}

}
