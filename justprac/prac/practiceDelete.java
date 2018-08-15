import java.util.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
/*
This program is made to ask what operation the user wants to perform
and then goes to the methods it should go to
then after that in each method it will ask the user whether they would like to 
perform another operation or not

Try collecting all the numbers of the user into an array then add and multiply 
*/

public class practiceDelete{
	 public static void main(String[]args){
		 
		 Scanner in = new Scanner(System.in);
		 Random numbers = new Random();
		 int opas;
		 int []asd = new int [10];
		 for(int lmp12 = 0; lmp12 < asd.length;lmp12++){
			 opas = numbers.nextInt(25);
			 asd[lmp12] = opas;
		 }
		 
		 System.out.println("asd Array " + Arrays.toString(asd));
		 System.out.println(asd[6]);
		 System.out.println("Welome to the calculator");
		 
		 String userChooseOperaton;
		 do{
			 System.out.println("Choose from the following operations:\n Cube(C), Triangle (R)");
			 userChooseOperaton = in.next();
		 if(userChooseOperaton.equals("C")){
			 dcube();
		 }
		 else if(userChooseOperaton.equals("R")){
			 printT();
			 
		 }
		 }while(!(userChooseOperaton.equals("C") || userChooseOperaton.equals("R")));
		 
		 System.out.println("At index 6 :  " + asd[6]);
		 
		 reversedArray(asd);
		 evenElements(asd);
		 printFL(asd);
		 
		 
		 
		 
		  
	 
		 
	 }
	 
	 private static void evenElements(int [] popo){
		 int i =0;
		 while( i < popo.length){
			 if(popo[i]%2==0){
				 System.out.print(popo[i] +",  ");
			 }
			 i++;
		 }
		 
		 System.out.println(" Even elements ");
	 }
	 
	 private static void reversedArray(int [] opasd){
		 System.out.print(Arrays.toString(opasd));
		 System.out.println();
		 int lmp1 =0;
		 int sze = opasd.length - 1;
		 
		 while(sze >= lmp1){
			 System.out.print(opasd[sze] + " ");
			 sze --;
		 
	 }
		 
		 System.out.println("  Reveresed ");
	 }				 
	
	 
	 private static void printFL(int []lad){
		 int lop =0;
		 while(lop < lad.length){
			 if(lop == 0){
				 System.out.print(lad[lop]);
			 }
			 else if(lop == lad.length -1){
				 System.out.println(", "+ lad[lop]);
			 }
			 lop++;
		 }
		 System.out.println("First and Last");
		 
	 }

	 private static void printT(){
		 for(int lm = 0; lm < 15; lm++){
			 System.out.println();
			 
			 for(int lml = 0; lml<lm; lml++){
				 System.out.print("*");
			 }
			 
		 }
		  
		 
	 }
	private static void dcube() {
		System.out.print("What number would you like to cube ");
		Scanner lep = new Scanner(System.in);
		double lepa = lep.nextDouble();
		int whal = 0;
		double total = 1;
		while(whal<3){
			total = total * lepa;
			whal++;
		
		}
		 System.out.println(total);
		
	}
}
