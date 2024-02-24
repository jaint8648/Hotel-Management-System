package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

	Connection c;
	Statement s;
	
	Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		  c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","9311229815");
		s=c.createStatement();
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              new Conn();
	}

}
