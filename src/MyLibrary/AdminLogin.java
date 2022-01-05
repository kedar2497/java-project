package MyLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdminLogin {
	
	Scanner sc=new Scanner(System.in);
	private int id;
	private String pass;
	
	public void AdminLogin()
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
	
//===============================================LOGIN=========================================================================================	
	
	public void Login()
    {
    	System.out.println("Enter Id: ");
    	setId(sc.nextInt());
    	System.out.println("Enter Password: ");
    	setPass(sc.next());
    	
        try {
			
            Class.forName("com.mysql.cj.jdbc.Driver");
  		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
  		
  		    PreparedStatement pstmt=con.prepareStatement("select adminid from admin where adminid=?");//checking wrong id
  		    pstmt.setInt(1,getId());
  		   
  		    ResultSet rs=pstmt.executeQuery();
        	
        	if(!rs.next())
        	{
        		System.out.println("Register first... \n"); 
        	}
        	
        	else
        	{
        		PreparedStatement pstmt1=con.prepareStatement("select password from admin where adminid=? and password=?");//checking password
      		    pstmt1.setInt(1,getId());
      		    pstmt1.setString(2,getPass());
      		   
      		    ResultSet rs1=pstmt1.executeQuery();
      		    
      		    if(!rs1.next())
          	       {
          		      System.out.println("You have entered wrong password..... \n"); 
          	       }
      		    else
      		    {
      		    	System.out.println("Login Successfully.......\n");
      		    	Admin a=new Admin();
      				int option1;
      			
      				do{
      				
      				System.out.println("choose the opertaion you want to perform : ");
      				System.out.println("1.Add Book"+"\n2.Delete Book"+"\n3.update book"+"\n4.View Student History"+"\n0.logout");
      				option1=sc.nextInt();
      				switch(option1)
      				{
      				case 1:
      					a.AddBook();
      					break;
      					
      				case 2: 
      					a.DeleteBook();
      					break;
      					
      				case 3:
      					a.UpdateBook();
      					break;
      					
      				case 4:
      					a.StudentHistory();
      					break;
      					
      				case 0:
      				    System.exit(0);
      				    
      				}
      				}while(option1!=0);
      		    }
          
        	}
        
        	
        	
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
    	
    }
	
	
	
	
	
	
	
//==============================================REGISTRATION========================================================================================

	public void Registration()
	{
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
  		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
  		
  	        PreparedStatement pstmt=con.prepareStatement("insert into admin values(?,?)");
  	        System.out.println("Enter Id");
  	        setId(sc.nextInt());
  	        
  	        System.out.println("Enter Password:");
	        setPass(sc.next());
	        
	        pstmt.setInt(1, id);
	        pstmt.setString(2, pass);
	        
	        pstmt.executeUpdate();
	        
	        System.out.println("Registration Successfull....\n");
	        
  	        
	    } catch (Exception e) 
    	{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
