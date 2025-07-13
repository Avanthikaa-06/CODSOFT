package org.stu;
import java.util.Scanner;
public class Calculator {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int sum=0;
		System.out.println("***Welcome To Student Grade Calculator***");
		System.out.println("ENTER NUMBER OF SUBJECTS");
		int no_of_subjects= sc.nextInt();
		for(int i=0;i<no_of_subjects;i++) {
			while(true) {
			System.out.println("Enter marks for subject:"+ (i+1));
			int marks= sc.nextInt();
			if( marks>=0 && marks<=100 ) {
				sum+=marks;
				break;
			}
			else {
				System.out.println("mark is invalid should be between 0 and 100");
	
			}
			}
		}
		double avg= (double)sum/no_of_subjects;
		String grade;
        if (avg >= 90) {
            grade = "O";
        } else if (avg >= 80) {
            grade = "A+";
        } else if (avg >= 70) {
            grade = "A";
        } else if (avg >= 60) {
            grade = "B+";
        } else if (avg >= 50) {
            grade = "B";
        } else if (avg >= 40) {
            grade = "C";
        } else {
            grade = "F (Fail)";
        }

        System.out.println("\n--- Result ---");
        System.out.println("Total Marks         : " + sum);
        System.out.printf("Average Percentage  : %.2f%%\n", avg);
        System.out.println("Grade               : " + grade);
        sc.close();
}
}
