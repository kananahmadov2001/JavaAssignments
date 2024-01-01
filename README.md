# Java Assignments

# GradeCalculator.java
* This program helps to compute the final course grade. It demonstrates that you can:
  * Create a Java class on your own
  * Arrange for the class to take inputs of interest
  * Compute output values of interest
  * Produce meaningful output based on your computations
  * Work with Java expressions

# Nim.java
* Nim is a game of strategy in which two players take turns removing sticks from a common pile. There are many variations of Nim, but we will stick with a simple version. On each turn a player must remove either 1 or 2 sticks from the pile. The goal of the game is to be the player who removes the last stick.
  * So, Nim.java designs a game in which one human player is competing against a computer. To simplify the work the person will always take the first turn.
  * While there is a winning strategy for this game, let's just create a computer player that makes random, but valid, moves.

# BubbleSort.java
* Bubble Sort is a simple, well known, algorithm that can be used to sort an array. Implementing a simple sorting algorithm such as bubble sort is often seen as a rite of passage for the novice computer scientist.
* The way that bubble sort works is by “bubbling” the larger values up. If a value is larger than its neighbor it will be swapped until all of the larger values make their way to the end of the array and the smaller values end up at the beginning of the array.

# FrequencyTable.java
* This program generates amount number of integers between 1 and max where amount and max are values supplied by the user through Scanner.

# SymmetricalImage.java
* This program uses n x m array (where n and m are values supplied by the user through Scanner) to create some randomly generated vertically symmetrical images.
  * To do this, first selecting a random point within the 2D array; then computing the “mirrored” point on the other side of the array. Both of these array positions should be marked.
  * For example, if the size of the array is 10x10 and the point that I have randomly selected is at position (2, 3), then the corresponding “mirrored” point would be at position (2, 6) and both of these positions would be marked in the array. Note that if (2, 6) was the randomly generated point that (2, 3) is still its mirrored point - the code should work in both situations.

# RecursiveMethods.java
* Recursion is the technique of making a function call itself. This technique provides a way to break complicated problems down into simple problems which are easier to solve.
  * exponent(int base, int exp) Method: this method recursively computes base^exp. The code works for positive and negative bases as well as positive and negative exponents.
  * arraySum(int[] array) Method: this method computes and returns the sum of the given array.
  * dragon(int n) Method: this method ecursively computes string representations of dragon curves using substituteAll(String source, char target, String replacement) Method which is meant for returning a new String which is the original source String with all occurrences of the target character substituted by the replacement String.
  * maxPathLength(boolean[][] chart, int r, int c) Method: this methid finds the length of the longest path in the given 2D array from the specified start position.

# ImageManipulation
* Purpose: writing a program to modify images as well as create new images using 2D array
  * Implemented a Java-based project that revolutionizes image manipulation, enabling users to enhance visuals through a menu-driven system effortlessly.
  * Developed a robust algorithmic framework that converts images into dynamic 2D arrays, enabling precise manipulation of individual pixels.
  * Leveraged 2D arrays for pixel-level precision, seamlessly implementing functions such as horizontal stretching, vertical shrinking, color negation, filters, and image inversion.
  * Applied customized noise matrices for each transformation, ensuring accurate and visually striking results across diverse image types and dimensions.
* What the program does:
  * Stretching the image horizontally, shrinking the image vertically, negating the color, applying a color filter, and inverting the image.
  * Also, creating an image consisting of random pixels, placing a rectangle in the image, and using the method to randomly place many rectangles in the image.
* General Info. Note:
  * Images consist of pixels which are the individual points in the image containing some color.
  * Each pixel has some red, green, blue, and alpha value which represents the amount of each of those colors in the pixel.
  * The red, green, and blue values can be mixed to create all of the visible colors on your screen.
  * The alpha value represents the transparency of the pixel (or how close the color of the pixel is to the background color of the image.
  * A higher resolution image means that there are more pixels contained within it.
* Project Spec. Note:
  * A loaded image is stored into a BufferedImage object. From this object, we can extract each pixel value and store it into a 2D array which we can manipulate.
  * The pixel values are stored as ints because each pixel value in the BufferedImage object is represented by a hexadecimal value which contains the red, green, blue, and alpha components.
  * The maximum value of any of the RGBA values is 255 and the minimum is 0.
  * Example of loading an image using a URL (or location):
    * int[][] imageData = imgToTwoD("https://content.codecademy.com/projects/project_thumbnails/phaser/bug-dodger.png");
    * int[][] imageData = imgToTwoD("C:\Users\kzahm\OneDrive\Pictures\GoldenRetriever.jpeg");
  
