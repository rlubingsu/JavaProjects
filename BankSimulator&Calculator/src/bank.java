 
import java.util.*; // Importing the utility class so i can use scanner and so on
import java.util.concurrent.*; // importing concurrent so that i can use ThreadPoolExecutor for time control

/**
 * The purpose of this program is to simulate a bank at working hours. Where
 * there are 5 tellers and each teller will have a designated customer for a set
 * amount of time. The purpose of this program is to gain experience with queues
 * and using arrays to store data. The program will run for a set amount of time
 * of 2 minutes and after that the program will end. In order to use this class
 * you need a scanner class so that when the user is prompted to enter y or n
 * they may do so. The algorithm used in this program was to create a
 * conditional statement at first which will take a value of y or n from the
 * user to start or end the entire program. If none of these are met the program
 * will end and a message will be printed on the screen stating that they have
 * entered the wrong character to use the program. After the users selection has
 * been made it then displays a message to the user stating it is starting. as
 * soon as that happens the method named run will be executed. Runnable is being
 * used since the program has a multitude of objects that are being executed
 * using thread. In order to use this interface a method named run must be
 * created. A queue is made to hold the customers. Then an array of tellers will
 * be assigned a random number for which they assist each customer. When the
 * count is reached it goes on to the next customer. Each teller gets a set
 * variable such as processtime , variables helped to return the amount of
 * customers they helped, and time spent to return the amount of spent time in
 * total. After that there are a series of conditional statements to handle the
 * amount of time and loops to execute the interaction with customers for the
 * set period of time of 2-5 seconds. Up until the time reaches 2 minutes it
 * will keep executing statements till time is reached. After the time is
 * reached i then display the results of the simulation. That is: the total
 * amount of customers that visited the bank for that 2 minutes, the total
 * amount of customers that each teller helped, the total amount of time that
 * each teller was occupied and the total amount of customers that did not get
 * to see a teller. When a bank teller becomes available their boolean value
 * becomes true then after the amount of time with the customer is reached it
 * goes back to false and another banker from the array is chosen at random.
 * * @author Alisha Mimdani
 *
 */
public class bank {
	
	public static void main(String args[]) {
		System.out.println("Alisha Mimdani \n CSC2720:86474");
		Scanner in = new Scanner(System.in); // declaring my scanner object in
												// order to take user input
		System.out.println("Would you like to start the simulator?(y==yes)(n==no)");
		String input = in.next().toLowerCase();
		Random random = new Random(); // Creating my object of the random class so that i may generate random integers

		if (input.equals("y")) {
		 System.out.println("Simulation starting");
			Runnable runned = new Runnable() {

				Queue<Integer> lineQueue = new LinkedList<Integer>(); // Implement
																		// of
																		// Queue
																		// class
				// This variable will hold the number of customers
				int totalC;
				// all of the bankers are intialized with false so that they
				// start off as unavailable then at random
				// one will be chosen and their value will become true
				boolean Bankteller1 = false;
				boolean Bankteller2 = false;
				boolean Bankteller3 = false;
				boolean Bankteller4 = false;
				boolean Bankteller5 = false;

				/*
				 * This array is holding all of the 5 bank tellers within the
				 * program.
				 */
				boolean[] availableBanker = { Bankteller1, Bankteller2, Bankteller3, Bankteller4, Bankteller5 };

				int tellerTime1 = 1;
				int tellerT2 = 1;
				int tellerT3 = 1;
				int tellerT4 = 1;
				int bTellerT5 = 1;;

				// This variable named time is holding the amount of seconds
				// that have passed. until it reaches 120
				// the program will run continuously. 120 is approximately 2
				// mins
				int time;

				/*
				 * Each variable help contains a value for how many customers
				 * each teller assisted in the simulation
				 * 
				 */
				int help = 0;// holds count for teller 1

				int bTellerH = 0;// holds count for teller 2
				int customersHelpedT3 = 0; // holds count for teller 3
				int customersHelpedT4 = 0;// holds count for teller 4
				int customersHelpedT5 = 0;// holds count for teller 5

				// Time spent with each customer for each teller
				int time1 = 0;// holds time spent for teller 1
				int time2 = 0;// holds time spent for teller 2
				int time3 = 0;// holds time spent for teller 3
				int time4 = 0;// holds time spent for teller 4
				int time5 = 0;// holds time spent for teller 5

			 
				int teller1;
				int teller2;
				int teller3;
				int teller4;
				int teller5;

				// Random time with teller (2 - 5 seconds random)
				int[] randTeller = { (random.nextInt(5 - 2) + 2), (random.nextInt(5 - 2) + 2),
						(random.nextInt(5 - 2) + 2), (random.nextInt(5 - 2) + 2), (random.nextInt(5 - 2) + 2) };

				/**
				 * This is the run method that is to be created when using the
				 * runnable interface provided in the java library. Runnable is
				 * implemented by class Thread. Being active simply means that a
				 * thread has been started and has not yet been stopped. so it
				 * keeps running till the value 120 is reached.
				 * 
				 */
				public void run() {
					// Initialized at a lower number just for testing purposes -
					// 2 mins is too long to wait
					// OUTPUT MESSAGE - BANK SIMULATION RESULTS

					/*
					 * This conditional statement handles when time reaches 120
					 * seconds which is ~ 2 mins. When it does so it will print
					 * out the results of the simulation. If it is not 120 it
					 * will executed the other conditional statements until 120
					 * is met. In here are a series of conditional statements so
					 * that when a particular bankteller is chosen it loops for
					 * the set amount of time.
					 */
					if (time == 118) {

						totalC = help + bTellerH + customersHelpedT3 + customersHelpedT4 + customersHelpedT5
								+ lineQueue.size();

						/*
						 * Displaying all of the results for all of the bank tellers in the simulation
						 * im displaying the total amount  of customers they helped the total amount of 
						 * time they were used in the simulation and the size of the que which holds the total amount of customers
						 */
						System.out.println("Total amount of customers  " + totalC + "\n");
						System.out.println("Bank Teller 1 helped: " + help + " customers" + " total time: "
								+ ((int)time1 / 3.83 )+ " seconds");
						System.out.println("Bank Teller 2 helped: " + bTellerH + " customers"
								+ "total time  " +((int) time2 / 3.83) + " seconds");
						System.out.println("Bank Teller 3 helped: " + customersHelpedT3 + " customers"
								+ " total time: " + ((int)time3 / 3.83) + " seconds");
						System.out.println("Bank Teller 4 helped: " + customersHelpedT4 + " customers"
								+ "total time: " + ((int)time4 / 3.83 )+ " seconds");
						System.out.println("Bank Teller 5 helped: " + customersHelpedT5 + " customers"
								+ "total time: " + ((int)time5 / 3.83 ) + " seconds");
						System.out
								.println("\n\t - Total amount of customers that did not get help: " + lineQueue.size());

							System.out.println("would you like to run the program again?(y==yes) other keys terminate");
							String io = in.next().toLowerCase();
							/*
							 * Asking the user whether they want to restart the program
							 * if they do they enter yes
							 */
							if(io.equals("y")){
								System.out.println("Program restarting");
								main(null);
							}
							else{
								System.out.println("Program done"); // this will be displayed if the user enters something other than y
								System.exit(-1);
							}

						 

					} else {
						/*
						 * This generates a random number between two and 5 for
						 * the time with each customer a bank teller will
						 * encounter in the simulation
						 */
						if (random.nextInt(2) < 6) {
							int num = (random.nextInt(5 - 2) + 3);
							lineQueue.add(num);
						}
						/*
						 * This initiates the timer and resets the timer after a customer has been served. 
						 * Each teller has their own loop that resets their time
						 */
						while (teller1 == 1) {
							tellerTime1 = time;
							teller1 = 0;
						}
						if ((time - tellerTime1) >= randTeller[0]) {
							System.out.println("Teller 1 is now available.");
							availableBanker[0] = true; // Teller is now
														// available
						}
						/**
						 * Once the time is met it displays a customer was served
						 */
						if (availableBanker[0] == true && lineQueue.isEmpty() == false) {
							time1 = time1 + randTeller[0];
							randTeller[0] = lineQueue.poll();
							teller1 = 1;
							System.out.println("Teller 1 served a customer");
							help++;
						}

						while (teller2 == 1) {
							tellerT2 = time;
							teller2 = 0;
						}
						if ((time - tellerT2) >= randTeller[1]) {
							System.out.println("Teller 2  is available. ");
							availableBanker[1] = true; // Teller is now
														// available
						}
						if (availableBanker[1] == true && lineQueue.isEmpty() == false) {
							time2 = time2 + randTeller[1];
							randTeller[1] = lineQueue.poll();
							teller2 = 1;
							System.out.println("Teller 2 served a customer");
							bTellerH++;
						}
 
						while (teller3 == 1) {
							tellerT3 = time;
							teller3 = 0;
						}
						/**
						 * This determines whether teller 3 is available or not. It does so by checking its time relative to other
						 * in the array randomteller that determines the random time given to it
						 */
						if ((time - tellerT3) >= randTeller[2]) {
							System.out.println("Teller 3 is available.");
							availableBanker[2] = true; // Teller is available since it is set to true
						}
						if (availableBanker[2] == true && lineQueue.isEmpty() == false) {
							time3 = time3 + randTeller[2];
							randTeller[2] = lineQueue.poll();
							teller3 = 1;
							System.out.println("Teller 3 served a customer");
							customersHelpedT3++;

						}

					 
						while (teller4 == 1) {
							tellerT4 = time;
							teller3 = 0;
						}
						if ((time - tellerT4) >= randTeller[3]) {
							System.out.println("Teller 4 is available.");
							availableBanker[3] = true;  // the teller becomes avaialable once its boolean value is true
						}
						if (availableBanker[3] == true && lineQueue.isEmpty() == false) {
							time4 = time4 + randTeller[3];
							randTeller[3] = lineQueue.poll();
							teller4 = 1;
							System.out.println("Teller 4 served a customer");
							customersHelpedT4++;
						}

				 
						while (teller5 == 1) {
							bTellerT5 = time;
							teller5 = 0;
						}
						if ((time - bTellerT5) >= randTeller[4]) {
							System.out.println("Teller 5 is available.");
							availableBanker[4] = true; // Teller is now
														// available
						}
						if (availableBanker[4] == true && lineQueue.isEmpty() == false) {
							time5 = time5 + randTeller[4];
							randTeller[4] = lineQueue.poll();
							teller5 = 1;
							System.out.println("Teller 5 served a customer");
							customersHelpedT5++;
						}

						time++;

					} 

				} //End of the run method

			};
			// it runs after a given delay of a second
			ScheduledThreadPoolExecutor execute = new ScheduledThreadPoolExecutor(1);

			execute.scheduleAtFixedRate(runned, 0, 1, TimeUnit.SECONDS);
		}

			 
 

		/*
		 * If the user enters n the program will display a message to the user and terminate 
		 */
			else if(input.equals("n")){
			System.out.println("Program done.");
			System.exit(-1);
			}

		/*
		 *This will handle if the user inputs something other than y or n
		 *if it is other than those two valid inputs it will ask a series of questions for the user
		 *it will either terminate or call the main method 
		 */
			else{
			System.out.println("Invalid input");
			System.out.println("Would you like to exit the program ?\n(n==no y==yes");
			String io = in.next().toLowerCase();
			if(io.equals("y")){
			System.exit(-1);
			}
			else if(io=="n"){
				main(null);
			}
			else{
				System.out.println("Programing terminating");
			}
			 

		}  
	 
 
	}
}
