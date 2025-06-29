import java.util.*;

class GradeCalculator {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("==============================================================================================");
        System.out.println("                        GRADE CALCULATOR");
        System.out.println("==============================================================================================");

        System.out.print("Enter the Student Roll Number: ");
        int rno = in.nextInt();
        in.nextLine(); 

        System.out.print("Enter the Student Name: ");
        String name = in.nextLine();

        System.out.print("Enter the number of subjects: ");
        int n = in.nextInt();
        in.nextLine(); 

        String[] subjects = new String[n];
        float[] marks = new float[n];
        String[] grades = new String[n];

        System.out.println("\nEnter subject names and marks:");

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter the name of Subject " + (i + 1) + ": ");
            subjects[i] = in.nextLine();

            System.out.print("Enter the mark for " + subjects[i] + " (out of 100): ");
            marks[i] = in.nextFloat();
            in.nextLine(); 

            grades[i] = calculateGrade(marks[i]);
        }

        float total = 0, avg;
        for (int i = 0; i < n; i++) {
            total += marks[i];
        }
        avg = total / n;

        System.out.print("\n==============================================================================================");
        System.out.println("                           STUDENT REPORT");
        System.out.println("==============================================================================================");
        System.out.println("Roll Number : " + rno);
        System.out.println("Name        : " + name);
        System.out.println("Total Subjects: " + n);
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-10s %-15s\n", "Subject", "Marks", "Grade");
        System.out.println("----------------------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s %-10.2f %-15s\n", subjects[i], marks[i], grades[i]);
        }

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("Total Marks : %.2f / %.2f\n", total, (n * 100.0));
        System.out.printf("Average     : %.2f%%\n", avg);

        System.out.print("Overall Grade: ");
        System.out.println(calculateGrade(avg));
        System.out.println("==============================================================================================");

        in.close();
    }

    // Function to calculate grade for individual subject
    public static String calculateGrade(float mark) {
        if (mark >= 90.0)
            return "A+";
        else if (mark >= 80.0)
            return "A";
        else if (mark >= 70.0)
            return "B+";
        else if (mark >= 60.0)
            return "B";
        else if (mark >= 50.0)
            return "C+";
        else if (mark >= 40.0)
            return "C";
        else
            return "D";
    }
}
