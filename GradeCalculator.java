package assignment01;

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
	
		System.out.println("CSE131 Grade for: ");
		String name = in.nextLine();
		
		System.out.println();
		System.out.println("Average assignment grade: ");
		double averageAssignmentGrade = in.nextDouble();
		double weightedAssignmentGrade = averageAssignmentGrade*0.36;
        double roundedWeightedAssignmentGrade = Math.round(weightedAssignmentGrade*100.0)/100.0;
        System.out.println("Weighted assignment grade (out of 36): " + roundedWeightedAssignmentGrade);
		
		System.out.println();
		System.out.println("Number of studios attended: ");
		int studiosAttended = in.nextInt();
		double weightedStudioGrade = studiosAttended/8.0*10.0;
        double roundedWeightedStudioGrade = Math.round(weightedStudioGrade*100.0)/100.0;
		System.out.println("Weighted studio grade (out of 10): " + roundedWeightedStudioGrade);
		
		System.out.println();
		System.out.println("Average quiz grade: ");
		double averageQuizGrade = in.nextDouble();
		double weightedQuizGrade = averageQuizGrade*0.02;
		double roundedWeightedQuizGrade = Math.round(weightedQuizGrade*100.0)/100.0;
		System.out.println("Weighted quiz grade (out of 2): "+ roundedWeightedQuizGrade);
		
		System.out.println();
		System.out.println("Average exam grade: ");
		double averageExamGrade = in.nextDouble();
		double weightedExamGrade = averageExamGrade*0.54;
        double roundedWeightedExamGrade = Math.round(weightedExamGrade*100.0)/100.0;
		System.out.println("Weighted exam grade (out of 54): " + roundedWeightedExamGrade);
	
		System.out.println();
		double totalGrade = roundedWeightedAssignmentGrade + roundedWeightedStudioGrade + roundedWeightedQuizGrade + roundedWeightedExamGrade;
		System.out.println("Total Grade: " + totalGrade);
		
	}
}
