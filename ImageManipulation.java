import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ImageManipulation {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
	    System.out.println("Welcome to the Image Manipulation App!");
        System.out.println("********************************************************************************************************************************");
        System.out.println("Image Manipulation Program modifies images as well as creating new images using 2D arrays.");
        System.out.println("Its functionality includes stretching the image horizontally, shrinking the image vertically, negating the color, applying a color filter, and inverting the image."); 
        System.out.println("Also, creating an image consisting of random pixels, placing a rectangle in the image, and using the method to randomly place many rectangles in the image.");
        System.out.println("********************************************************************************************************************************");
        System.out.println("Firstly, enter the URL (or the location) of your favorite picture: ");
        String URL = scanner.next();
        int[][] imageData = imgToTwoD(URL);
            
	    while(true) {
	        System.out.println();
            System.out.println("Now choose what functionality you would like to apply on your favorite picture: ");
	        System.out.println("1) Trimming");
	        System.out.println("2) Filtering Negative");
	        System.out.println("3) Stretching Horizontally");
	        System.out.println("4) Shrinking Vertically");
            System.out.println("5) Inverting");
	        System.out.println("6) Coloring");
            System.out.println("7) All of them");
	        System.out.println("8) Generate Rectangles and Paint them");
            System.out.println("9) Just show me the Image Data (Matrix information)");
            System.out.println("10) Exit the Program");
            System.out.println();
	
        int functionality = scanner.nextInt();
	    System.out.println();	

        if (functionality == 1) {
        int[][] trimmed = trimBorders(imageData, 60);
        twoDToImage(trimmed, "./trimmed.jpg");
	    } else if (functionality == 2) {
        int[][] negative = negativeColor(imageData);
        twoDToImage(negative, "./negative.jpg");
	    } else if (functionality == 3) {
        int[][] stretchedHImg = stretchHorizontally(imageData);
        twoDToImage(stretchedHImg, "./stretched.jpg");
        } else if (functionality == 4) {
        int[][] shrankVImg = shrinkVertically(imageData);
        twoDToImage(shrankVImg, "./shrank.jpg");
        } else if (functionality == 5) {
        int[][] invertedImg = invertImage(imageData);
        twoDToImage(invertedImg, "./inverted.jpg");
        } else if (functionality == 6) {
        int[][] coloredImage = colorFilter(imageData, 10, 20, 30);
        twoDToImage(coloredImage, "./colored.jpg");
        } else if (functionality == 7) {
        int[][] allFilters = stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40)));
        twoDToImage(allFilters, "./allFilters.jpg");
        } else if (functionality == 8) {
        int[][] blankImg = new int[500][500];
        int[][] randomImg = paintRandomImage(blankImg);
        twoDToImage(randomImg, "./randomImg.jpg");
        int[] rgba = { 255, 255, 0, 255 };
        int[][] rectangleImg = paintRectangle(randomImg, 200, 200, 100, 100, getColorIntValFromRGBA(rgba));
        twoDToImage(rectangleImg, "./rectangleImg.jpg");
        int[][] generatedRectangles = generateRectangles(randomImg, 1000);
        twoDToImage(generatedRectangles, "./generatedRectangles.jpg");
	    } else if (functionality == 9) {
        viewImageData(imageData);
        } else if (functionality == 10) {
		    scanner.close();
            return;
        } else {
        System.out.println("Error! We don't have a matching functionality for your specified number!");
        }
        
        System.out.println("Do you want to continue? Y/n");
        char s = (scanner.next()).charAt(0);
        if(s=='n') {
            scanner.close();
            return;
        }
        while(s!='n' && s!='Y'){ 
            System.out.println("Unexpected Letter. Please, try Y (yes) or n (no)");
            s = (scanner.next()).charAt(0);
        }
        if(s=='n') {
            scanner.close();
            return;
        }
    }
}

    /***********************************************************************************************************************
     * Image Processing Methods
     * -> colorFilter() method is for modifying every pixel in the image by provided R, G, and B values as input parameters.
    ***********************************************************************************************************************/

    public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {
        if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
            int[][] trimmedImg = new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
            for (int i = 0; i < trimmedImg.length; i++) {
                for (int j = 0; j < trimmedImg[i].length; j++) {
                    trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
                }
            }
            return trimmedImg;
        } else {
            System.out.println("Cannot trim that many pixels from the given image.");
            return imageTwoD;
        }
    }

    public static int[][] negativeColor(int[][] imageTwoD) {
        int[][] negativeImage = new int[imageTwoD.length][imageTwoD[0].length];
        for (int i = 0; i < imageTwoD.length; i++) {
            for (int j = 0; j < imageTwoD[i].length; j++) {
                int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
                rgba[0] = 255 - rgba[0];
                rgba[1] = 255 - rgba[1];
                rgba[2] = 255 - rgba[2];
                negativeImage[i][j] = getColorIntValFromRGBA(rgba);
            }
        }
        return negativeImage;
    }

    public static int[][] stretchHorizontally(int[][] imageTwoD) {
        int[][] stretchedImage = new int[imageTwoD.length][imageTwoD[0].length * 2];
        int it = 0;
        for (int i = 0; i < imageTwoD.length; i++) {
            for (int j = 0; j < imageTwoD[i].length; j++) {
                it = j * 2;
                stretchedImage[i][it] = imageTwoD[i][j];
                stretchedImage[i][it + 1] = imageTwoD[i][j];
            }
        }
        return stretchedImage;
    }

    public static int[][] shrinkVertically(int[][] imageTwoD) {
        int[][] shrankImage = new int[imageTwoD.length / 2][imageTwoD[0].length];
        for (int i = 0; i < imageTwoD[0].length; i++) {
            for (int j = 0; j < imageTwoD.length - 1; j += 2) {
                shrankImage[j / 2][i] = imageTwoD[j][i];
            }
        }
        return shrankImage;
    }

    public static int[][] invertImage(int[][] imageTwoD) {
        int[][] invertImage = new int[imageTwoD.length][imageTwoD[0].length];
        for (int i = 0; i < imageTwoD.length; i++) {
            for (int j = 0; j < imageTwoD[i].length; j++) {
                invertImage[i][j] = imageTwoD[(imageTwoD.length - 1) - i][(imageTwoD[i].length - 1) - j];
            }
        }
        return invertImage;
    }

    public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, int greenChangeValue,
            int blueChangeValue) {
        int[][] colorFilterImage = new int[imageTwoD.length][imageTwoD[0].length];
        for (int i = 0; i < imageTwoD.length; i++) {
            for (int j = 0; j < imageTwoD[i].length; j++) {

                int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
                int newRedValue = rgba[0] + redChangeValue;
                int newGreenValue = rgba[1] + greenChangeValue;
                int newBlueValue = rgba[2] + blueChangeValue;

                if (newRedValue > 255) {
                    newRedValue = 255;
                } else if (newRedValue < 0) {
                    newRedValue = 0;
                }
                if (newGreenValue > 255) {
                    newGreenValue = 255;
                } else if (newGreenValue < 0) {
                    newGreenValue = 0;
                }
                if (newBlueValue > 255) {
                    newBlueValue = 255;
                } else if (newBlueValue < 0) {
                    newBlueValue = 0;
                }

                rgba[0] = newRedValue;
                rgba[1] = newGreenValue;
                rgba[2] = newBlueValue;

                colorFilterImage[i][j] = getColorIntValFromRGBA(rgba);
            }
        }
        return colorFilterImage;
    }

    /***********************************************************************************************************************
     * Painting Methods
     * -> paintRandomImage() method is for modifying the image passed in by replacing every pixel with a randomly colored pixel.
     * -> paintRectangle() method is for drawing a rectangle on an image using a provided width, height, rowPosition, columnPosition, and color.
     * -> generateRectangles() method will use the paintRectangles() method to paint a piece of art. It will generate randomly positioned, sized, and colored rectangles based on the provided number. The input parameter, numRectangles will determine how many randomly generated rectangles will be placed in the image.
    ***********************************************************************************************************************/

    public static int[][] paintRandomImage(int[][] canvas) {
        Random random = new Random();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                int randomRed = random.nextInt(256);
                int randomGreen = random.nextInt(256);
                int randomBlue = random.nextInt(256);
                int[] rgbaValues = { randomRed, randomGreen, randomBlue, 255 };
                // 255 in the array represents the alpha value (which controls transparency)
                canvas[i][j] = getColorIntValFromRGBA(rgbaValues);
            }
        }
        return canvas;
    }

    public static int[][] paintRectangle(int[][] canvas, int width, int height, int rowPosition, int colPosition,
            int color) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (i >= rowPosition && i <= rowPosition + width) {
                    if (j >= colPosition && j <= colPosition + height) {
                        canvas[i][j] = color;
                    }
                }
            }
        }
        return canvas;
    }

    public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
        Random random = new Random();
        for (int i = 0; i < numRectangles; i++) {
            int randomHeight = random.nextInt(canvas.length);
            int randomWidth = random.nextInt(canvas[0].length);

            // we also have to ensure that the rectangle does not get created outside of the image
            int randomRowPos = random.nextInt(canvas.length - randomHeight);
            int randomColPos = random.nextInt(canvas[0].length - randomWidth);

            int[] rgbaValues = { random.nextInt(256), random.nextInt(256), random.nextInt(256), 255 };
            // 255 in the array represents the alpha value (which controls transparency)
            int randomColor = getColorIntValFromRGBA(rgbaValues);

            // now, calling the paintRectangle() method using all of the values declared in generateRectangles() method
            canvas = paintRectangle(canvas, randomWidth, randomHeight, randomRowPos, randomColPos, randomColor);
        }
        return canvas;
    }

    /***********************************************************************************************************************
     * Utility Methods
    ***********************************************************************************************************************/

    public static int[][] imgToTwoD(String inputFileOrLink) {
        try {
            BufferedImage image = null;
            if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) {
                URI imageUri = new URI(inputFileOrLink);
                URL imageUrl = imageUri.toURL();
                image = ImageIO.read(imageUrl);
                if (image == null) {
                    System.out.println("Failed to get image from provided URL.");
                }
            } else {
                image = ImageIO.read(new File(inputFileOrLink));
            }
            int imgRows = image.getHeight();
            int imgCols = image.getWidth();
            int[][] pixelData = new int[imgRows][imgCols];
            for (int i = 0; i < imgRows; i++) {
                for (int j = 0; j < imgCols; j++) {
                    pixelData[i][j] = image.getRGB(j, i);
                }
            }
            return pixelData;
        } catch (Exception e) {
            System.out.println("Failed to load image: " + e.getLocalizedMessage());
            return null;
        }
    }

    public static void twoDToImage(int[][] imgData, String fileName) {
        try {
            int imgRows = imgData.length;
            int imgCols = imgData[0].length;
            BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < imgRows; i++) {
                for (int j = 0; j < imgCols; j++) {
                    result.setRGB(j, i, imgData[i][j]);
                }
            }
            File output = new File(fileName);
            ImageIO.write(result, "jpg", output);
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e.getLocalizedMessage());
        }
    }

    public static int[] getRGBAFromPixel(int pixelColorValue) {
        Color pixelColor = new Color(pixelColorValue);
        return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
    }

    public static int getColorIntValFromRGBA(int[] colorData) {
        if (colorData.length == 4) {
            Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
            return color.getRGB();
        } else {
            System.out.println("Incorrect number of elements in RGBA array.");
            return -1;
        }
    }

    public static void viewImageData(int[][] imageTwoD) {
        if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
            int[][] rawPixels = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    rawPixels[i][j] = imageTwoD[i][j];
                }
            }
            System.out.println("Raw pixel data from the top left corner.");
            System.out.print(Arrays.deepToString(rawPixels).replace("],", "],\n") + "\n");
            int[][][] rgbPixels = new int[3][3][4];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
                }
            }
            System.out.println();
            System.out.println("Extracted RGBA pixel data from top the left corner.");
            for (int[][] row : rgbPixels) {
                System.out.print(Arrays.deepToString(row) + System.lineSeparator());
            }
        } else {
            System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
        }
    }

}
