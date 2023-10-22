import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class FrequencyTable {
	
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter Amount: ");
        int amount = in.nextInt();
        
        System.out.println("Enter Max: ");
        int max = in.nextInt();
        
        // Create array to store the frequencies for each index
        int[] arr = new int[max];
        
        // Initially fill 0 as frequency to all elements of indexes
        Arrays.fill(arr, 0);
        
        // Create instance of Random class
        Random rand = new Random();
        
        for(int i = 0; i < amount; i++){
            // Generate random integers in range 1 to max
            int randomInteger = rand.nextInt(max) + 1;
            
            // Increase that number's frequency inside the array by 1
            arr[randomInteger-1]++;
        }
        
        // Printing them
        System.out.println("Frequencies for " + amount + " randomly generated values between 1 and " + max);
        for(int i = 0; i < max; i++){
            System.out.print(i+1);
            System.out.println(": " + arr[i]);
        }
      
    }
}
