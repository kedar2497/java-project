package MyLibrary;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     Scanner sc=new Scanner(System.in);
		int option,option1,option2;
		
		do{
		System.out.println("WELCOME TO THE LIBRARY......!!!!!!!\n\n");
		
		System.out.println("I AM : "+"\n1.Admin"+"\n2.Student");
		option = sc.nextInt();
		
		switch(option)
		{
		
//======================================ADMIN===================================================================
		case 1: 
			System.out.println("****Welcome Admin****\n");
			AdminLogin al=new AdminLogin();
			do{
				System.out.println("Choose Operation :\n");
			    System.out.println("1.Register"+"\n2.Login"+"\n0.Logout");
				option2=sc.nextInt();
				
				switch(option2)
				{
				case 1:
				    al.Registration();
					break;
					
				case 2:
					al.Login();
					break;
		
				case 0:
					System.exit(0);
				}
				
				
			}while(option2!=0);
			break;

			
			
//==============================STUDENT===============================================================================================		
		case 2:
			System.out.println("****Welcome Student****\n");
			
			StudentLogin sl=new StudentLogin();
			do{
				System.out.println("Choose Operation :\n");
			    System.out.println("1.Register"+"\n2.Login"+"\n0.Logout");
				option2=sc.nextInt();
				
				switch(option2)
				{
				case 1:
				    sl.Registration();
					break;
					
				case 2:
					sl.Login();
					break;
		
				case 0:
					System.exit(0);
				}
				
				
			}while(option2!=0);
			break;
			
		   }
		
	}while(option!=0);

}
}
