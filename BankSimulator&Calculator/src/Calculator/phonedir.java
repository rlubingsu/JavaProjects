/*
 * Roberson Lubin
 
 */
package  newV12B;
import java.util.*;
import javax.swing.*;
/**
 * The purpose of this class is to simulate using a sort of real phonebook
 * that a user may encounter in the real world when doing applications etc.
 * The steps i took to achieving this program is by creating an object class userdata
 * userdata and creating a linkedlist named everyAata. The object class UserData will serve as the data type of
 * the linkedlist. The linkedlist will store every object that satisfies the parametized constructor defined in the UserData type class
 * I created methods to handle all of the necessary functions for this program that are displayed in the promopt. 
 * I used a while loop to keep looping until the users command is equal to q if it is not the user can keep on adding deleting and changing data
 * The algorithm i used in this class is to keep looping through everything until the desired value of the loop is met. 
 * @author roberson lubin
 *
 */
public class phonedir {
	public LinkedList<UserData> everyAata = new LinkedList<>();
	 static int choice;
	 public UserData newData = new UserData();
	 int recordLocation = 0;
	 
	 
	 
/**
 * I created an add method to  to add data to the linkedlist
 * all data is stored in an object and that object is then added to the linkedlist
 * No parameters are needed for this method being that it is type void. My algorithm for adding
 * the users data that is going into the phone book is by prompting the user for what they would like
 * to set the first name of the record. prompt for the last name and finally the phone number. I use in.nextLine()
 * to take any input the user might put with a space. I then remove spaces by removing them using regex and change it as I desire. After that
 * These inputs are store in an object of type UserData. the object is then passed to the 
 * placeuserdata method in order to order it by either first or last name and phone number
 *  The object of type userdata will then be added to the linkedlist
 * using the add method provided in the java library. After that the current record is then displayed
 */
	public  void add(){
	 UserData findCurrent = new UserData();
 
		//everyAata = new <UserData> LinkedList(); 
		Scanner in = new Scanner(System.in);
		//String decMaker = "";
		 
		String usersFName = "";
	   
		String fixFName = usersFName.replaceAll("^\\s+|\\s+$", "");
		String usersLName = " ";
		String fixLName = usersLName.replaceAll("^\\s+|\\s+$", "");
		
		String usersPhone = "";
		String usersAge = "";
		
	 
		 
		
		System.out.println("Enter first name ");
		usersFName = in.nextLine();  //the users data along with any spaces is taken
		fixFName = usersFName.replaceAll("\\s", ""); //spaces are removed using the replaceAll method using regex
		fixFName = usersFName.substring(0, 1).toUpperCase() + usersFName.substring(1);
		 
	 // This will only remove spaces in the first word
// This part of the code is designed to only take the first part of the name as the name of the person. 
		 
		System.out.println("Enter last name \n"); // prompt for last name
		usersLName = in.nextLine();
		usersLName = usersLName.replaceAll("\\s", ""); //spaces are removed by using regex
		fixLName = usersLName.substring(0,1).toUpperCase()+  usersLName.substring(1);  // im setting the first letter of every input to uppercase
		// as shown in the mock up in bholas example
		 

		 
		System.out.print("Enter phone number "); //prompt for phone number
		usersPhone = in.nextLine();
		String usersPhone1 = usersPhone.replaceAll("\\s", ""); //i remove all spaces
		
		String x = ""; 
	 
		//int u = 0;
		/*
		 * This for loop is made to determine if the string has dashes in the phone number
		 * if it has dashes they are removed and replaced with no spaces
		 * this is done to take care of mixed input 
		 */
		for(int po =0; po < usersPhone1.length();po++ ){
			if(usersPhone1.charAt(po)== '-'){
	    		x = usersPhone1.substring(0, po)+ "" +usersPhone1.substring(po+1, usersPhone1.length());
	    	}
			 
		}
		 /*
		  * This if/else statement is being used to determine what to do with the phone number string
		  * My algorithm is if the users input string is less than 3 it will then just make the phone number equal to
		  * what the user put. If it is greater than 3 and less than 6 one dash is placed and the rest of the string
		  * is appended. Last but not least if the users phone number is greater than 6 it will place dashes 
		  * at index 3 and 6.
		  */
			if(usersPhone1.length()<=3){
				x = usersPhone1;
			 
			}
			else if(usersPhone1.length()<6 && usersPhone1.length()>3){
				x = usersPhone1.substring(0,3)+"-" + usersPhone1.substring(3,usersPhone1.length()); // i break the string into two pieces after it reaches
				//certain size in order to put dashes
			}
			else if(usersPhone1.length()>=6){
			     x = usersPhone1.substring(0, 3)+ "-" + usersPhone1.substring(3,6 )+ "-" +usersPhone1.substring(6,usersPhone1.length());
		 
		}
	 			 //System.out.println(x);
		  
		 
		
		 UserData mta = new UserData(fixFName, fixLName, x); // object of type user
	     placeUserData(mta); // passing in my object to be sorted in the placeUserData method
	     everyAata.add(recordLocation, mta); // the object is added to the begginning of the list being that recordLocation is equal to 0
	     //System.out.println(everyAata.size()+ "S");
		
		 
		// everyAata.add( new UserData(fixFName,fixLName,x));
		 
		 displayCurrentRecord(); // the call to display current record to show the current record
		
		 
		//objId = new UserData(fixFName, fixLName, fixusersPhone, usersAge);

		 

		
	}
	/**
	 * This methods purpose is to sort the contents of the object into the linkedlist in order
	 * by either first or last name and phone number. The algorithm i used to do this is
	 * first i created strings to store the current objects first last name and phone number
	 * i then compare all of the objects data with other data in the linkedlist to determine where it is best to be placed
	 * by using a while loop. Im able to place the data at a location that corresponds with where it would be appropriate to add
	 * the object. I first oompare by last name using the compareto method to compare to strings. If two last names are equal then it will 
	 * compare first names and if those are equal then it will compare phone numbers. If all are equal then the recordlocation will be incremented
	 * @param placeTheData
	 */
	public void placeUserData(UserData placeTheData) {
		String recordLastName = placeTheData.getLName();
		String recordFirstName = placeTheData.getFName();
		String currentPhone = placeTheData.getPhone();

		/*
		 * If the size of the linked list is zero
		 * it will place the object in the list
		 */
        if (everyAata.size() == 0) {
            recordLocation = 0;
            
        }
/*
 * do add method for linkedlist in here 
 */
       /*
        * Im using for loops nested ifs in order to compare
        * every data item of each object
        */
        for (int i = 0; i < everyAata.size(); i++) {
            String compareLastName = everyAata.get(i).getLName();

            if (recordLastName.compareTo( compareLastName) < 0) {
                recordLocation = i;
                 
            } 
    //        else if (recordLastName.compareTo( compareLastName) > 0){
      //      	recordLocation = i;
                
        //    }
            else if(recordLastName.compareTo( compareLastName) == 0){
            	 for(int p =0; p < everyAata.size(); p++){
            		 String compareFirstName = everyAata.get(p).getFName();
            		 if(recordFirstName.compareTo(compareFirstName) <0){
            			 recordLocation = p;
            			   // it will break out of the loop if it finds a correct location to insert
            		 }
            		// else if(recordFirstName.compareTo(compareFirstName) > 0){
            			// recordLocation = p;
            			   
            	//	 }
            		 else if(recordFirstName.compareTo(compareFirstName) == 0){
            			 for(int b = 0; b < everyAata.size(); b++){
            				 String comparePhone = everyAata.get(b).getPhone();
            				 if(currentPhone.compareTo(comparePhone) < 0){
            					 recordLocation = b;
            				  
            				 }
            				// else if(currentPhone.compareTo(comparePhone) < 0){
            					// recordLocation = b;
            				 
            				// }
            				
            			 }
            		 }
            			 
            		
            	 }
            }
            else {
                recordLocation+=1; // if everything is equal then the next record location which is the same as the current location is set as currentrecord
            }
        }
}
	/**
	 * This methods purpose is to display the current record from the users input
	 * the current record serves to show what the user puts in and they have
	 * the choice to change the first name last name and phone number
	 * the way i went about achieving this method is by returning the object at record location
	 * by getting its first last name and phone number then displaying it using the println method
	 * provided in the java library
	 */
	public void displayCurrentRecord(){
		phonedir p = new phonedir();
		if(everyAata.size()==0){
			System.out.println("NO DATA IN PHONE BOOK");
			p.main(null);
			
		}
		System.out.println(" Current Record : \n" + " First Name : " + everyAata.get(recordLocation).getFName() + "\n Last Name: " + everyAata.get(recordLocation).getLName() 
				+ "\n Phone : " +  everyAata.get(recordLocation).getPhone());
		//myObject.displayAllOptions();
	}
	  
	/**
	 * The method deletecurrentrecord deletes the record at the current location
	 * objects are added towards the beginnging . index =0 . so by calling remove(recordlocation)
	 * will remove the the object at that location. If no objects are in the list it will display
	 * there are no records available
	 */
	public void deleteCurrentRecord(){
		//if(everyAata.size()== 0){
			//System.out.println("There is no Data ");
		//}
		
		//else{
			try{
				if(everyAata.size()==0){
					System.out.println("There are no records available");
				}
			everyAata.remove(recordLocation); // removing the record at index recordLocation
	
			JOptionPane.showMessageDialog(null, "The current record has been removed");
			}catch(Exception le){	System.out.println("There is no Data ");}
			
			displayCurrentRecord(); // calling the displaycurrentrecord to display the record at index recordlocation
		//}
		
	}
	/**
	 * The methods purpose is to provide a means by which the user can modify the current records
	 * data. Mainly the first name. If the person chooses f in from the commands available . They will be able to change
	 * the current records first name to what they desire. I then store the 
	 * the current last name first name and phone number in a different object
	 * then delete the current object of all its data from the linkedlist
	 * After they do that a new object is made and is passed to placedata
	 * to find the correct location to put this object. 
	 */
	public void changeFirstName(){
		Scanner in = new Scanner(System.in);
	try{
		if(everyAata.size()==0){
			System.out.println("There are no records available to change first name"); // prompt for user if there are no records available
		}
		//phonedir l = new phonedir();
		
		System.out.print("What would you like to change the current records first name to ?");
		 
		String changeCurrentFName = in.nextLine();
		changeCurrentFName = changeCurrentFName.replaceAll("\\s+", ""); // removing spaces using regex
		String fixChangeCurrentFName = changeCurrentFName.substring(0,1).toUpperCase() + changeCurrentFName.substring(1,changeCurrentFName.length());
		UserData replacementData = new UserData(); // the replacement object for the data at this location
		String cFname = everyAata.get(recordLocation).getFName(); 
		String lName = everyAata.get(recordLocation).getLName();
		String phone = everyAata.get(recordLocation).getPhone();
		replacementData = new UserData(fixChangeCurrentFName,lName,phone);
		//UserData swap = everyAata.get(recordLocation);
		everyAata.remove(everyAata.get(recordLocation));
		// swap.setFname(fixChangeCurrentFName);
		 placeUserData(replacementData); // calling replaceuser data
		 everyAata.add(recordLocation, replacementData);
         displayCurrentRecord();
		}catch(Exception no){System.out.println("There is no current record  to change first name\n please enter data by selecting n");}
	}
	/**
	 * The methods purpose is to provide a means by which the user can modify the current records
	 * data. Mainly the last name. If the person chooses f in from the commands available . They will be able to change
	 * the current records first name to what they desire. I then store the 
	 * the current last name first name and phone number in a different object
	 * then delete the current object of all its data from the linkedlist
	 * After they do that a new object is made and is passed to placedata
	 * to find the correct location to put this object.  
	 */
	public void changeLastName(){
		Scanner in = new Scanner(System.in);
		try{
			if(everyAata.size()==0){
				System.out.println("There are no records available");
				displayAllOptions();
			}
		//phonedir l = new phonedir();
		
		System.out.print("What would you like to change the current records last name to ?");
		 
		String changeCurrentLName = in.nextLine();
		changeCurrentLName = changeCurrentLName.replaceAll("\\s+", "");
		String fixChangeCurrentLName = changeCurrentLName.substring(0,1).toUpperCase() + changeCurrentLName.substring(1,changeCurrentLName.length());
		String cFname = everyAata.get(recordLocation).getFName();
		String lName = everyAata.get(recordLocation).getLName();
		String phone = everyAata.get(recordLocation).getPhone();
		UserData replacementData = new UserData(cFname,changeCurrentLName,phone);
		//UserData swap = everyAata.get(recordLocation);
		everyAata.remove(recordLocation).getLName();
		// swap.setLname(fixChangeCurrentLName);
		 placeUserData(replacementData);
		 everyAata.add(replacementData);
		  displayCurrentRecord();
		}catch(Exception no){System.out.println("There is no current record  to change first name\n please enter data by selecting n");}
	}
	
	/**
	 * The methods purpose is to provide a means by which the user can modify the current records
	 * data. Mainly the phone number. If the person chooses f in from the commands available . They will be able to change
	 * the current records first name to what they desire. I then store the 
	 * the current last name first name and phone number in a different object
	 * then delete the current object of all its data from the linkedlist
	 * After they do that a new object is made and is passed to placedata
	 * to find the correct location to put this object. 
	 */
	public void changePhoneNumber(){
		Scanner in = new Scanner(System.in);
		int io =0;
		try{
		 
				if(everyAata.size()==0){
					System.out.println("There are no records available");
				}
			//phonedir l = new phonedir();
			
			System.out.print("What would you like to change the current records phone number to ?");
			String fixChangeCurrentPhone  ="";
			String changeCurrentPhone = in.nextLine();
			changeCurrentPhone = changeCurrentPhone.replaceAll("\\s+", "");
			do{
				if(changeCurrentPhone.charAt(io)== '-'){
		    		changeCurrentPhone = changeCurrentPhone.substring(0, io)+ "" +changeCurrentPhone.substring(io+1, changeCurrentPhone.length());
		    	}
				io++;
			}while(io < changeCurrentPhone.length());
			if(changeCurrentPhone.length()<=3){
				fixChangeCurrentPhone = changeCurrentPhone;
			 
			}
			else if(changeCurrentPhone.length()<6 && changeCurrentPhone.length()>3){
				fixChangeCurrentPhone = changeCurrentPhone.substring(0,3)+"-" + changeCurrentPhone.substring(3,changeCurrentPhone.length());
			}
			else if(changeCurrentPhone.length()>=6){
				fixChangeCurrentPhone = changeCurrentPhone.substring(0, 3)+ "-" + changeCurrentPhone.substring(3,6 )+ "-" +changeCurrentPhone.substring(6,changeCurrentPhone.length());
		 
		}
			//String fixChangeCurrentPhone = changeCurrentPhone.substring(0,3)+ "-" + changeCurrentPhone.substring(3,6)+ "-" + changeCurrentPhone.substring(6,changeCurrentPhone.length());
			String cFname = everyAata.get(recordLocation).getFName();
			String lName = everyAata.get(recordLocation).getLName();
			String phone = everyAata.get(recordLocation).getPhone();
			UserData replacementData = new UserData(cFname,lName,fixChangeCurrentPhone);
		//UserData swap = everyAata.get(recordLocation);
			everyAata.remove(recordLocation).getPhone();
			// swap.setPhone(fixChangeCurrentPhone);
			 placeUserData(replacementData);
		 

	         displayCurrentRecord();
			}catch(Exception no){System.out.println("There is no current record  to change first name\n please enter data by selecting n");}
		
		
	}
	
	/**
	 * The main method is where a program starts and without it we have a object class and not a driver class
	 * When the program is executed my name instructor and class will appear using the swing class
	 * an object will then be created that will then call the method that allows 
	 * all of the prompt to be displayed 
	 * @param args
	 */
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Name: Roberson Lubin \n Instructor: Bhola \n Class: CSC2720:86473");
		 phonedir object = new phonedir();
		 object.displayAllOptions();
		 

	} // ending brace for main method

	
     /**
      * The purpose of this method is to display the prompt to the user 
      * using a while loop. The while loops executes until the value is met
      * if it is not met the user is able to keep doing other things provided in the 
      * prompt. The user is able to display all data select data to become current  and more
      * My algorithm also double checks for the size of the data so that the user can not use the methods
      * change name etc since  there is no current data. Essentially the while loop loops until it receives the desired value it wants
      */
	public void displayAllOptions() {
	 phonedir p = new phonedir();
			Scanner in = new Scanner(System.in);
			String decMaker = "";
			try{
/*
 * Comparing if the user would enter a lower case or an uppercase letter for any commands
 */
			System.out.println("Welcome to the phone book  ");
			while (!(decMaker.equals("q") || (decMaker.equals("Q")))){

	 System.out.println("A Program to keep a Phone Directory. Choose from the following commands: \n enter a to show all records \n enter d to delete current record \n enter f to change "
				 		+ "first name in record \n enter l to change last name in record \n enter n to add new record \n enter p to change phone number \n enter s "
				 		+ " To select a record from the record list to become the current record \n enter c to display current record\n enter q to quit");

				decMaker = in.next();
				if (decMaker.equals("n") || decMaker.equals("N")) {
					add();

				}
				else if(decMaker.equals("A")||decMaker.equals("a")){
					if(everyAata.size()==0){
						System.out.println("NO DATA IN PHONE BOOK");
						p.main(null);
						
					}
					displayAllData();
				}
				else if(decMaker.equals("d")||decMaker.equals("D")){
					if(everyAata.size()==0){
						System.out.println("NO DATA IN PHONE BOOK");
						p.main(null);
						
					}
					deleteCurrentRecord();
				}
				else if(decMaker.equals("f")||decMaker.equals("F")){
					if(everyAata.size()==0){
						System.out.println("NO DATA IN PHONE BOOK");
						p.main(null);
						
					}
					changeFirstName();
				}
				else if(decMaker.equals("l")||decMaker.equals("L")){
					if(everyAata.size()==0){
						System.out.println("NO DATA IN PHONE BOOK");
						p.main(null);
						
					}
					changeLastName();
				}
				else if(decMaker.equals("p")||decMaker.equals("P")){
					if(everyAata.size()==0){
						System.out.println("NO DATA IN PHONE BOOK");
						p.main(null);
						
					}
					changePhoneNumber();
				}
				else if(decMaker.equals("s")||decMaker.equals("S")){
					
					if(everyAata.size()==0){
						System.out.println("NO DATA IN PHONE BOOK");
						p.main(null);
						
					}
					selectRecord();
					
				}
				else if(decMaker.equals("c")||decMaker.equals("C")){
					
					if(everyAata.size()==0){
						System.out.println("NO DATA IN PHONE BOOK");
						p.main(null);
						
					}
					displayCurrentRecord();
					
				}
				else if(decMaker.equals("q")||decMaker.equals("Q")){
					System.out.println("Program Terminated ");
				}
				else{
					System.out.println("Illegal Command!\nChoose from the available commands\n");
				}

			} 
			}catch(Exception e){}

		 

		
	}

	/*
	 * Displayalldata method will display all the data in the linkedlist that the user
	 * added to the linkedlist as objects. The algorithm i used is by using a while loop to loop until 
	 * it reaches the current size. When it does so it will retrieve first name last name and phone number
	 * for each object stored in the linkedlist
	 */
public   void displayAllData() {
	 
		 
		 
		int i =0;
		System.out.println("first name\t\t  " + " last name\t\t " + "phone\t\t ");
		while(i<everyAata.size()){
			System.out.println(everyAata.get(i).getFName()+ "\t\t\t " + everyAata.get(i).getLName() +"\t\t\t " + everyAata.get(i).getPhone());
			i++;
		}
		
	 
		 
		//try {
		//	System.out.println("First Name: " +"   " + "Last Name" + "    " + "  Phone Number");
		//	for (int l = 0; l <= everyAata.size(); l++) {

			//	System.out.print(everyAata.get(l));
		//	}
			/*
			//for(int ple = allData.getFName().length(); ple<25; ple++){
				System.out.print(" ");
			//}
				System.out.print("\t\t");
			
			for(int ped = 0; ped < pole.size(); ped++){
				System.out.print(allData.getLName());
			}
			
			//for(int ple = allData.getFName().length(); ple<25; ple++){
				System.out.print(" ");
			//}
			System.out.print("\t\t");
			for(int aPhones = 0; aPhones < pole.size(); aPhones++){
				System.out.println(allData.getPhone());
			}
			*/
			//System.out.println();
			

		//} catch (Exception data) {
			 
		//}

	}
	/*
	 *The purpose the selectRecord() method is to select a record from the givin records
	 *and make that record the current record. The algorithm i used to do this is to 
	 *take in all of the users input and compare it to the records displayed
	 *i then use a for loop to compare each and every location of first name last name and phone number with what they put in 
	 *if it equals = then it is set to where that record is as current record. How ever
	 *it it finds no match it will display no match in console
	 */
	private void selectRecord(){
		 
		try{
			Scanner in = new Scanner(System.in); 
			displayAllData();
			System.out.println("Enter the first name from the available records ");
			String setCurrentFName= in.nextLine();
			setCurrentFName = setCurrentFName.replaceAll("\\s+", "");
			String fixSetCurrentFName = setCurrentFName.substring(0,1).toUpperCase()+ setCurrentFName.substring(1,setCurrentFName.length());
			System.out.println("Enter the last name from the available records ");
			String setCurrentLName= in.nextLine();
			setCurrentLName = setCurrentLName.replaceAll("\\s+", "");
			String fixSetCurrentLName = setCurrentLName.substring(0,1).toUpperCase()+ setCurrentLName.substring(1,setCurrentLName.length());
			String usersPhone = "";
			
			 
				System.out.print("Enter phone number ");
				usersPhone = in.nextLine();
				//usersPhone = usersPhone.replaceAll("^\\s+|\\s+$", "");
				usersPhone = usersPhone.replaceAll("\\s+", "");
				 
				 
				 
				 String x ="";
				 // handling as many special characters that i can see on the keyboard
				 /**
				  * This for loop loops through the entire length of the string
				  * if anywhere in the string equals a dash or what not it will be removed
				  * and from there it will be appended
				  */
				 for(int po =0; po < usersPhone.length();po++ ){
						if(usersPhone.charAt(po)== '-'){
				    		x = usersPhone.substring(0, po)+ "" +usersPhone.substring(po+1, usersPhone.length());
				    	}
						 
					}
				  
				 
						if(usersPhone.length()<=3){
							x = usersPhone;
						 
						}
						else if(usersPhone.length()<6 && usersPhone.length()>3){
							x = usersPhone.substring(0,3)+"-" + usersPhone.substring(3,usersPhone.length());
						}
						else if(usersPhone.length()>=6){
						     x = usersPhone.substring(0, 3)+ "-" + usersPhone.substring(3,6 )+ "-" +usersPhone.substring(6,usersPhone.length());
					 
					}
				 
				 
				 UserData findCurrent = new UserData(fixSetCurrentFName,fixSetCurrentLName,x);
				 String current = findCurrent.getFName() + " " + findCurrent.getLName() + " " + findCurrent.getPhone();
				 String compareToCurrent = "";
				 int location;
				 int findIT = 0;
				 for(location =recordLocation; location < everyAata.size();location++ ){
					 
					 compareToCurrent = everyAata.get(location).getFName() + " " + everyAata.get(location).getLName() + " " 
					 + everyAata.get(location).getPhone();
					 
					 if(current.compareTo(compareToCurrent)>=0){
						 findIT = location;
						 recordLocation = location;
						 
					 }
					 else{
						 System.out.println("No Match");
					 }
					 
					
				 }
						 
		//System.out.println(" If it exist you will see 1 or greater if not 0 \n It is in " + findIT);
		
		displayCurrentRecord();
			
			
			
			
		}catch(Exception select){
			System.out.println("No current record available to select");
		}
	
	 
	}

}
