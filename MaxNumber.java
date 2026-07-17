import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int number1 = sc.nextInt();

        System.out.print("Enter number 2: ");
        int number2 = sc.nextInt();

        System.out.print("Enter number 3: ");
        int number3 = sc.nextInt();

        int maximum = number1;

        if (number2 > maximum) {
            maximum = number2;
        }

        if (number3 > maximum) {
            maximum = number3;
        }

        System.out.println("Maximum number = " + maximum);
        sc.close();
    }
}