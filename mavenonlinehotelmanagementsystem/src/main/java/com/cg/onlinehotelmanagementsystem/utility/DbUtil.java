package com.cg.onlinehotelmanagementsystem.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
  private static Connection connection=null;
	public static Connection getConnection() {
	  
	  if(connection==null) {
	  try {
		  connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","system");
		   }
	  
	  catch (SQLException sql) {
		  
		
	}}
	  return connection;
	

  }}
