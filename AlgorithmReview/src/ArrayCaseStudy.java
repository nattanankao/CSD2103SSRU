public class ArrayCaseStudy {
    public static void main(String[] args) {
        //คะแนนของนักศึกษา 10 คน
        int[] scores = {6, 8, 4, 9, 7, 5, 10, 3, 8, 2};

        //สิ่งที่ต้องทำ
        //ให้นักศึกษาเขียนโปรแกรม Java เพื่อแสดงข้อมูลต่อไปนี้
        //1. คะแนนรวมของนักศึกษาทั้งหมด
        //2. คะแนนเฉลี่ย
        //3. คะแนนสูงสุด
        //4. คะแนนต่ำสุด
        //5. จำนวนนักศึกษาที่ได้คะแนนตั้งแต่ 7 คะแนนขึ้นไป
        //6. รายชื่อนักศึกษาที่ควรได้รับการทบทวนเพิ่มเติม คือ นักศึกษาที่ได้คะแนนต่ำกว่า 5
        int sum = 0;
        int max = scores[0];
        int min = scores[0];
        int count = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];

            if (scores[i] > max) {
                max = scores[i];
            }

            if (scores[i] < min) {
                min = scores[i];
            }

            if (scores[i] >= 7) {
                count++;
            }
        }

        double average = (double) sum / scores.length;

        System.out.println("คะแนนรวมของนักศึกษาทั้งหมด = " + sum);
        System.out.println("คะแนนเฉลี่ย = " + average);
        System.out.println("คะแนนสูงสุด = " + max);
        System.out.println("คะแนนต่ำสุด = " + min);
        System.out.println("จำนวนนักศึกษาที่ได้คะแนนตั้งแต่ 7 คะแนนขึ้นไป = " + count);

        System.out.println("รายชื่อนักศึกษาที่ควรได้รับการทบทวนเพิ่มเติม คือ นักศึกษาที่ได้คะแนนต่ำกว่า 5");

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 5) {
                System.out.println("นักศึกษาคนที่ " + (i + 1) + " ได้ " + scores[i] + " คะแนน");
            }
        }
    }
}