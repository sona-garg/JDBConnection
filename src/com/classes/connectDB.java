package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectDB {

	public static void main(String[] args) {
		Connection con=null;
		try {
			String url="jdbc:postgresql://localhost:5432/LMS_DB";
			String user = "postgres";
			String password="admin";
			con=DriverManager.getConnection(url,user,password);
			System.out.println("Connection Created");
			Statement stmt = null;
			String selectQuery = "Select * from books";
			try {
				stmt = con.createStatement();
				
				ResultSet rs= stmt.executeQuery(selectQuery);
				while(rs.next()) {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
				}
				
			}catch(SQLException e) {
				System.out.println("Cant return any value");
			}
			finally {
				if(stmt!=null) {
					stmt.close();
				}
			}
			
		}catch(SQLException e) {
			System.out.println("Connection problem");
			
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
				
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		

	}

}
