import java.util.Scanner;

public class NumberEvenOdd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] number = new int[10];
        int evenCount = 0;
        int oddCount = 0;

        System.out.println("Enter 10 numbers:");

        for (int i = 0; i < number.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            number[i] = sc.nextInt();

            if (number[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even count = " + evenCount);
        System.out.println("Odd count = " + oddCount);

        sc.close();
    }
}
