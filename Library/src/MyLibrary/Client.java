package MyLibrary;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     Scanner sc=new Scanner(System.in);
		int option,option1,option2;
		
		do{
		System.out.println("WELCOME TO THE LIBRARY......!!!!!!!\n\n");
		
		System.out.println("I AM : \n"+"\n1.Admin"+"\n2.Student");
		option = sc.nextInt();
		
		switch(option)
		{
		
//======================================ADMIN===================================================================
		case 1: 
			System.out.println("welcome to the admin page....\n");
			Admin a=new Admin();
			
			//System.out.println("Please login.....\n");
			//System.out.println("Enter Id : \n");
			//int id=sc.nextInt();
			//System.out.println("Enter Password : \n");
			//String pass=sc.next();
			//a.Login();
			
			do{
			
			System.out.println("choose the opertaion you want to perform :\n");
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
				System.out.println("Student History\n");
				break;
				
			case 0:
			    System.exit(0);
			    
			}
			}while(option1!=0);
			break;

			
			
//==============================STUDENT===============================================================================================		
		case 2:
			System.out.println("welcome to the student page....\n");
			Student s=new Student();
			do{
				System.out.println("Choose Operation :\n");
				System.out.println("1.Search Book"+"\n2.Issue Book"+"\n3.Return Book"+"\n4.View History"+"\n5.Log Out");
				option2=sc.nextInt();
				
				switch(option2)
				{
				case 1:
					s.SearchBook();
					System.out.println("Operation Successfull....\n");
					break;
					
				case 2:
					s.IssueBook();
					System.out.println("Book Issued Successfully...."+"\nplease return it within time...\n");
					break;
					
				case 3:
					s.ReturnBook();
					System.out.println("Book Returned Successfully.....\n");
					break;
					
				case 4:
					s.ViewHistory();
					System.out.println("History shown Successfully....\n");
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
