package com.teamSankya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDeleteExample {



	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teamSankya?user=root&password=root"))
		{

				con.setAutoCommit(false);
		
				try (PreparedStatement pstmt1= con.prepareStatement("delete from employee_info  where emp_id=?");
						PreparedStatement pstmt2= con.prepareStatement("delete from contact_info  where emp_id=?");
						PreparedStatement pstmt3= con.prepareStatement("delete from address_info  where emp_id=?"))
						
				{
				//setters for pstmt1 and pstmt1.executeupdate
				pstmt1.setInt(1,Integer.parseInt( args[0]));
				pstmt2.setInt(1,Integer.parseInt( args[0]));

				pstmt3.setInt(1,Integer.parseInt( args[0]));

				
				int count1=pstmt1.executeUpdate();
				
				int count2=pstmt2.executeUpdate();

				int count3=pstmt3.executeUpdate();
				
			    System.out.println("count1= "+count1+"  count2= "+count2+"  count3=  "+count3);


				con.commit();
				}
		}
		
				catch(SQLException e)
				{
					e.printStackTrace();
				}
	}

}

