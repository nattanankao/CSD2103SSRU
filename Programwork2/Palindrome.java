public class Palindrome {

    // ปรับข้อความให้เป็นตัวพิมพ์เล็ก และลบช่องว่าง/เครื่องหมาย
    static String normalize(String s) {
        return s.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // Algorithm 1 : Reverse and Compare
    static boolean isPalindromeByReverse(String s) {
        s = normalize(s);

        StringBuilder reverse = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            reverse.append(s.charAt(i));
        }

        return s.equals(reverse.toString());
    }

    // Algorithm 2 : Recursive Two-Pointer
    static boolean isPalindromeRecursive(String s, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindromeRecursive(s, left + 1, right - 1);
    }

    public static void main(String[] args) {

        String[] test = {
            "racecar",
            "level",
            "algorithm",
            "gohangasalamiimalasagnahog"
        };

        for (String s : test) {
            String clean = normalize(s);
            boolean result = isPalindromeRecursive(clean, 0, clean.length() - 1);
            System.out.println(s + " -> " + result);
        }

        // ทดสอบเงื่อนไขเพิ่มเติม
        String extra = "A man, a plan, a canal: Panama";
        String clean = normalize(extra);

        System.out.println();
        System.out.println("Additional Test");
        System.out.println(extra + " -> "
                + isPalindromeRecursive(clean, 0, clean.length() - 1));
    }
}