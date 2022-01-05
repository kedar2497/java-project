package MyLibrary;

import java.sql.*;
import java.util.Scanner;

public class Admin {
     
	Scanner sc=new Scanner(System.in);
//===============================LOGIN=======================================================================	
	
	
	
	
	
	
//==============================ADD BOOK=========================================================================	
	
	public void AddBook()
	{
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
			PreparedStatement pstmt=con.prepareStatement("insert into book values(?,?,?,?)");
			System.out.println("enter book id : ");
			int id=sc.nextInt();
			System.out.println("enter title of the book : ");
			String title=sc.next();
			System.out.println("enter author name: ");
			String author=sc.next();
			System.out.println("availability of book: ");
			int avl=sc.nextInt();
			
			pstmt.setInt(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setInt(4,avl);
			
			int query=pstmt.executeUpdate();
			System.out.println("Book Added Successfully...\n");
			
			//stmt.execute("create table student(studentid int,firstname varchar(255),lastname varchar(255),branch varchar(255))");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

//=================================DELETE BOOK===========================================================================================
	
	public void DeleteBook()
	{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
			PreparedStatement pstmt=con.prepareStatement("delete from book where title=?");
			System.out.println("Enter book title to delete");
			String title=sc.next();
			pstmt.setString(1, title);
			
			int query=pstmt.executeUpdate();
			System.out.println("Book Deleted Successfully.....");
			
			}
			catch(Exception e)
			{
				 e.printStackTrace();
			}
	}
//=================================UPDATE BOOK============================================================================================	
	public void UpdateBook()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
			PreparedStatement pstmt=con.prepareStatement("update book set bookid=?,title=?,author=?,available=? where title=?");
			System.out.println("Enter new id:");
			int id=sc.nextInt();
			pstmt.setInt(1,id);
			
			System.out.println("Enter new title:");
			String title=sc.next();
			pstmt.setString(2,title);
			
			System.out.println("Enter new author:");
			String author=sc.next();
			pstmt.setString(3,author);
			
			System.out.println("Enter new available:");
			int avl=sc.nextInt();
			pstmt.setInt(4,avl);
			
			System.out.println("Enter title where you want to update:");
			String _title=sc.next();
			pstmt.setString(5,_title);
			
			int row=pstmt.executeUpdate();
			System.out.println("Book updated Successfully.....");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
//=====================================STUDENT HISTORY===========================================================================================	
	
	public void StudentHistory()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
			PreparedStatement pstmt=con.prepareStatement("update book set bookid=?,title=?,author=?,available=? where title=?");
			System.out.println("Enter new id:");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
