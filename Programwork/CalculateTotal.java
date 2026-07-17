import java.util.Scanner;

public class CalculateTotal {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter midterm score: ");
        int midtermScore = sc.nextInt();

        System.out.print("Enter final score: ");
        int finalScore = sc.nextInt();

        int totalScore = midtermScore + finalScore;

        System.out.println("Total score = " + totalScore);

        if (totalScore >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        sc.close();
    }
}
