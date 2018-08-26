package com.teamSankya.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRetrieveExample {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teamSankya?user=root&password=root"))
		{

				con.setAutoCommit(false);
				
				try (PreparedStatement pstmt2= con.prepareStatement("select * from contact_info where emp_id=? ");
						PreparedStatement pstmt3= con.prepareStatement("select * from address_info where emp_id=? ");
						PreparedStatement pstmt1= con.prepareStatement("select * from employee_info where emp_id=? "))
				{
					pstmt1.setInt(1,Integer.parseInt( args[0]));
					pstmt2.setInt(1,Integer.parseInt( args[0]));
					pstmt3.setInt(1,Integer.parseInt( args[0]));
					
				try(ResultSet rs1=pstmt1.executeQuery();
					ResultSet rs2=pstmt2.executeQuery();
					ResultSet rs3=pstmt3.executeQuery())
				{
					while(rs1.next())
					{

					System.out.println(rs1.getInt("emp_id"));
					System.out.println(rs1.getString("first_name"));
					System.out.println(rs1.getString("last_name"));
					}
					while(rs2.next())
					{
					System.out.println(rs2.getLong("mobile_num"));
					System.out.println(rs2.getString("email_id"));
					
					}
					while(rs3.next())
					{
					System.out.println(rs3.getString("address_1"));
					System.out.println(rs3.getString("address_2"));
					System.out.println(rs3.getInt("pin_code"));
					}
				
					
				con.commit();
				
				}	
		    }
		}
		catch(SQLException e)
       	{
	      e.printStackTrace();
       	}
	}

		
}

	


