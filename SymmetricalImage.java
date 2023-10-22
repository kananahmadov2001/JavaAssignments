import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class SymmetricalImage {
	
	public static void main(String[] args) {
		// Create a Scanner object
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter N: ");
        int n = in.nextInt();
        
        System.out.println("Enter M: ");
        int m = in.nextInt();
        
        // Create 2d array
        boolean[][] arr = new boolean[n][m];
        
        // Initially fill false as it is not mirrored point
        for (boolean[] row: arr){
            Arrays.fill(row, false);
        }
        
        // Create instance of Random class
        Random rand = new Random();
        
        for(int i = 0; i < (n * m) / 4; i++){
            // Generate random integers in range 1 to n
            int randomN = rand.nextInt(n) + 1;
            
            // Generate random integers in range 1 to m
            int randomM = rand.nextInt(m) + 1;
            
            // Mark (n-1, m-1) point as mirrored point, minus 1 because of indexing starts from 0 in arrays
            arr[randomN-1][randomM-1] = true;
            
            // Row should stay same, but column should change to get corresponding mirrored point, and mark it as well as true
            arr[randomN-1][m-1-(randomM-1)] = true;
        }
        
        // Printing them
        System.out.println("A randomly generated, symmetrical " + n + " x " + m  + " image: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j]){
                    // if mirrored point then print *
                    System.out.print("*");
                } else {
                    // if not mirrored point then print just space
                    System.out.print(" ");
                }
            }
            // to go second row after one row completed
            System.out.println();
        }
    
	}
}
