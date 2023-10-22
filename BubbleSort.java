import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		System.out.println("The size of the array: ");
		// inputing the size of the array
		int sizeArr = in.nextInt();

		int[] arr = new int[sizeArr];
		System.out.println("Enter the integer values you want to store in the array: ");
		
		// adding the integer values in the scanner
		for(int i = 0; i < arr.length; i++) {
			arr[i]= in.nextInt();
		}
		System.out.print("Given values: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
		
		for(int i=0; i<=arr.length-1; i++ ) {
			for(int j=1; j<=arr.length-i-1;j++) {
				int temp=0;
				if(arr[j-1]>arr[j]) {
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		System.out.println();
		System.out.print("Sorted values: ");
		for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    
  }
  
}
