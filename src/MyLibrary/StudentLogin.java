package MyLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentLogin {
   
	Scanner sc=new Scanner(System.in);
	private int id;
	private String pass;
	
	public StudentLogin()
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
	
//======================================LOGIN==================================================================	
	 public void Login()
	    {
	    	System.out.println("Enter Id: ");
	    	setId(sc.nextInt());
	    	System.out.println("Enter Password: ");
	    	setPass(sc.next());
	    	
	        try {
				
	            Class.forName("com.mysql.cj.jdbc.Driver");
	  		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	  		
	  		    PreparedStatement pstmt=con.prepareStatement("select id from student where id=?");//checking wrong id
	  		    pstmt.setInt(1, getId());
	  		   
	  		    ResultSet rs=pstmt.executeQuery();
	        	
	        	if(!rs.next())
	        	{
	        		System.out.println("Register first... \n"); 
	        	}
	        	
	        	else
	        	{
	        		PreparedStatement pstmt1=con.prepareStatement("select password from student where id=? and password=?");//checking password
	      		    pstmt1.setInt(1, getId());
	      		    pstmt1.setString(2, getPass());
	      		   
	      		    ResultSet rs1=pstmt1.executeQuery();
	      		    
	      		    if(!rs1.next())
	          	       {
	          		      System.out.println("You have entered wrong password..... \n"); 
	          	       }
	      		    else
	      		    {
	      		    	System.out.println("Login Successfully.......\n");
		      		    Student s=new Student();
		      		    int option;
		      		    
		      		    do
		      		    {
		      		    	System.out.println("Choose Operation: ");
		 	      		    System.out.println("1.Search Book"+"\n2.Issue Book"+"\n3.Return Book"+"\n4.View History"+"\n0.Log Out");
		 	      		    option =sc.nextInt();
		 	      		    
		 	      		    switch(option)
		 	      		    {
		 	      		    case 1:
		 						s.SearchBook();
		 						break;
		 						
		 					case 2:
		 						//s.IssueBook();
		 						try{
		 							  Class.forName("com.mysql.cj.jdbc.Driver");
		 							  Connection con7=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		 							
		 						 
		 							  PreparedStatement pstmt7=con7.prepareStatement("select * from book where title=?");
		 							  System.out.println("Enter Book Title: ");
		 							  String title=sc.next();
		 							  pstmt7.setString(1,title);
		 							  ResultSet rs7=pstmt7.executeQuery();
		 							 

		 					          if(rs7.next())  //if resultset is not empty(means,their is value in resultset)
		 							  {
		 					        	  System.out.println("Bookid\tTitle\tAuthor\tQuantity");

		 								  System.out.println(rs7.getInt(1)+"\t"+rs7.getString(2)+"\t"+rs7.getString(3)+"\t"+rs7.getInt(4));
		 								  System.out.println("\nBook is available...\n");
		 								  
		 								  System.out.println("Do You Want To Issue Book : ");
		 								  System.out.println("1.YES"+"\n2.NO");
		 								  int option7=sc.nextInt();
		 								  
		 								  switch(option7)
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
		 										
		 										pstmt4.setInt(1,getId());
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
		 					    break;
		 						
		 					case 3:
		 						//s.ReturnBook();
		 						try{
		 							  Class.forName("com.mysql.cj.jdbc.Driver");
		 							  Connection con11=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		 							
		 						 
		 							  PreparedStatement pstmt11=con11.prepareStatement("update book set quantity=quantity+1 where title=?");
		 							  System.out.println("Enter Book Title: ");
		 							  String title=sc.next();
		 							  
		 							  pstmt11.setString(1,title);
		 							  pstmt11.executeUpdate();
		 							  
		 							  PreparedStatement pstmt13=con11.prepareStatement("select bookId from book where title=?");
		 							  pstmt13.setString(1, title);
		 							  ResultSet rs13=pstmt13.executeQuery();
		 							  
		 							  int a=0;
		 							  while(rs13.next())
		 							  {
		 								  a=rs13.getInt(1);
		 							  }
		 							  
		 							  //System.out.println("a=");
		 							  
		 							  PreparedStatement pstmt15=con11.prepareStatement("update book_record1 set returndate=curdate() where id=? and bookid=?");
		 							  pstmt15.setInt(1, getId());
		 							  pstmt15.setInt(2, a);
		 							  
		 							  pstmt15.executeUpdate();
		 							  System.out.println("Book Returned Sucessfully.....\n");
		 							  
		 						   }
		 							catch(Exception e)
		 							{
		 								e.printStackTrace();
		 							}
		 						break;
		 						
		 					case 4:
		 						//s.ViewHistory();
		 						try {
		 							  Class.forName("com.mysql.cj.jdbc.Driver");
		 							  Connection con9=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		 							  PreparedStatement pstmt9=con9.prepareStatement("select * from book_record1 where id=?");
		 							  pstmt9.setInt(1, getId());
		 							  
		 							  ResultSet rs9=pstmt9.executeQuery();
		 							  System.out.println("id\tbookId\tissueDate\treturnDate\tdueDate");
		 								while(rs9.next())
		 								{
		 									System.out.println(rs9.getInt(1)+"\t"+rs9.getInt(2)+"\t"+rs9.getString(3)+"\t"+rs9.getString(4)+"\t"+rs9.getString(5));
		 								}
		 								
		 								
		 								
		 							} catch (Exception e) {
		 							// TODO: handle exception
		 							e.printStackTrace();
		 						}
		 						break;
		 						
		 					case 0:
		 						System.exit(0);
		 	      		    }
		      		    }while(option!=0);
		      		   
	      		    }
	          
	        	}
	        
	        	
	        	
			} catch (Exception e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
	    	
	    }

	 
//==========================================REGISTRATION===========================================================================================
	 
	 public void Registration()
	    {
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	  		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	  		
	  	        PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?,?,?)");
	  	        System.out.println("Enter Id");
	  	        setId(sc.nextInt());
	  	        System.out.println("Enter First Name:");
	  	        String fname=sc.next();
	  	        System.out.println("Enter Last Name:");
		        String lname=sc.next();
		        System.out.println("Enter Branch:");
	  	        String branch=sc.next();
	  	        System.out.println("Enter Password:");
		        setPass(sc.next());
		        
		        pstmt.setInt(1, id);
		        pstmt.setString(2, fname);
		        pstmt.setString(3, lname);
		        pstmt.setString(4, branch);
		        pstmt.setString(5, pass);
		        
		        pstmt.executeUpdate();
		        
		        System.out.println("Registration Successfull....\n");
		        
	  	        
		    } catch (Exception e) 
	    	{
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	 
    }	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

