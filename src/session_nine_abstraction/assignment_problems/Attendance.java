import java.util.Scanner;

public class Attendance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] attendance = new int[7];
        int presentCount = 0;

        for (int i = 0; i < 7; i++) {
            System.out.print("Enter attendance for day " + (i + 1) + " (1-Present, 0-Absent): ");
            attendance[i] = sc.nextInt();
            if (attendance[i] == 1) {
                presentCount++;
            }
        }

        double percentage = (presentCount / 7.0) * 100;
        System.out.println("Total Present Days : " + presentCount);
        System.out.println("Attendance Percentage : " + percentage + "%");

        if (percentage >= 75) {
            System.out.println("Eligible for Exam");
        } else {
            System.out.println("Not Eligible");
        }

        sc.close();
    }
}