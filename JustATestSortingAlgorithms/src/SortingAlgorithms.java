import java.util.Arrays;

public class SortingAlgorithms {
	public static void main(String [] args){
		System.out.println("This program will do bubble sort first ");
		int numbers [] =  new int [15];
		
		int j =0;
		for(int i = numbers.length; i > 0 ; i--){
			numbers[j] = i;
			j++;
		}
		System.out.println(Arrays.toString(numbers));
		System.out.println("The length of the array numbers is " + numbers.length);
		bubblesorts(numbers);
		
		int numbers2 [] = {2,5,7,8,12};
		System.out.println("Bubble sorting array numbers2");
		bubblesorts(numbers2);
		
		j=0;
		int numbers3 [] =  new int [15];
		for(int i = numbers3.length; i > 0 ; i--){
			numbers3[j] = i;
			j++;
			 
		}
		
		System.out.println("us" + Arrays.toString(numbers3));
		System.out.println("The selection sort after execution is " + selectionSort(numbers3));
		
		j=0;
		int numbers4 [] =  new int [15];
		for(int i = numbers4.length; i > 0 ; i--){
			numbers4[j] = i;
			j++;
			 
		}
		System.out.println("before insertion sort " + Arrays.toString(numbers4));
		insertionSort(numbers4);
	}
	
	
	/**
	 * This is a method that sorts an unsorted array into correct order
	 * @param a
	 * @return
	 */
	
	public static int [] bubblesorts(int [] a){
		
		int array [] = a;
		int o =1;
		int some =0;
		for(int i=0; i < array.length-1;i++){
			for(int j =0; j < array.length - 1 - i ;j++){
				some++;
				if(array[j] > array[j+1]){
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				 
				}
			}
			System.out.println("some " + some);
			System.out.println(Arrays.toString(array) + " It is on cycle " + o++ );
		}
		
		System.out.println("bubble sort ran a total of " + some + " times ");
		
		return array;
		
	}
	
	
	/**
	 * This is for selection sort
	 */
	
	public static String selectionSort(int [] a){
		
		int array[] = a; int some = 0;
		
		for(int i =0; i < array.length -1; i++){
			
			for(int j =i; j < array.length ; j++){
				some ++;
				if(array[j] < array[i]){
					
					int temp = array[i];
					array[i] = array[j];
					array[j]= temp;
					
					
				}
				
				
			}
		 System.out.println(some);
			
			
		}
		
		
		System.out.println(" selection sort ran a total of " + some + " times ");
		 
		return Arrays.toString(array);
	}
	
	/**
	 * Insertion Sort
	 * todo fix later
	 */
	
	
	public static String insertionSort(int [] a){
		int j =0;
		int array[] = a;
		for(int i =0; i < array.length -1; i++){
			
			int currentEle = array[i];
			j = i +1;
			while(array[j] < currentEle && j<array.length){
				array[j+1] = array[j];
				j = j - 1;
				array[j] = currentEle;
				
			}
			
		}
		
		System.out.println("THe insertion sorts result " + Arrays.toString(array));
		
		return Arrays.toString(array);
		
	}
	
}
