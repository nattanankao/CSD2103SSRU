import java.util.Scanner;

public class ReviewMethod {

    public static int findMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int number1 = sc.nextInt();

        System.out.print("Enter number 2: ");
        int number2 = sc.nextInt();

        int maximum = findMax(number1, number2);

        System.out.println("Maximum number = " + maximum);

        sc.close();
    }
}