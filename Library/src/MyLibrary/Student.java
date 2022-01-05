package MyLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student {
    Scanner sc=new Scanner(System.in);
	public void SearchBook()
	{
	 try{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		
	 
		  PreparedStatement pstmt=con.prepareStatement("select * from book where title=?");
		  System.out.println("Enter Book Title: ");
		  String title=sc.next();
		  pstmt.setString(1,title);
		  ResultSet rs=pstmt.executeQuery();
		  System.out.println("id\tBookid\ttitle\tauthor\tavailable");
		  while(rs.next())
		  {
			  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
		  }
		  
		  
	   }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
//========================================================================================================	
	public void IssueBook()
	{
		
	}
//===========================================================================================================	
	public void ReturnBook()
	{
		
	}
//================================================================================================================	
	public void ViewHistory()
	{
		
	}
}
