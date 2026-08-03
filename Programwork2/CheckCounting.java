public class CheckCounting {
    // Algorithm 1 : Recursive Counting
    static boolean hasMoreVowelsRecursive(String s) {

        s = s.toLowerCase();
        int[] count = countRecursive(s, 0, 0, 0);
        return count[0] > count[1];
    }

    static int[] countRecursive(String s, int index, int vowels, int consonants) {

        if (index == s.length()) {
            return new int[] { vowels, consonants };
        }

        char ch = s.charAt(index);

        // นับเฉพาะตัวอักษรภาษาอังกฤษ
        if (Character.isLetter(ch)) {

            if ("aeiou".indexOf(ch) != -1) {
                vowels++;
            } else {
                consonants++;
            }
        }
        return countRecursive(s, index + 1, vowels, consonants);
    }

    // Algorithm 2 : Iterative Counting
    static boolean hasMoreVowelsIterative(String s) {

        s = s.toLowerCase();

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // นับเฉพาะตัวอักษรภาษาอังกฤษ
            if (Character.isLetter(ch)) {

                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return vowels > consonants;
    }

    public static void main(String[] args) {

        String s = "education";

        int vowels = 0;
        int consonants = 0;

        // ใช้นับเพื่อแสดงผล
        for (int i = 0; i < s.length(); i++) {

            char ch = Character.toLowerCase(s.charAt(i));

            if (Character.isLetter(ch)) {

                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }

            }

        }

        System.out.println("Input: " + s);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Result: " + hasMoreVowelsIterative(s));

    }

}