package project.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindAvgRadius {

	public static void main (String [] args) throws Exception{
		int rad = 0; 
		int somma = 0;
		int counter = 0; 
		try {
	         // Step 1: Allocate a database "Connection" object
	         Connection conn = DriverManager.getConnection(
	               "jdbc:mysql://localhost:3306/flickr_teledata", "root", "SS7IAZ_*"); // MySQL
//	       
	 
	         // Step 2: Allocate a "Statement" object in the Connection
	         Statement stmt = conn.createStatement();
	       {
		
		String file = "alleventscelllac.tsv";
		String line;
		BufferedReader br = new BufferedReader(new FileReader(new File(file)));
		while ((line = br.readLine())!= null){
			String []linea = line.split(";");
			//String s = linea[0];
			//String s1 = linea[1];
			//System.out.println(s+", "+s1);
			int celllac = Integer.parseInt(linea[2]);
			 String strSelect = "SELECT  radius from network where celllac = '"+celllac+"'";
	         System.out.println("The SQL query is: " + strSelect);
	         ResultSet rset = stmt.executeQuery(strSelect);
	         while(rset.next()) {   // Move the cursor to the next row
		            
		         rad = rset.getInt("radius");
		         }
			rset.close();
			somma += rad;
			counter++;
			
		}
		br.close();
	       }
		}catch(SQLException ex) {
		         ex.printStackTrace();
		      }
		
		int result = somma/counter;
		System.out.println(result);
		
	}
	public static int getRadius(int celllac){
		int rad = 0; 
		
		try {
	         // Step 1: Allocate a database "Connection" object
	         Connection conn = DriverManager.getConnection(
	               "jdbc:mysql://localhost:3306/flickr_teledata", "root", "SS7IAZ_*"); // MySQL
//	       
	 
	         // Step 2: Allocate a "Statement" object in the Connection
	         Statement stmt = conn.createStatement();
	       {
	         // Step 3: Execute a SQL SELECT query, the query result
	         //  is returned in a "ResultSet" object.
	         String strSelect = "SELECT  radius from network where celllac = '"+celllac+"'";
	         System.out.println("The SQL query is: " + strSelect); // Echo For debugging
	         System.out.println();
	 
	         ResultSet rset = stmt.executeQuery(strSelect);
	 
	         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
	         //  For each row, retrieve the contents of the cells with getXxx(columnName).
	         System.out.println("The records selected are:");
	         int rowCount = 0;
	         while(rset.next()) {   // Move the cursor to the next row
	            
	           rad = rset.getInt("radius");
	         }
	         System.out.println("Total number of records = " + rowCount);
	      }
	      } catch(SQLException ex) {
	         ex.printStackTrace();
	      }
	      // Step 5: Close the resources - Done automatically by try-with-resources
	   
	
		
		return rad;
		
	}
}
