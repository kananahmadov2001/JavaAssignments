import java.util.Scanner;

public class Nim {
	
	public static void main(String[] args) {
		
	Scanner in = new Scanner(System.in);
	
	System.out.println("Choose the initial number of sticks in the game: ");
	int numSticks = in.nextInt();
	
	System.out.println("Let's start the game. Human must make the first move.");
	
	int round = 0;
	boolean humanWon = false;
		
	while (numSticks > 0) {
			
		System.out.println("Take: ");
		int humanNum = in.nextInt();
		
		// making sure that human doesn't enter invalid number. Checking conditions for invalid inputs.
		if(numSticks != 1){
			while(humanNum != 1 && humanNum != 2){
    			System.out.println("Invalid number of sticks entered for human, enter again.");
    			System.out.println("Take: ");
    			humanNum = in.nextInt();
   			}
		    
		} else {
			while(humanNum != 1){
    			System.out.println("Number of sticks exceeds total sticks, enter again.");
    			System.out.println("Take: ");
   				humanNum = in.nextInt();
   			}
		}
		
		int previousSticks = numSticks;
		numSticks -= humanNum;			
		System.out.println("Round " + round + ": " + previousSticks + " at start human takes " + humanNum + ", so " + numSticks + " remain");
		round++;
		
		if(numSticks > 0){
			int compNum;
			
			if (numSticks != 1){
				int randomNum = (int) (Math.random() * 10);
				compNum = randomNum % 2 + 1;	
			} else {
					compNum = 1;
			    }
			
			previousSticks = numSticks;
			numSticks -= compNum;
			System.out.println("Round " + round + ": " + previousSticks + " at start computer takes " + compNum + ", so " + numSticks + " remain");
			round++;
			
		} else {
				humanWon = true;
			}
		
		}
    
    if (humanWon){
      System.out.println("You Win!");
    } else {
      System.out.println("Computer Wins");
    }
    
  }
}
