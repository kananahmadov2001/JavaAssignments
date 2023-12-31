# CSE Assignments

# Nim
* Nim is a game of strategy in which two players take turns removing sticks from a common pile. There are many variations of Nim, but we will stick with a simple version. On each turn a player must remove either 1 or 2 sticks from the pile. The goal of the game is to be the player who removes the last stick.
  * So, Nim.java designs a game in which one human player is competing against a computer. To simplify the work the person will always take the first turn.
  * While there is a winning strategy for this game, let's just create a computer player that makes random, but valid, moves.

# BubbleSort
* Bubble Sort is a simple, well known, algorithm that can be used to sort an array. Implementing a simple sorting algorithm such as bubble sort is often seen as a rite of passage for the novice computer scientist.
* The way that bubble sort works is by “bubbling” the larger values up. If a value is larger than its neighbor it will be swapped until all of the larger values make their way to the end of the array and the smaller values end up at the beginning of the array.

# FrequencyTable
* This program generates amount number of integers between 1 and max where amount and max are values supplied by the user through Scanner.

# SymmetricalImage
* This program uses n x m array (where n and m are values supplied by the user through Scanner) to create some randomly generated vertically symmetrical images.
  * To do this, first selecting a random point within the 2D array; then computing the “mirrored” point on the other side of the array. Both of these array positions should be marked.
  * For example, if the size of the array is 10x10 and the point that I have randomly selected is at position (2, 3), then the corresponding “mirrored” point would be at position (2, 6) and both of these positions would be marked in the array. Note that if (2, 6) was the randomly generated point that (2, 3) is still its mirrored point - the code should work in both situations.

# RecursiveMethods
* Recursion is the technique of making a function call itself. This technique provides a way to break complicated problems down into simple problems which are easier to solve.
  * exponent(int base, int exp) Method: this method recursively computes base^exp. The code works for positive and negative bases as well as positive and negative exponents.
  * arraySum(int[] array) Method: this method computes and returns the sum of the given array.
  * dragon(int n) Method: this method ecursively computes string representations of dragon curves using substituteAll(String source, char target, String replacement) Method which is meant for returning a new String which is the original source String with all occurrences of the target character substituted by the replacement String.
  * maxPathLength(boolean[][] chart, int r, int c) Method: this methid finds the length of the longest path in the given 2D array from the specified start position.
