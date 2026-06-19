import java.util.Scanner;

public class StudentGradeCalculator {

    // Method to calculate grade
    public static String calculateGrade(double percentage) {

        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" STUDENT GRADE CALCULATOR");
        System.out.println("====================================");

        // Student Name
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        // Number of Subjects
        System.out.print("Enter Number of Subjects: ");
        int numberOfSubjects = sc.nextInt();

        while (numberOfSubjects <= 0) {
            System.out.print("Invalid input! Enter valid number of subjects: ");
            numberOfSubjects = sc.nextInt();
        }

        int totalMarks = 0;
        int highestMarks = 0;
        int lowestMarks = 100;

        // Input marks
        for (int i = 1; i <= numberOfSubjects; i++) {

            System.out.print("Enter marks for Subject " + i + " (0-100): ");
            int marks = sc.nextInt();

            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks! Enter between 0 and 100: ");
                marks = sc.nextInt();
            }

            totalMarks += marks;

            if (marks > highestMarks) {
                highestMarks = marks;
            }

            if (marks < lowestMarks) {
                lowestMarks = marks;
            }
        }

        // Calculations
        double average = (double) totalMarks / numberOfSubjects;
        double percentage = average;

        // Grade
        String grade = calculateGrade(percentage);

        // Output
        System.out.println("\n====================================");
        System.out.println(" STUDENT RESULT");
        System.out.println("====================================");
        System.out.println("Student Name : " + studentName);
        System.out.println("Subjects : " + numberOfSubjects);
        System.out.println("Total Marks : " + totalMarks);
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.printf("Percentage : %.2f%%%n", percentage);
        System.out.println("Highest Marks : " + highestMarks);
        System.out.println("Lowest Marks : " + lowestMarks);
        System.out.println("Grade : " + grade);

        if (percentage >= 40) {
            System.out.println("Result : PASS");
        } else {
            System.out.println("Result : FAIL");
        }

        System.out.println("====================================");

        sc.close();
    }
}
