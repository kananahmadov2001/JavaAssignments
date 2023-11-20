public class RecursiveMethods {

	/**
	 * Exponent Method
	 	* Recursively computes base ^ exponent 
	 	* @param base the base - can be positive or negative
	 	* @param exp  the exponent - can be positive or negative
	 	* @return base ^ exponent
	 */
	
	public static double exponent(int base, int exp) {
		
		//base step
		if(exp == 0) {
			return 1;
		//recursive steps
		} else if(exp>0) {
			return base * exponent(base, exp-1);
		} else {	
			return 1/(base * exponent(base, -exp-1));
		}
	}

  
	/**
	 * arraySum Method which also has arraySumHelper Method to do the recursion process
	 	* Recursively compute the sum of elements in an array
	 	* @param array an array of integers
	 	* @return the sum of the elements in values
	 */
	
	public static int arraySum(int[] array) {
		return arraySumHelper(array, 0);
	}
	
	public static int arraySumHelper(int[] array, int index) {
		
		//base step
		if(index>=array.length) {
			return 0;
		//recursive step
		} else {
			return array[index] + arraySumHelper(array, index+1);
		}
	}
	
	
	/**
	 * Return a new String which is the original source String with all occurrences
	 * of the target character substituted by the replacement String.
	 * 
	 * @param source      the source String
	 * @param target      the target character to be replaced
	 * @param replacement the replacement String
	 * 
	 * @return the String which results from substituting all of the target
	 *         characters in the source String with the replacement String
	 */
	
	public static String substituteAll(String source, char target, String replacement) {
		String result = "";
		for (int i = 0; i < source.length(); ++i) {
			char ch = source.charAt(i);
			if (ch == target) {
				result = result + replacement;
			} else {
				result = result + ch;
			}
		}
		return result;
	}

	/**
	 * Recursively computes string representations of dragon curves
	 * 
	 * @param n the desired degree of the dragon curve
	 * @return the nth dragon curve
	 */
	
	public static String dragon(int n) {
		if (n == 0) {
            return "F-H";
        } else {
        	//recursively get n-1 degree dragon
        	String result = dragon(n-1); 
        	//replace all the original "F" with "t"
        	result = substituteAll(result, 'F', "t");
        	//replace all the original "H" with "F+H"
        	result = substituteAll(result, 'H', "F+H");
        	//replace all the "t" with "F-H"
        	result = substituteAll(result, 't', "F-H");
        	return result;	
        }
	}

	
	/**
	 * Finds the length of the longest path in the given 2D array from the specified
	 * start position.
	 * 
	 * @param chart 2D array of stones
	 * @param r     start position row
	 * @param c     start position column
	 * @return the length of the longest path that was found
	 */

	public static int maxPathLength(boolean[][] chart, int r, int c) {
		if (r < 0 || r >= chart.length || c < 0 || c >= chart[0].length || !chart[r][c]) {
			return 0;
		} else {
			chart[r][c] = false;

			int up = 1 + maxPathLength(chart, r-1, c);
			int down = 1 + maxPathLength(chart, r+1, c);
			int left = 1 + maxPathLength(chart, r, c-1);
			int right = 1 + maxPathLength(chart, r, c+1);

			int maxPath = Math.max(Math.max(up,left),Math.max(down,right));
		
			chart[r][c] = true;
		
			return maxPath;
		}
	}
  
}
