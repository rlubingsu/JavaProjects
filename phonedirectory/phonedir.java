
import java.util.*;
import java.io.*;
import java.io.ObjectOutputStream.PutField;

import javax.swing.*;

 

public class phonedir {
	private int numOfData = 0;
	public static phonedir phonedirObject = new phonedir();
	public Scanner in = new Scanner(System.in);
	
	LinkedList<AllData> AllDatas = new LinkedList<AllData>();
	private void changeTheFirstName() {
		AllData newName = new AllData();
		boolean y = false;
		while(!y){
		if (AllDatas.size()==0){
	           System.out.println("There are no records in the phone directory. Add records to the phone directory. Press n");
	           y = true;
	           showAvailableCommands();
	           break;
	         }
		else{
			y = true;
		}
		}
		System.out.println("Put first name");
		String replaceFirstName = in.nextLine();
		replaceFirstName = (replaceFirstName.substring(0,1).toUpperCase() + replaceFirstName.substring(1,replaceFirstName.length())).replaceAll("\\s", "");
		
		AllData o = new AllData();
		String i = AllDatas.get(numOfData).getFirst();
		String l = AllDatas.get(numOfData).getLast();
		String p = AllDatas.get(numOfData).getDigits();
		o = new AllData(replaceFirstName,l,p);
		//newName = AllDatas.get(numOfData);
		 AllDatas.remove(AllDatas.get(numOfData));
		// newName.setFirstName(replaceFirstName);
		 sortByLastName(o);
		 AllDatas.add(numOfData, o);
		showTheCurrentRecord();
		
	}
	
	private void selectTheCurrentRecord(){
		AllData myData = new AllData();
		String putFirstName = "";
		String putLastName ="";
		String putDigits ="";
		boolean y = false;
		while(!y){
		if (AllDatas.size()==0){
	           System.out.println("There are no records in the phone directory. Add records to the phone directory. Press n");
	           y = true;
	           showAvailableCommands();
	           break;
	         }else{
	        	 y = true;
	         }
		 showAllRecords();
		 System.out.println("What record would you like to make current ?");
		 System.out.println("Put first name");
		  putFirstName =in.nextLine().replaceAll("\\s","");
		  System.out.println(putFirstName);
		 System.out.println("Put last name");
		 putLastName =in.nextLine().replaceAll("\\s","");
		 System.out.println("Put phone number");
		  putDigits =in.nextLine().replaceAll("\\s","");
			int pop =0;
		    while(pop < putDigits.length()){
		    	if(putDigits.charAt(pop)== '-'){
		    		putDigits = putDigits.substring(0, pop)+ "" +putDigits.substring(pop+1, putDigits.length());
		    	}
		    	pop++;
		    }
			if(putDigits.length()<=3){
				putDigits = putDigits;
			 }
			else if(putDigits.length()<6 && putDigits.length()>3){
				putDigits = putDigits.substring(0,3)+"-" + putDigits.substring(3,putDigits.length());
			}
			else if(putDigits.length()>=6){
				putDigits = putDigits.substring(0, 3)+ "-" + putDigits.substring(3,6 )+ "-" +putDigits.substring(6,putDigits.length());
		}
		}
		 
		myData = new AllData(putFirstName, putLastName, putDigits);
		String firstNameAtNumOfData = myData.getFirst();
		String lastNameAtNumOfData = myData.getLast();
		String digitsAtNumOfData = myData.getDigits();
		
		int n = numOfData;
		 
		 AllData findCurrent = new AllData(firstNameAtNumOfData,lastNameAtNumOfData,digitsAtNumOfData);
		 String current = findCurrent.getFirst() + " " + findCurrent.getLast() + " " + findCurrent.getDigits();
		 String compareToCurrent = "";
		 int location;
		 int findIT = 0;
		 for(location =numOfData; location < AllDatas.size();location++ ){
			 
			 compareToCurrent = AllDatas.get(location).getFirst() + " " + AllDatas.get(location).getLast() + " " 
			 + AllDatas.get(location).getDigits();
			 
			 if(current.compareTo(compareToCurrent)<=0){
				 findIT = location;
				 numOfData = location;
				 
			 }
			 else{
				 System.out.println("No Match");
			 }
			 
			
		 }
		 showTheCurrentRecord();
		 }
		 
	
	

	private void addANewRecord() {

		System.out.print("Put first Name:");
		String firstName = in.nextLine();
		firstName = (firstName.substring(0, 1).toUpperCase() + firstName.substring(1, firstName.length())).replaceAll("\\s", "");
		System.out.println();
		System.out.println("Put Last Name");
		String lastName = in.nextLine();
		lastName = (lastName.substring(0, 1).toUpperCase() + lastName.substring(1, lastName.length())).replaceAll("\\s", "");
		System.out.println("Enter Phone Number");
		String pDigits = in.nextLine();
		pDigits = pDigits.replaceAll("\\s", "");
		System.out.println();
		int pop =0;
	    while(pop < pDigits.length()){
	    	if(pDigits.charAt(pop)== '-'){
	    		pDigits = pDigits.substring(0, pop)+ "" +pDigits.substring(pop+1, pDigits.length());
	    	}
	    	pop++;
	    }
		if(pDigits.length()<=3){
			pDigits = pDigits;
		 }
		else if(pDigits.length()<6 && pDigits.length()>3){
			pDigits = pDigits.substring(0,3)+"-" + pDigits.substring(3,pDigits.length());
		}
		else if(pDigits.length()>=6){
			pDigits = pDigits.substring(0, 3)+ "-" + pDigits.substring(3,6 )+ "-" +pDigits.substring(6,pDigits.length());
	}
		 
		AllData object = new AllData(firstName,lastName,pDigits);
		sortByLastName(object);
		AllDatas.add(numOfData, object);
		showTheCurrentRecord();

	}

	private void sortByLastName(AllData lObject) {
		AllData myObject = lObject;
		int destination = 0;
		String currentl = myObject.getLast();
		 
		
		String destionationL = "";
        if (AllDatas.size()==0){
            numOfData=0;
         }
        while(destination<AllDatas.size()){
           destionationL = AllDatas.get(destination).getLast();

            if (currentl.compareTo(destionationL)<0) {
               numOfData = destination;
           }else if(currentl.compareTo(destionationL) ==0){
            	sortByFirstName(myObject);
            }
            destination++;
        }	
	}
	
	private void sortByFirstName(AllData Fobject) {
		AllData myObject = Fobject;
		String firstName = myObject.getFirst();
		String iFirstName = "  ";
		 if (AllDatas.size()==0){
	            numOfData=0;
	       }
		 int z=0;
		 while (z<AllDatas.size()){
	              iFirstName = AllDatas.get(z).getFirst();
	             if (firstName.compareTo(iFirstName)<0) {
	               numOfData = z;
	            }else if(firstName.compareTo(iFirstName)==0){
	            	sortByDigits(myObject);
	            }
	            z++;
	        }
	}

	private void sortByDigits(AllData pObject) {
		AllData phObject = pObject;
		String uDigit = phObject.getDigits();
		 if (AllDatas.size()==0){
	            numOfData=0;
	    }
		 int k = 0;
		 while(k<AllDatas.size()){
	            String iDigit = AllDatas.get(k).getDigits();
	             if (uDigit.compareTo(iDigit) < 0) {
	               numOfData = k;
	               
	            }else if(uDigit.compareTo( iDigit) ==0){
	            	numOfData = numOfData + 1;
	            } k++;
	        }
		 
	}
	public static void main(String[] args) {
		 
		phonedir objectOfClass = new phonedir();
		objectOfClass.showAvailableCommands();
		/*
	   Scanner input = new Scanner(System.in);
		String chooseOperation = "";
		while (!(chooseOperation.equals("Q"))){
				chooseOperation = input.next().toUpperCase();
				if (chooseOperation.equals("N")) {
					objectOfClass.addANewRecord();

				}else if (chooseOperation.equals("A")) {

				} else if (chooseOperation.equals("Q")) {

				} else {
					System.out.println("Invalid input");
				}

		}  
		*/

	}
	
	private void changeTheLastName(){
		AllData newLastName = new AllData();
		boolean y = false;
		while(!y){
		if (AllDatas.size()==0){
	           System.out.println("There are no records in the phone directory. Add records to the phone directory. Add"
	           		+ " more data by press n");
	           y = true;
	           showAvailableCommands();
	           break;
	         }
		else{
			y = true;
		}
		}
		System.out.println("Put last name");
		String replaceLastName = in.nextLine();
		replaceLastName = (replaceLastName.substring(0,1).toUpperCase() + replaceLastName.substring(1,replaceLastName.length())).replaceAll("\\s", "");
		AllData o = new AllData();
		String i = AllDatas.get(numOfData).getFirst();
		String l = AllDatas.get(numOfData).getLast();
		String p = AllDatas.get(numOfData).getDigits();
		o = new AllData(i,replaceLastName,p);
		//newLastName = AllDatas.get(numOfData);
		 AllDatas.remove(AllDatas.get(numOfData));
		// newLastName.setLastName(replaceLastName);
		 sortByLastName(o);
		 AllDatas.add(numOfData, o);
		 //AllDatas.add(numOfData, newLastName);
		showTheCurrentRecord();
		
	}
	private void changeTheDigits(){
		AllData newDigits = new AllData();
		boolean y = false;
		while(!y){
		if (AllDatas.size()==0){
	           System.out.println("There are no records in the phone directory. Add records to the phone directory. Press n");
	           y = true;
	           showAvailableCommands();
	           break;
	         }
		else{
			y = true;
		}
		}
		System.out.println("Put new phone number");
		String replaceDigits=in.nextLine();
		replaceDigits=replaceDigits.replaceAll("\\s", "");
	    int pop =0;
	    while(pop < replaceDigits.length()){
	    	if(replaceDigits.charAt(pop)== '-'){
	    		replaceDigits = replaceDigits.substring(0, pop)+ "" +replaceDigits.substring(pop+1, replaceDigits.length());
	    	}
	    	pop++;
	    }
	    if(replaceDigits.length()<=3){
			replaceDigits = replaceDigits;
		 }
		else if(replaceDigits.length()<6 && replaceDigits.length()>3){
			replaceDigits = replaceDigits.substring(0,3)+"-" + replaceDigits.substring(3,replaceDigits.length());
		}
		else if(replaceDigits.length()>=6){
			replaceDigits = replaceDigits.substring(0, 3)+ "-" + replaceDigits.substring(3,6)+ "-" +replaceDigits.substring(6,replaceDigits.length());
	}  
	    
		AllData o = new AllData();
		String i = AllDatas.get(numOfData).getFirst();
		String l = AllDatas.get(numOfData).getLast();
		String p = AllDatas.get(numOfData).getDigits();
		o = new AllData(i,l,replaceDigits);
		//newDigits = AllDatas.get(numOfData);
		 AllDatas.remove(AllDatas.get(numOfData));
		// newDigits.setDigits(replaceDigits);
		 sortByLastName(o);
		 AllDatas.add(numOfData,o);
		 //AllDatas.add(numOfData, newDigits);
		showTheCurrentRecord();
		
	}

	public void showAllRecords(){
		boolean y = false;
		while(!y){
		if (AllDatas.size()<=0){
	           System.out.println("There are no records in the phone directory. Add records to the phone directory. Press n");
	           y = true;
	           showAvailableCommands();
	           break;
	         }
		else{
			y = true;
		}
		}
					AllData o = new AllData();
				 	System.out.println("First Name: " +"   " + "Last Name" + "    " + "  Phone Number");
				 	int k = 0;
				 	while(k<AllDatas.size()){
				 		System.out.print(AllDatas.get(k).getFirst()+"             ");
				 		System.out.print(AllDatas.get(k).getLast()+"               ");
				 		System.out.print(AllDatas.get(k).getDigits());
				 		System.out.println();
				 		k++;
				 	}
	}
	
	public void deleteTheCurrentRecord(){
		boolean y = false;
		while(!y){
		if (AllDatas.size()<=0){
	           System.out.println("There are no records in the phone directory. Add records to the phone directory. Press n");
	           y = true;
	           showAvailableCommands();
	           break;
	         }
		else{
			y = true;
		}
		}
		
		AllDatas.remove(numOfData);
		System.out.println("Current record deleted ");
		showTheCurrentRecord();
		
	}
	public void showTheCurrentRecord(){
		boolean y = false;
		while(!y){
		if (AllDatas.size()==0){
	           System.out.println("There are no records in the phone directory. Add records to the phone directory. Press n");
	           y = true;
	           showAvailableCommands();
	           break;
	         }
		else{
			y = true;
		}
		}
		AllData dirData = new AllData();
		System.out.println("The Current Record is:");
		System.out.println("First Name:" + AllDatas.get(numOfData).getFirst());
		System.out.println("Last Name:" + AllDatas.get(numOfData).getLast());
		System.out.println("Phone Number:" + AllDatas.get(numOfData).getDigits());
	}
	private void displayMessage(){
		System.out.println("A Program to keep a Phone Directory:");
		System.out.println("a: to Show All Records ");
		System.out.println("f: to Change the first name in the current record");
		System.out.println("l: to Change the last name in the current record");
		System.out.println("n: to Add a new record");
		System.out.println("d: Delete the current record");
		System.out.println("p: to Change the phone number in the current record");
		System.out.println("s: to Select a record from the record list to become the current record");
		System.out.println("q: to Quit");
	}

	private void showAvailableCommands() {
	 
		Scanner input = new Scanner(System.in);
		 
		String chooseOperation="  ";
		
		while (!(chooseOperation.equals("Q"))){
				displayMessage();
				chooseOperation = input.next().toUpperCase();
				if (chooseOperation.equals("A")) {
					showAllRecords();  

				}else if (chooseOperation.equals("F")){
				 changeTheFirstName();
					
				}else if (chooseOperation.equals("Q")){
					 
				} else if (chooseOperation.equals("N")){
					 addANewRecord();
				}else if (chooseOperation.equals("L")){
					changeTheLastName();
					 
				}else if (chooseOperation.equals("P")){
					changeTheDigits();
					 
				}else if (chooseOperation.equals("S")){
					selectTheCurrentRecord();
					 
				}else if (chooseOperation.equals("D")){
					deleteTheCurrentRecord();
					 
				} else{
					System.out.println("Invalid input. The available valid input are: ");
					 
				}

		} 

	}

}
