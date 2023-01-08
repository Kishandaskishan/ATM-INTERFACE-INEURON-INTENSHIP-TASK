import java.util.Scanner;

class InterfaceOfAtm{
	String name;
	String userName;
	String password;
	String accountNo;
	double balance=200000;
	int transactions=0;
	String transactionHistory="";

 
//User Registration
public void register() {
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter your Name:");
	this.userName=sc.nextLine();
	System.out.println("\nEnter the password :");
	this.password =sc.nextLine();
	System.out.println("\n Enter your account Number :");
	this.accountNo =sc.nextLine();
	System.out.println("\n Registation completed successfully ! kindly login to your Account.");
}
//user Login

public boolean login() {
	boolean islogin=false;
	Scanner sc = new Scanner(System.in);
	while (!islogin) {
		System.out.println("\n Enter your Username:");
		String username=sc.nextLine();
		if(username.equals(userName)) {
			while(!islogin) {
				System.out.println("\n Enter your Passsword:");
				String password=sc.nextLine();
				if(password.equals(password)) {
					System.out.println("\n login SucessFul");
					islogin=true;
				}else
					System.out.println("\n Incorrect password");
			}
			
		} else
			System.out.println("\n username not found");
	}
	return islogin;
	
	
}

// withdraw Money
public void withdraw() {
	System.out.println("\n Enter the amount to be withdraw:");
	Scanner sc =new  Scanner(System.in);
	double amount= sc.nextDouble();
	try {
		if(balance>=amount) {
			balance -=amount;
			System.out.println("\nwithdrwal successfull");
			String str="Rs"+amount+"withdrawn\n";
			transactionHistory= transactionHistory.concat(str);
			
		}else
			System.out.println("\n Insufficient Balance.");
	}catch(Exception e) {
   }
 }

//Deposit
public void deposit() {
	System.out.println("\n Enter amount to deposite:");
	Scanner sc =new Scanner(System.in);
	double amount =sc.nextDouble();
	try {
		if(amount<=100000.00) {
			transactions++;
			balance +=amount;
			System.out.println("\n Deposit sucessfull");
			String str="Rs"+ amount + "deposited\n";
			transactionHistory =transactionHistory.concat(str);
			
		}else
			System.out.println("\n limit Exceeded");
	}catch(Exception e) {
	
    }
}

//Transfer
public void transfer() {
	Scanner sc=new  Scanner(System.in);
	System.out.println("\n Enter recepient name:");
	String recepient=sc.nextLine();
	System.out.println("\n Enter amount to be transferrd :");
	double amount=sc.nextDouble();
	try {
		if(balance >= amount) {
			if(amount<=500000.00) {
				transactions++;
				balance-=amount;
				System.out.println("\n Sucessfully transferred to"+recepient);
				String str="Rs"+amount+"transfered to"+ recepient+ "\n";
				transactionHistory = transactionHistory.concat(str);
			}else
				System.out.println("\n sorry limit is 50000.00");
		}else
			System.out.println("\nInsufficient Balance.");
	}catch(Exception e) {
		
	}
}


// Check balance

public void checkBalance() {
	System.out.println("\nRs"+balance);
}

// transaction history


public void transHistory() {
	if(transactions == 0)
		System.out.println("\n Empty!");
	else
		System.out.println("\n" +transactionHistory); 
}
// Interface of ATM

public class AtmInterface { 
	public static int takeInput(int Int ) {
		int input=0;
		boolean flag = false;
		while(!flag) {
			try {
				Scanner sc =new Scanner(System.in);
				input =sc.nextInt();
				flag = true;
				if(flag && input > Int || input < 1) {
					System.out.println("select the number 1 to "+Int);
					flag = false;
				}
			}catch (Exception e) {
				System.out.println("Enter integer value only");
				flag=false;
			}
		} 
		return input;
	}
	
	// main method
	public static void main(String args[]) {
		 System.out.println("\n  Welcome to ICCI ATM  \n");
		 System.out.println("1.Register\n2.Exit");
		 System.out.println("Enter your choice : ");
		 int choice =takeInput(2);
		 if(choice==1) {
			 InterfaceOfAtm b= new InterfaceOfAtm();
			 b.register();
			 while(true) {
				 System.out.println("\n1.Login\n2.Exit");
				 System.out.println("Enter your choice");
				 int ch =takeInput(2);
				 if (ch==1){
					 if(b.login()) {
						 System.out.println("\n\nWELCOME BACK"+b.name+"\n\n");
						 boolean isFinished=false;
						 while(!isFinished) {
							 System.out.println(
									 "\n1.Deposit\n2.withdraw\n3.Transfer\n4.Transaction History\n5.check Balance");
							 System.out.println("Enter you choice:");
							 int c=takeInput(6);
							 switch(c) {
							 case 1:
								 b.deposit();
								 break;
							 case 2:
								 b.withdraw();
								 break;
							 case 3:
								 b.transfer();
								 break;
							 case 4:
								 b.transHistory(); 
							 case 5:
								 b.checkBalance();
							 case 6:
								 isFinished=true;
								 break;
								 default:
									 System.out.println("\nWrong Choice!");
						         }
						     }
						  } 
				 }else
				 System.exit(0);
			 }
		 }
	}
};
}




