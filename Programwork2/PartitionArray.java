import java.util.Arrays;

public class PartitionArray {

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

        int[] input = {12,4,7,15,3,10,8};
        int k = 8;

        int[] recursive = input.clone();
        int[] iterative = input.clone();
        int[] sorting = input.clone();

        partitionRecursive(recursive, k, 0, recursive.length - 1);
        partitionIterative(iterative, k);
        int partitionIndex = partitionBySorting(sorting, k);

        System.out.println("A = " + arrayToString(input));
        System.out.println("k = " + k);

        System.out.println();

        System.out.println("Recursive Partition:");
        System.out.println(arrayToString(recursive));

        System.out.println("Iterative Partition:");
        System.out.println(arrayToString(iterative));

        System.out.println("Sorting-Based Algorithm:");
        System.out.println(arrayToString(sorting));
        System.out.println("Partition Index = " + partitionIndex);

    }
}