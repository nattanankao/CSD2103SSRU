import java.util.Arrays;

public class nanoTime2 {

    // Algorithm 1 : Recursive Partition
    static void partitionRecursive(int[] a, int k, int left, int right) {

        if (left >= right) {
            return;
        }

        while (left < right && a[left] <= k) {
            left++;
        }

        while (left < right && a[right] > k) {
            right--;
        }

        if (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            left++;
            right--;
        }

        partitionRecursive(a, k, left, right);
    }

    // Algorithm 2 : Iterative Partition
    static void partitionIterative(int[] a, int k) {

        int left = 0;
        int right = a.length - 1;

        while (left < right) {

            while (left < right && a[left] <= k) {
                left++;
            }

            while (left < right && a[right] > k) {
                right--;
            }

            if (left < right) {

                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;

                left++;
                right--;
            }
        }
    }

    // Algorithm 3 : Sorting-Based Algorithm
    static int partitionBySorting(int[] a, int k) {

        Arrays.sort(a);

        int partitionIndex = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] <= k) {
                partitionIndex = i;
            }
        }

        return partitionIndex;
    }

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-12s %-15s %-15s %-15s%n",
                "Data Size",
                "Algorithm 1",
                "Algorithm 2",
                "Algorithm 3");
        System.out.println("---------------------------------------------------------------");

        for (int n : sizes) {

            int[] data = new int[n];

            for (int i = 0; i < n; i++) {
                data[i] = (int) (Math.random() * 100000);
            }

            int k = 50000;

            long total1 = 0;
            long total2 = 0;
            long total3 = 0;

            for (int run = 1; run <= 5; run++) {

                int[] a1 = data.clone();
                int[] a2 = data.clone();
                int[] a3 = data.clone();

                // Algorithm 1
                long start = System.nanoTime();
                partitionRecursive(a1, k, 0, a1.length - 1);
                long end = System.nanoTime();
                total1 += (end - start);

                // Algorithm 2
                start = System.nanoTime();
                partitionIterative(a2, k);
                end = System.nanoTime();
                total2 += (end - start);

                // Algorithm 3
                start = System.nanoTime();
                partitionBySorting(a3, k);
                end = System.nanoTime();
                total3 += (end - start);
            }

            long avg1 = total1 / 5;
            long avg2 = total2 / 5;
            long avg3 = total3 / 5;

            System.out.printf("%-12d %-15d %-15d %-15d%n",
                    n, avg1, avg2, avg3);
        }

        System.out.println("---------------------------------------------------------------");
    }
}