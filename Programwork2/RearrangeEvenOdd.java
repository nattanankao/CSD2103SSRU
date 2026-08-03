public class RearrangeEvenOdd {

    // Algorithm 1 : Recursive Two-Pointer
    static void rearrangeRecursive(int[] a, int left, int right) {

        if (left >= right) {
            return;
        }

        while (left < right && a[left] % 2 == 0) {
            left++;
        }

        while (left < right && a[right] % 2 != 0) {
            right--;
        }

        if (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }

        rearrangeRecursive(a, left, right);
    }

    // Algorithm 2 : Iterative Two-Pointer
    static void rearrangeTwoPointer(int[] a) {

        int left = 0;
        int right = a.length - 1;

        while (left < right) {

            while (left < right && a[left] % 2 == 0) {
                left++;
            }

            while (left < right && a[right] % 2 != 0) {
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

    // Algorithm 3 : Extra Array
    static int[] rearrangeExtraArray(int[] a) {

        int[] result = new int[a.length];
        int index = 0;

        // เก็บจำนวนคู่ก่อน
        for (int value : a) {
            if (value % 2 == 0) {
                result[index++] = value;
            }
        }

        // เก็บจำนวนคี่ทีหลัง
        for (int value : a) {
            if (value % 2 != 0) {
                result[index++] = value;
            }
        }

        return result;
    }

    // แสดงอาร์เรย์แบบไม่มีช่องว่าง
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

        int[] input = {7,2,9,4,1,6,3,8};

        int[] recursive = input.clone();
        int[] iterative = input.clone();
        int[] extra;

        rearrangeRecursive(recursive, 0, recursive.length - 1);
        rearrangeTwoPointer(iterative);
        extra = rearrangeExtraArray(input);

        System.out.println("Input:");
        System.out.println(arrayToString(input));

        System.out.println("Recursive:");
        System.out.println(arrayToString(recursive));

        System.out.println("Iterative:");
        System.out.println(arrayToString(iterative));

        System.out.println("Extra Array:");
        System.out.println(arrayToString(extra));
    }
}