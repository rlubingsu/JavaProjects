/*
 * Roerson Lubin
 * CSC2720 86473
 * Instructor: Bhola
 */
package newV12B;

/**
 *Purpose: The purpose of the class is  to serve as the data type of the linkedlist
 *I have created a series of methods for which the first name last name
 *and phone number will be set by the user. In order to use this class an object of this class must be created
 *in order to use the setters which are the access modifiers
 * @author roberson lubin
 */
public class UserData {

	private  String phone ;  // declaring my variable to hold phone numbers entered by the user
	private   String Fname ; // declaring my variable Fname to hold the first name provided by the user
	private   String Lname ; // variable for holding last name provided by the user
 
	
	//public   int lSize = 0;
	
	
	 /**
	  * Unparametized constructor that allows you to create an object without providing 
	 * Arguments
	  */
	public UserData(){
		
	}
	
	/**
	 * This is the parametized constructor of the UserData class. This sets the phone, first name and last name to
	 * the desired things the user passes to this constructor. In order for this constructor to be used properly
	 * three strings must be passed to this constructor. 
	 * @param nFUser
	 * @param nLuser
	 * @param pUser
	 */
	public UserData(String nFUser, String nLUser, String pUser){
		phone = pUser;
		Fname = nFUser;
		Lname = nLUser ;
		
		
	}
	 
/**
 * This method sets the first name of a data location to the desired name 
 * the user wants. This method also can replace the users first name at the 
 * current record location. In order to use this method 
 * a string must be supplied	
 * @param firstF
 */
public void setFname(String firstF){
		
		Fname = firstF;
	}
	
/**
 * This method is a getter. It retrieves what the first name 
 * provided by the user is. If the user were to use SetFname 
 * getFname would show what it was replaced to
 * @return Fname
 */
	public  String getFName(){
		return Fname;
	}
	/**
	 * This method sets the last name provided by the user
	 * it stores the last name within the object the user makes
	 * the user must provide a string in order
	 * @param firstL
	 */
public void setLname(String firstL){
		
		Lname = firstL;
	}
	/**
	 * This method gets the last name of the user that the user set the current records
	 * last name to.  
	 * @return Lname
	 */
	public  String getLName(){
		return Lname;
	}
	/**
	 * This method sets the current records phone number. The user passes a string that they potentially
	 * want to change the current records phone. The parameter is then passed to this method and sets the current location in
	 * the linkedlist to this phone number
	 * @param firstPhone
	 */
public void setPhone(String firstPhone){
		
		phone = firstPhone;
	}
	/**
	 * This method returns the phone number from the list of data in the linkedlist
	 * @return phone
	 */
	public  String getPhone(){
		return phone;
	}
	/**
	 *  This is a method returns a string of phone first name and last name concatenated together
	 *  @return u
	 */
	public String toString(){
		String u = Fname + " " + Lname + " "+ phone + "\n";
		return u ;
	}
	
	
	
 
	
}
