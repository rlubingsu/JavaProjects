/*
 * Name : Roberson Lubin
 * CSC2720 86473
 * Instructor : Bhola
 * Date: 09/01/2017
 */

/*
 * The primary purpose of this class is to display and compute the product and sum of two matrices with dimensions set by the user
 * In order to use the program you must answer two questions in order to enter the program
 * Any input that is incompatible will either cause the program to loop or terminate the program
 * Must enter y for both opening questions after your done and you no longer want to compute matrices enter any input other than y to terminate
 * I am also using ANSI code in order to display Red Font. This may not display on windows computers
 * 
 * 
 */
import java.util.*;		//importing the utility package in order to use Scanner
import javax.swing.*; //Importing the swing package in order to display messages
import java.awt.*;

public class Matrix {
	
	public static final String turnFontRed = "\u001B[31m"; //ANSI escape code. ANSI escape code doesn't work in windows so 
    													//it may not display the red color
	
	/*
	 * This method performs multiplication for the matrix
	 * It takes in two arrays 
	 * the return type is void
	 *   multiplies rows by columns until it reaches the length and starts on the next
	   The for nested loop performs this process
	   
	 */
	public static  void MultiplyMatrix(int[][] multArray, int[][]multArray2){
		 
		int theAmountOfRowsArray1 =  multArray.length;  // I am taking the amount of rows based off the users defined dimensions of the matrix
        int theAmountOfColumnsArray1 = multArray[0].length;
         
        int _NumOfColumnArray2 = multArray2[0].length;

      

        int[][] _ComputationOFMatrix = new int[theAmountOfRowsArray1][_NumOfColumnArray2];
      

        for (int rowCounter = 0; rowCounter < theAmountOfRowsArray1; rowCounter++) { // aRow
        	System.out.println();  
            System.out.print(" [ "); 
            for (int columnsCounterarr2 = 0; columnsCounterarr2 < _NumOfColumnArray2; columnsCounterarr2++) { // bColumn
                for (int columnsCounterarr1 = 0; columnsCounterarr1 < theAmountOfColumnsArray1; columnsCounterarr1++) { // aColumn
                    _ComputationOFMatrix[rowCounter][columnsCounterarr2] += multArray[rowCounter][columnsCounterarr1] * multArray2[columnsCounterarr1][columnsCounterarr2];
                    
                }
                System.out.print(_ComputationOFMatrix[rowCounter][columnsCounterarr2]+ " \t");
          	   
            }
            System.out.print(" ] "); 
            
        }
        System.out.println();
        System.out.println();
        long _milliseconds = System.currentTimeMillis() % 1000;
		//System.out.println(turnFontRed  + " It took " +_milliseconds+ " milliseconds to print the product " + turnFontRed ); 
        JOptionPane.showMessageDialog(null, "It took " + _milliseconds + "milliseconds to compute the product", "Timer",  JOptionPane.ERROR_MESSAGE);
		// Using ANSI CODE TO TURN TEXT RED. This may not display on Windows computers if it doesn't display red my colorThetext method will handle it
        String timers_Message = "It took " + _milliseconds + " milliseconds to compute the product ";
        ColorTheText(timers_Message,Color.red);
 
       
	
		
	}
	
	/*
	 * Main Method contains the prompts and conditional statements in order to proceed through the program
	 */

	public static void main(String[] args) {
	 
		Date todaysDate = new Date();  // using the date class to display the date and time
		JOptionPane.showMessageDialog(null, "Name: Roberson Lubin \n Class: CSC270 86473\n Instructor: Bhola \n Date: " + todaysDate);// Displaying my name class instructor and date with swing package
		Scanner in = new Scanner(System.in);
		 System.out.println("Would you like to enter into the matrix calculator (enter y for yes and any other key to exit)");
		 
			String decision = in.next();  // The user enters y to proceed and any other key to exit
		 /*
		  * If the decision is equal to y for yes it will enter the if statement and proceed. Otherwise it will terminate
		  * expected input is a string 
		  */
		 if(decision.equals("y")){
		 
			 
		
		 int userDefinedNum=0;
		   	
		   do {
			   
			   System.out.println("Are you sure you like to enter into the matrix calculator (enter y for yes and any other key to exit)");
			  
				  decision = in.next();  
			 
				  
				  if(decision.equals("y"))
				  {
		            do
		            {
		              	 
		             do{
		     System.out.println("Enter the desired dimension of array (number must be >=25)");
		   
		             
		      userDefinedNum= in.nextInt();  // expected input must be greater than 25
		             }while(userDefinedNum<25);
		      System.out.println("The first array: ");
			   int [][] myArray1 = new int [userDefinedNum][userDefinedNum];
			   int [][] myArray2 = new int [userDefinedNum][userDefinedNum];
			    PrintMatrix(myArray1); //Calling the PrintMatrix Method to print the desired dimensions of the users matrix
			    System.out.println();
			    System.out.println("The second array: ");
			    PrintMatrix(myArray2);
			    System.out.println("The product of the two is");
			    MultiplyMatrix(myArray1, myArray2);   // The method that is responsible for multiplying and displaying the amount taken to do calculations
			    System.out.println();
			    System.out.println("The sum of the two is");
			    AddMatrix(myArray1, myArray2); // The method that is responsible for adding and displaying the amount taken to do calculations
		            }while(userDefinedNum<25);
		        
				  }
				  else if(!decision.equals("y"))
				  {
					  System.out.println("Program Terminated");
				  }
					  
		   }
			while(decision.equals("y"));
		   
		    
		 
		 }
		 JOptionPane.showMessageDialog(null,"Program Terminated");
	     Long milliseconds = System.currentTimeMillis()%1000; 
		 System.out.println("You ran this program for approximately " + milliseconds + " milliseconds ");
		 
		    

		
	}
	 
	/*
	 This method prints the matrix and generates random numbers for the matrix using a nested for loop
	 Each row is surrounded by opening and closing brackets
	 It takes in one array at a time
	 * the return type is void
	 
	 */
 
	public static void PrintMatrix(int[][]printTheArray){
		for (int rows = 0; rows < printTheArray.length; rows++) {
			   System.out.println();
			    
		       System.out.print(" [ ");  
		       
		     
			   
			    for (int numOfCols = 0; numOfCols < printTheArray[rows].length; numOfCols++) {
			 
			        printTheArray[rows][numOfCols] = (int)(Math.random()*30+1);  // Creates Random integers for the matrix starting from 1 and ending at 30
			        System.out.print(printTheArray[rows][numOfCols]+ "\t");
			        
			      
			        
			        
			        
			    }
				  System.out.print(" ] "); //after each row a closing bracket is placed 
			}
	 
		  System.out.println();
		    long _milliseconds = System.currentTimeMillis() % 1000; 
		System.out.println("It took " +_milliseconds+ " milliseconds to print this ");
		
		 
	}
	
	 /*
	  This Method computes the sum of matrices by taking in both 2 dimensional arrays
	  It takes in one array at a time
	   the return type is void
	   It then adds rows by columns until it reaches the length and starts on the next
	   The for nested loop performs this process
	  */
	
	public static void AddMatrix(int[][]addArray, int[][]addArray2){
		
		int lengthOfArray1 = addArray.length;
	    int lengthOfArray2 = addArray[0].length;
	    int[][] holdSum = new int[lengthOfArray1][lengthOfArray2];
	    
	    for (int row = 0; row < lengthOfArray1; row++){
	    	System.out.println();
		    
		       System.out.print(" [ ");  
	        for (int cols = 0; cols < lengthOfArray2; cols++){
	            holdSum[row][cols] = addArray[row][cols] + addArray2[row][cols];
	            System.out.print(holdSum[row][cols]+ "\t");
	        }
	        System.out.print(" ] "); 
	    }
	    System.out.println();
	    System.out.println();
	    long _milliseconds = System.currentTimeMillis() % 1000;
	    String timer_Message =   "It took " + _milliseconds + "milliseconds to compute sum";
	    ColorTheText(timer_Message,Color.red);
	}
	

 
	
/*
 * This methods purpose is to only color the text. Create an object of JLabel. i am setting the foreground of the text by using my object and using the set
 * foreground method
 * I then make JOptionPaneMessageDialog and set what ever text that may come in as red when it exits
 */
public static void ColorTheText(String Timer, Color _timerColor){
        
        JLabel timerLabel = new JLabel(Timer);
   
        timerLabel.setForeground(_timerColor);
        
        JOptionPane.showMessageDialog(null, timerLabel);
     
         
    }
	 

}
