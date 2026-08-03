public class nanoTime1 {

    // Algorithm 1 : Brute Force
    static boolean findPairBruteForce(int[] a, int k) {

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {

                if (a[i] + a[j] == k) {
                    return true;
                }
            }
        }

        return false;
    }

    // Algorithm 2 : Recursive Two-Pointer
    static boolean findPairRecursive(int[] a, int k, int left, int right) {

        if (left >= right) {
            return false;
        }

        int sum = a[left] + a[right];

        if (sum == k) {
            return true;
        }

        if (sum < k) {
            return findPairRecursive(a, k, left + 1, right);
        }

        return findPairRecursive(a, k, left, right - 1);
    }

    // Binary Search
    static int binarySearch(int[] a, int target, int left, int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (a[mid] == target) {
                return mid;
            }

            if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Algorithm 3 : Binary Search
    static boolean findPairBinarySearch(int[] a, int k) {

        for (int i = 0; i < a.length - 1; i++) {

            int target = k - a[i];

            int index = binarySearch(a, target, i + 1, a.length - 1);

            if (index != -1) {
                return true;
            }
        }

        return false;
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
                data[i] = i + 1;
            }

            int k = data[0] + data[n - 1];

            long total1 = 0;
            long total2 = 0;
            long total3 = 0;

            for (int run = 1; run <= 5; run++) {

                long start = System.nanoTime();
                findPairBruteForce(data, k);
                long end = System.nanoTime();
                total1 += (end - start);

                start = System.nanoTime();
                findPairRecursive(data, k, 0, data.length - 1);
                end = System.nanoTime();
                total2 += (end - start);

                start = System.nanoTime();
                findPairBinarySearch(data, k);
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