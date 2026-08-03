public class RecursiveAlgorithm {

    // Algorithm 1 : Recursive
    static String reverseRecursive(String s) {
        if (s.length() == 0) {
            return "";
        }

        return s.charAt(s.length() - 1)
                + reverseRecursive(s.substring(0, s.length() - 1));
    }

    // Algorithm 2 : Iterative
    static String reverseIterative(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "pots&pans";

        System.out.println("Original  : " + s);
        System.out.println("Recursive : " + reverseRecursive(s));
        System.out.println("Iterative : " + reverseIterative(s));

    }

}