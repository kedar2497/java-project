package MyLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Student {
	
/*	private int id;
	private String pass;
	
	public void Student()
	{
		id=0;
		pass=null;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
*/
	StudentLogin sl=new StudentLogin();
 Scanner sc=new Scanner(System.in);
 
  
    
 //==============================SEARCH BOOK===========================================================================================
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
		 

          if(rs.next())  //if resultset is not empty(means,their is value in resultset)
		  {
        	  System.out.println("Bookid\tTitle\tAuthor\tQuantity");

			  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
			  System.out.println("Book is available...\n");
		  }
          else
          {
        	  System.out.println("Book is not available....\n ");
          }
		  
		  
	   }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
//===========================ISSUE BOOK=============================================================================	
/*	
	public void IssueBook()
	{
	  //StudentLogin s=new StudentLogin();
	  
		try{
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
		 
			  PreparedStatement pstmt=con.prepareStatement("select * from book where title=?");
			  System.out.println("Enter Book Title: ");
			  String title=sc.next();
			  pstmt.setString(1,title);
			  ResultSet rs=pstmt.executeQuery();
			 

	          if(rs.next())  //if resultset is not empty(means,their is value in resultset)
			  {
	        	  System.out.println("Bookid\tTitle\tAuthor\tQuantity");

				  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
				  System.out.println("\nBook is available...\n");
				  
				  System.out.println("Do You Want To Issue Book : ");
				  System.out.println("1.YES"+"\n2.NO");
				  int option=sc.nextInt();
				  
				  switch(option)
				  {
	//-----------------------BOOK AVAILABLE,ISSUE AND DECREASE QUANTITY-----------------------------------------------------  
				  case 1:
					  
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
						
						PreparedStatement pstmt2=con.prepareStatement("update book set quantity=quantity-1 where title=?");
						pstmt2.setString(1, title);
						pstmt2.executeUpdate();
	//------------------------update history---------------------------------------------------------------
						PreparedStatement pstmt5=con.prepareStatement("select bookid from book where title=?"); 
						pstmt5.setString(1, title);
						
						ResultSet rs3=pstmt5.executeQuery();
						
						int a=0;
						while(rs3.next())
						{
							a=rs3.getInt(1);
						}
						
						
						
						PreparedStatement pstmt4=con.prepareStatement("insert into book_record1 values(?,?,curdate(),Null,curdate()+7)");
						
						pstmt4.setInt(1,sl.getId());
						pstmt4.setInt(2, a);
						
						pstmt4.executeUpdate();
						
                       } catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					  }
					  
					  System.out.println("Book Issued Successfully...."+"\nplease return it within time...\n");
					  break;
	//_----------------------------------------------------------------------------------------------------------------------				  
				  case 2:
					  System.out.println("OKAY...");
					  break;
					  
				  }
			  }
	          else
	          {
	        	  System.out.println("Book is not available....\n ");
	          }
			  
			  
		   }
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
*/	
//===============================RETURN BOOK============================================================================	
	/*
	public void ReturnBook()
	{
		StudentLogin s=new StudentLogin();
		try{
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
		 
			  PreparedStatement pstmt=con.prepareStatement("update book set quantity=quantity+1 where title=?");
			  System.out.println("Enter Book Title: ");
			  String title=sc.next();
			  
			  pstmt.setString(1,title);
			  pstmt.executeUpdate();
			  
			  PreparedStatement pstmt1=con.prepareStatement("select bookId from book where title=?");
			  pstmt1.setString(1, title);
			  ResultSet rs=pstmt1.executeQuery();
			  
			  int a=0;
			  while(rs.next())
			  {
				  a=rs.getInt(1);
			  }
			  
			  //System.out.println("a=");
			  
			  PreparedStatement pstmt2=con.prepareStatement("update book_record1 set returndate=curdate() where id=? and bookid=?");
			  pstmt2.setInt(1, s.getId());
			  pstmt2.setInt(2, a);
			  
			  pstmt2.executeUpdate();
			  System.out.println("Book Returned Sucessfully.....\n");
			  
		   }
			catch(Exception e)
			{
				e.printStackTrace();
			}

	}
*/
//========================================VIEW HISTORY========================================================================	
	public void ViewHistory()
	{
		StudentLogin s=new StudentLogin();
/*		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			  PreparedStatement pstmt=con.prepareStatement("select * from book_record1 where id=?");
			  pstmt.setInt(1, getId());
			  
			  ResultSet rs=pstmt.executeQuery();
			  System.out.println("id\tbookId\tissueDate\treturnDate\tdueDate");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
				}
				
				
				
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
 */		
	}
}
