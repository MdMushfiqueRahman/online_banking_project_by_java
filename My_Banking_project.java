package all_java_projects;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
public class My_Banking_project {
	
	static final String ANSI_RESET= "\u001b[0m";
	static final String ANSI_RED="\u001B[31m";
	static final String ANSI_GREEN="\u001B[32m";
	static final String ANSI_YELLOW="\u001B[33m";
	static final String ANSI_BLUE="\u001B[34m";
	static final String ANSI_PURPLE="\u001B[35m"; 
	 static final String ANSI_SKYBLUE = "\u001B[96m";
	 static final String ANSI_ORANGE = "\u001B[93m";
	 static final String ANSI_CYAN = "\u001B[36m";
	 static final String ANSI_LBLUE = "\u001B[94m"; // Light Blue
	
	static double UserBalance=00.00; //account opening deposit=$00 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println(ANSI_YELLOW+"Enter Your First Name: "+ANSI_RESET);//user's Details
		String name1= input.nextLine();
		System.out.println(ANSI_YELLOW+"Enter Your Last Name: "+ANSI_RESET);//user's Details
		String name2 = input.nextLine();
		
		System.out.println(ANSI_YELLOW+"Please Enter Your Account Number: "+ANSI_RESET);//user's account number
		int accnum= input.nextInt();
		
		System.out.println(ANSI_ORANGE+"Hi,"+name1+" "+name2+ "! Welcome to the First Bank!"+ANSI_RESET);//welcome message
		
		System.out.println(ANSI_YELLOW+"Press 1 For Main Menu"+ANSI_RESET);
		int press1= input.nextInt();
	
		if(press1 == 1) {
			display1();
		}else {
			System.out.println(ANSI_RED+"Invalid Press, PLease try again!"+ANSI_RESET);
		
		}
		
		System.out.println(ANSI_YELLOW+"Please Select Your Choice: "+ANSI_RESET);
		int option1= input.nextInt();
		
		switch(option1) {//for main menu options
		case 1:
			depositmenu();
			break;
		case 2: 
			withdrawmenu();
			break;
		case 3:
			transfermenu();
			break;
		case 4:
			balancemenu();
			break;
		case 5:
			exit();
			break;
		default:
			System.out.println(ANSI_RED+"Invalid Option."+ANSI_RESET);
			mainmenu();
		}
		
		
	 }
	public static void display1() {				//Main Display Menu
		System.out.println(ANSI_CYAN+"---Main Menu---");
		System.out.println("1.Deposit");
		System.out.println("2.Withdraw");
		System.out.println("3.Transfer");
		System.out.println("4.Balance");
		System.out.println("5.Exit"+ANSI_RESET);
		
	}
	public static void depositmenu() {		//Deposit Menu
		System.out.println(ANSI_LBLUE+"---Deposit---"+ANSI_RESET);
		System.out.println(ANSI_CYAN+"a.Check");
		System.out.println("b.Cash");
		System.out.println("c.Main Menu"+ANSI_RESET);
		System.out.println(ANSI_YELLOW+"Select your choice: (a,b,c)"+ANSI_RESET);
		
		Scanner input = new Scanner(System.in);
		 char  depositeSelection= input.next().charAt(0);
		 
		 switch(depositeSelection) {
		 case 'a':
			 System.out.println(ANSI_ORANGE+"You Selected Check Deposite Option!"+ANSI_RESET);
			System.out.println(ANSI_YELLOW+"Press 1 for continue!"+ANSI_RESET);
			 int check1= input.nextInt();
			 if (check1 == 1) {
				 checkmenu();						//declaring check menu
			 } else {
				 System.out.println(ANSI_RED+"Invalid Option!"+ANSI_RESET);
				 
				 mainmenu();
			 }
			 
			 break;
		 case 'b':
			 System.out.println(ANSI_ORANGE+"You Selected Cash Option"+ANSI_RESET);
			 System.out.println(ANSI_YELLOW+"Press 1 For Continue!"+ANSI_RESET);
			 int cash1= input.nextInt();
			 if (cash1 == 1) {
				 cashmenu();					//declaring cashmenu method
			 } else {
				 System.out.println(ANSI_RED+"Invalid Option."+ANSI_RESET);
			 }	 //ends if statements
		 break;
		 case'c':
				 mainmenu();	
		break;
		default:
			System.out.println(ANSI_RED+"Invalid Option."+ANSI_RESET);
			mainmenu();
			}
		
	}
	public static void checkmenu() {//check method
		Scanner input = new Scanner(System.in);
		
		
		System.out.println(ANSI_YELLOW+"Enter Your Check Number: "+ANSI_RESET);
		int checknumber= input.nextInt();
		System.out.println(ANSI_YELLOW+"Enter Your Amount: $"+ANSI_RESET);
		int checkamount= input.nextInt();
		//Confirmation
		System.out.println(ANSI_ORANGE+"Your Check Number: "+checknumber+ANSI_RESET);
		System.out.println(ANSI_ORANGE+"Your Deposit Amount: $"+checkamount+ANSI_RESET);
		System.out.println(ANSI_YELLOW+"Press 1 for Confirmation!"+ANSI_RESET);
		int con1= input.nextInt();
		if (con1==1) {
			UserBalance += checkamount;
			logTransaction("Deposit", checkamount); //using log method
			System.out.println(ANSI_GREEN+"Deposit successful, Thank you for using First Bank!"+ANSI_RESET);
			System.out.println(ANSI_YELLOW+"Enter 1 for Main Menu, Enter 2 for Exit"+ANSI_RESET); //last line 
			int end3= input.nextInt();
			switch(end3) {
			case 1:
				mainmenu();
				break;
			case 2:
				exit();
				break;
				default:
					System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
			}//switch statement for check deposit end
		}
	}
	public static void cashmenu() { //cashmenu method
		System.out.println(ANSI_CYAN+"Select Your Amount"+ANSI_RESET);
		System.out.println(ANSI_CYAN+"a. $100");
		System.out.println("b. $50");
		System.out.println("c. $10"+ANSI_RESET);
		
		Scanner input= new Scanner(System.in);
		char cashmenu1 = input.next().charAt(0);
		switch(cashmenu1) {
		case 'a':
			System.out.println(ANSI_ORANGE+"Your Deposit Amount: $100"+ANSI_RESET);
			System.out.println(ANSI_YELLOW+"Press 1 for Confirmation!"+ANSI_RESET);
			int con1= input.nextInt();
			if (con1==1) {
				UserBalance += 100;
				logTransaction("Deposit", 100); //using log file for check deposit
				System.out.println(ANSI_GREEN+"Your $100 has been successfully deposited!"+ANSI_RESET);
				System.out.println(ANSI_YELLOW+"Enter 1 for Main Menu, Enter 2 for Exit"+ANSI_RESET); //last line 
				int end3= input.nextInt();
				switch(end3) {
				case 1:
					mainmenu();
					break;
				case 2:
					exit();
					break;
					default:
						System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
				}//switch statement for check deposit end
			}else {
				System.out.println(ANSI_RED+"Invalid Choice!"+ANSI_RESET);
				mainmenu();
			}
		break;
		case 'b':
			System.out.println(ANSI_ORANGE+"Your Deposit Amount: $50"+ANSI_RESET);
			System.out.println(ANSI_YELLOW+"Press 1 for Confirmation!"+ANSI_RESET);
			int con2= input.nextInt();
			if (con2==1) {
				UserBalance += 50;
				logTransaction("Deposit", 50);
				System.out.println(ANSI_GREEN+"Your $50 has been successfully deposited!"+ANSI_RESET);
				System.out.println(ANSI_YELLOW+"Enter 1 for Main Menu, Enter 2 for Exit"+ANSI_RESET); //last line 
				int end3= input.nextInt();
				switch(end3) {
				case 1:
					mainmenu();
					break;
				case 2:
					exit();
					break;
					default:
						System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
				}//switch statement for check deposit end
			}else {
				System.out.println(ANSI_RED+"Invalid Choice!"+ANSI_RESET);
				mainmenu();
			}
		break;
		case 'c':
			System.out.println(ANSI_YELLOW+"Your Deposit Amount: $10"+ANSI_RESET);
			System.out.println(ANSI_YELLOW+"Press 1 for Confirmation!"+ANSI_YELLOW);
			int con3= input.nextInt();
			if (con3==1) {
				UserBalance += 10;
				logTransaction("Deposit", 10);
				System.out.println(ANSI_GREEN+"Your $10 has been successfully deposited!"+ANSI_RESET);
				System.out.println(ANSI_YELLOW+"Enter 1 for Main Menu, Enter 2 for Exit"+ANSI_RESET); //last line 
				int end3= input.nextInt();
				switch(end3) {
				case 1:
					mainmenu();
					break;
				case 2:
					exit();
					break;
					default:
						System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
				}//switch statement for check deposit end
			} else {
				System.out.println(ANSI_RED+"Invalid Choice!"+ANSI_RESET);
				mainmenu();
			}
		}
	}
	public static void withdrawmenu() {		//Withdraw Menu
		System.out.println(ANSI_CYAN+"---Withdraw---");
		System.out.println("a. $100");
		System.out.println("b. $50");
		System.out.println("c. $10");
		System.out.println("d. Main Menu"+ANSI_RESET);
		
		Scanner input = new Scanner(System.in);
		System.out.println(ANSI_YELLOW+"Select Your Option:"+ANSI_RESET);
		char withdrawOption= input.next().charAt(0);
		
		switch(withdrawOption) {
		case 'a':
			int withdrawamount1=100;
			if(UserBalance>=100) {
			System.out.println(ANSI_ORANGE+"Your Withdraw Amount: $100"+ANSI_RESET);
			System.out.println(ANSI_YELLOW+"Press 1 for Confirmation!"+ANSI_RESET);
			int con1= input.nextInt();
			if (con1==1) {
				UserBalance -= withdrawamount1;
				logTransaction("Withdraw", 100);
				System.out.println(ANSI_GREEN+"Your $100 has been successfully withdrawn!"+ANSI_RESET);
				System.out.println(ANSI_YELLOW+"Enter 1 for Main Menu, Enter 2 for Exit"+ANSI_RESET); //last line 
				int end3= input.nextInt();
				switch(end3) {
				case 1:
					mainmenu();
					break;
				case 2:
					exit();
					break;
					default:
						System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
				}//switch statement for check deposit end
			}else {
				System.out.println(ANSI_RED+"Invalid Choice!"+ANSI_RESET);
				mainmenu();
			} 
			}else {
				System.out.println(ANSI_RED+"Sorry, Withdraw failed due to insufficient balance!"+ANSI_RESET);
				System.out.println(ANSI_ORANGE+"Your Current Balance is: $"+UserBalance+ANSI_RESET);
				mainmenu();
			} 
				
		break;
		case 'b':
			int withdrawamount2=50;
			if(UserBalance>=withdrawamount2) {
			System.out.println(ANSI_ORANGE+"Your withdraw Amount: $50"+ANSI_RESET);
			System.out.println(ANSI_YELLOW+"Press 1 for Confirmation!"+ANSI_RESET);
			int con2= input.nextInt();
			if (con2==1) {
				UserBalance -= 50;
				logTransaction("Withdraw", 50);
				System.out.println(ANSI_GREEN+"Your $50 has been successfully deposited!"+ANSI_RESET);
				System.out.println(ANSI_YELLOW+"Enter 1 for Main Menu, Enter 2 for Exit"+ANSI_RESET); //last line 
				int end3= input.nextInt();
				switch(end3) {
				case 1:
					mainmenu();
					break;
				case 2:
					exit();
					break;
					default:
						System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
				}//switch statement for check deposit end
			}else {
				System.out.println(ANSI_RED+"Invalid Choice!"+ANSI_RESET);
				mainmenu();
			}
			}else{ 
				System.out.println(ANSI_RED+"Sorry, Withdraw failed due to insufficient Balance!"+ANSI_RESET);
				System.out.println(ANSI_ORANGE+"Your current Balance is: $"+UserBalance+ANSI_RESET);
				mainmenu();
			}
		break;
		case 'c':
			int amount3=10;
			if(UserBalance>=amount3) {
			System.out.println(ANSI_ORANGE+"Your Withdraw Amount: $10"+ANSI_RESET);
			System.out.println(ANSI_YELLOW+"Press 1 for Confirmation!"+ANSI_RESET);
			int con3= input.nextInt();
			if (con3==1) {
				UserBalance -= 10;
				logTransaction("Withdraw", 10);
				System.out.println(ANSI_GREEN+"Your $10 has been successfully wIthdrawn!"+ANSI_RESET);
				System.out.println(ANSI_YELLOW+"Enter 1 for Main Menu, Enter 2 for Exit"+ANSI_RESET); //last line 
				int end3= input.nextInt();
				switch(end3) {
				case 1:
					mainmenu();
					break;
				case 2:
					exit();
					break;
					default:
						System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
				}//switch statement for check deposit end
			}else {
				System.out.println(ANSI_RED+"Invalid Choice!"+ANSI_RESET);
				mainmenu();
			}}else {
				System.out.println(ANSI_RED+"Sorry, Withdraw failed due to insufficient balance!"+ANSI_RESET);
				System.out.println(ANSI_ORANGE+"Your Current Balance is: $"+UserBalance+ANSI_RESET);
				mainmenu();
			} 
			break;
		case 'd':
			mainmenu();
			default:
				System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
			
		}//switch statement for withdraw option ends here.	
	}
	public static void transfermenu() {		//Transfer Menu
		System.out.println(ANSI_CYAN+"---Transfer---");
		System.out.println("a.Same Bank");
		System.out.println("b.Different Bank");
		System.out.println("c.Main Menu"+ANSI_RESET);
		
		Scanner input = new Scanner(System.in);
		System.out.println(ANSI_YELLOW+"Select Your Choice: "+ANSI_RESET);
		char transferOption = input.next().charAt(0);
		switch(transferOption) {
		case 'a':
			samebank();
			break;
		case 'b':
			differentbank();
			break;
		case 'c':
			System.out.println("c. Main Menu");
			mainmenu();
			break;
		default:
			System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
		}
		
	}
	public static void samebank() { //same bank method
		Scanner input = new Scanner(System.in);
		
		System.out.println(ANSI_YELLOW+"Enter recipient's account number: "+ANSI_RESET);
		int accountnumber= input.nextInt();
		System.out.println(ANSI_YELLOW+"Enter your amount:"+ANSI_RESET);
		int transferSBamount= input.nextInt();
		if(UserBalance>=transferSBamount) {
		System.out.println(ANSI_ORANGE+"Recipient's Account Number: "+accountnumber);
		System.out.println("Transfer Amount: $"+transferSBamount+ANSI_RESET);
		System.out.println(ANSI_YELLOW+"Press 1 for Confirmation!"+ANSI_RESET);
		int con1= input.nextInt();
		if (con1==1) {
			UserBalance -= transferSBamount;
			logTransaction("Transfer (Same Bank)", transferSBamount);
			System.out.println(ANSI_GREEN+"Transfer successful, Thank you for using First Bank!"+ANSI_RESET);
			System.out.println(ANSI_YELLOW+"Enter 1 for Main Menu, Enter 2 for Exit"+ANSI_RESET); //last line 
			int end3= input.nextInt();
			switch(end3) {
			case 1:
				mainmenu();
				break;
			case 2:
				exit();
				break;
				default:
					System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
			}//switch statement for same bank end
			
		}else {
			System.out.println(ANSI_RED+"Transfer failed!"+ANSI_RESET);
			mainmenu();
		}}else {
			System.out.println(ANSI_RED+"Sorry, Transfer failed due to insufficient balance!"+ANSI_RESET);
			System.out.println(ANSI_ORANGE+"Your Current Balance is: $"+UserBalance+ANSI_RESET);
			mainmenu();
		} 
	}
	public static void differentbank() {
				Scanner input = new Scanner(System.in);
				
				System.out.println(ANSI_YELLOW+"Please write the bank's name: "+ANSI_RESET);
				String bankname= input.nextLine();
				System.out.println(ANSI_YELLOW+"Write the recipient's Account/Routing number: "+ANSI_RESET);
				int details= input.nextInt();
				System.out.println(ANSI_YELLOW+"Transfer Amount: $"+ANSI_RESET);
				int transferamount1=input.nextInt();
				if(UserBalance>=transferamount1) {
				System.out.println(ANSI_ORANGE+"Recipient's Bank Name: "+bankname);
				System.out.println("Recipient's Account Number: "+details);
				System.out.println("Transfer Amount: $"+transferamount1+ANSI_RESET);
				System.out.println(ANSI_YELLOW+"Press 1 for Confirmation!"+ANSI_RESET);
				int con1= input.nextInt();
				if (con1==1) {
					UserBalance -= transferamount1;
					logTransaction("Transfer (Different Bank)", transferamount1);
					System.out.println(ANSI_GREEN+"Transfer successful, Thank you for using First Bank!"+ANSI_RESET);
					System.out.println(ANSI_YELLOW+"Enter 1 for Main Menu, Enter 2 for Exit"+ANSI_RESET); //last line 
					int end3= input.nextInt();
					switch(end3) {
					case 1:
						mainmenu();
						break;
					case 2:
						exit();
						break;
						default:
							System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
					}//switch statement for different bank end
					
				}else {
					System.out.println(ANSI_RED+"Transfer failed, Returing To The Main Menu!"+ANSI_RESET);
					mainmenu();
				}}else {
					System.out.println(ANSI_RED+"Sorry, Transfer failed due to insufficient balance!"+ANSI_RESET);
					System.out.println(ANSI_ORANGE+"Your Current Balance is: $"+UserBalance+ANSI_RESET);
					mainmenu();
				} 
			}//different bank method end here
				
	
	public static void exit() {
		System.out.println(ANSI_PURPLE+"Thank you for using First bank. Have a great Day!!"+ANSI_RESET);
		System.exit(0);
	}
	
	public static void balancemenu() {//balance menu
		System.out.println(ANSI_CYAN+"---Balance---");
		System.out.println("a. Check Your Balance");
		System.out.println("b. Main Menu"+ANSI_RESET);
	
		Scanner input = new Scanner(System.in);
		System.out.println(ANSI_YELLOW+"Select Your Option!"+ANSI_RESET);
		char select3= input.next().charAt(0);
		switch(select3) {
		case 'a':
			System.out.println(ANSI_ORANGE+"Your Current Account Balance is: $"+UserBalance+ANSI_RESET); 
			System.out.println(ANSI_YELLOW+"Enter 1 for Main Menu, Enter 2 for Exit"+ANSI_RESET); //last line 
			int end4= input.nextInt();
			switch(end4) {
			case 1:
				mainmenu();
				break;
			case 2:
				exit();
				break;
				default:
					System.out.println(ANSI_RED+"Invalid Choice"+ANSI_RESET);
			}//switch statement for same bank end
		break;
		case 'b':
			mainmenu();
			break;
			default:
				System.out.println(ANSI_RED+"Invalid Option!"+ANSI_RESET);
		}
		
	}
	
	//method to log transactions
	 public static void logTransaction(String transactionType, double amount) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String timestamp = dateFormat.format(new Date());
	        String logEntry = timestamp + " - " + transactionType + ": $" + amount + ", Balance: $" + UserBalance;

	        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
	            writer.println(logEntry);
	        } catch (IOException e) {
	            System.out.println("Error writing to log file: " + e.getMessage());
	        }
	    }//method for log trans end here
	
	public static void mainmenu() { //Return to the main menu method
		System.out.println(ANSI_PURPLE+"Returning to the Main Menu!"+ANSI_RESET);
		display1();
		Scanner input= new Scanner(System.in);
		System.out.println(ANSI_YELLOW+"Please Select Your Choice: "+ANSI_RESET);
		int option2= input.nextInt();
		
		switch(option2) {//for main menu options
		case 1:
			depositmenu();
			break;
		case 2: 
			withdrawmenu();
			break;
		case 3:
			transfermenu();
			break;
		case 4:
			balancemenu();
			break;
		case 5:
			exit();
			break;
		default:
			System.out.println(ANSI_RED+"Invalid Option."+ANSI_RESET);
		}
		
	}
	
}
