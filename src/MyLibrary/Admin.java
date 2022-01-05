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
			System.out.println("Enter book id : ");
			int id=sc.nextInt();
			System.out.println("Enter title of the book : ");
			String title=sc.next();
			System.out.println("Enter author name: ");
			String author=sc.next();
			System.out.println("No.of books available: ");
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
			System.out.println("Book Deleted Successfully.....\n");
			
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
			
			PreparedStatement pstmt=con.prepareStatement("update book set bookid=?,title=?,author=?,quantity=? where title=?");
			System.out.println("Enter new id:");
			int id=sc.nextInt();
			pstmt.setInt(1,id);
			
			System.out.println("Enter new title:");
			String title=sc.next();
			pstmt.setString(2,title);
			
			System.out.println("Enter new author:");
			String author=sc.next();
			pstmt.setString(3,author);
			
			System.out.println("Enter no. of books available:");
			int avl=sc.nextInt();
			pstmt.setInt(4,avl);
			
			System.out.println("Enter title where you want to update:");
			String _title=sc.next();
			pstmt.setString(5,_title);
			
			int row=pstmt.executeUpdate();
			System.out.println("Book updated Successfully.....\n");
			
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
			
			PreparedStatement pstmt=con.prepareStatement("select * from book_record1 where id=?");
			System.out.println("Enter Student id: ");
			int id=sc.nextInt();
			
			pstmt.setInt(1, id);
			
			ResultSet rs=pstmt.executeQuery();
			System.out.println("StuId\tBookId\tIssueDate\tReturnDate\tDueDate");
			  while(rs.next())
			  {
				  System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			  }
			  
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
