package com.teamSankya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionUpdateExample {

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teamSankya?user=root&password=root"))
		{

				con.setAutoCommit(false);
		
				try (PreparedStatement pstmt1= con.prepareStatement("update employee_info set first_name =? where emp_id=?");
						PreparedStatement pstmt2= con.prepareStatement("update contact_info set mobile_num =? where emp_id=?");
						PreparedStatement pstmt3= con.prepareStatement("update address_info set address_1 =? where emp_id=?"))
				{
				//setters for pstmt1 and pstmt1.executeupdate
				pstmt1.setString(1, args[0]);
				pstmt1.setInt(2,Integer.parseInt( args[1]));
				//pstmt1.setString(3, args[2]);
				
						
				//setters for pstmt2 and pstmt2.executeupdate
				pstmt2.setInt(2, Integer.parseInt(args[1]));
				pstmt2.setLong(1, Long.parseLong(args[2]));
			
						
				//setters for pstmt3 and pstmt3.executeupdate
				pstmt3.setString(1, args[3]);
				pstmt3.setInt(2,Integer.parseInt( args[1]));
				
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

