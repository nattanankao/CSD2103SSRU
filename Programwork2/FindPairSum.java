public class FindPairSum {

    // Algorithm 1 : Brute Force
    static boolean findPairBruteForce(int[] a, int k) {

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {

                if (a[i] + a[j] == k) {
                    System.out.println("Pair found: " + a[i] + " and " + a[j]);
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
            System.out.println("Pair found: " + a[left] + " and " + a[right]);
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
                System.out.println("Pair found: " + a[i] + " and " + a[index]);
                return true;
            }
        }

        return false;
    }

    // แสดง Array แบบไม่มีช่องว่าง
    static String arrayToString(int[] a) {

        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < a.length; i++) {

            sb.append(a[i]);

            if (i < a.length - 1) {
                sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {

        int[] a = {2,4,7,11,15,20};
        int k = 18;

        System.out.println("A = " + arrayToString(a));
        System.out.println("k = " + k);

        System.out.println();

        System.out.println("Brute Force:");
        if (!findPairBruteForce(a, k)) {
            System.out.println("Pair not found");
        }

        System.out.println("Recursive Two-Pointer:");
        if (!findPairRecursive(a, k, 0, a.length - 1)) {
            System.out.println("Pair not found");
        }

        System.out.println("Binary Search:");
        if (!findPairBinarySearch(a, k)) {
            System.out.println("Pair not found");
        }
    }
}