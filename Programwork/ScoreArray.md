# README - ScoreArray

## ชื่อโปรแกรม
ScoreArray (โปรแกรมคำนวณคะแนนรวมและคะแนนเฉลี่ย)

## Input
ผู้ใช้ป้อนข้อมูลคะแนนจำนวนเต็ม **5 ค่า**

- Score 1
- Score 2
- Score 3
- Score 4
- Score 5

## Process
1. สร้างอาร์เรย์ `score` ขนาด 5 ช่องสำหรับเก็บคะแนน
2. สร้างตัวแปร `total` เพื่อเก็บผลรวมของคะแนน
3. ใช้ลูป `for` รับคะแนนจากผู้ใช้ทีละค่า
4. นำคะแนนแต่ละค่ามาบวกสะสมในตัวแปร `total`
5. คำนวณคะแนนเฉลี่ยด้วยสูตร
   ```
   average = (double) total / score.length;
   ```
6. แสดงผลคะแนนรวมและคะแนนเฉลี่ย

## Output
แสดงผลคะแนนรวมและคะแนนเฉลี่ย

```
Total score = ...
Average score = ...
```

## วิธีรันโปรแกรม

1. เปิดโปรแกรม Visual Studio Code หรือ IntelliJ IDEA
2. เปิดไฟล์ `ScoreArray.java`
3. Compile โปรแกรม
   ```
   javac ScoreArray.java
   ```
4. Run โปรแกรม
   ```
   java ScoreArray
   ```
5. ป้อนคะแนนจำนวนเต็ม 5 ค่า

### ตัวอย่างการทำงาน

```
Enter score 1: 80
Enter score 2: 75
Enter score 3: 90
Enter score 4: 85
Enter score 5: 70

Total score = 400
Average score = 80.0
```

## สิ่งที่ได้เรียนรู้
- การรับข้อมูลจากผู้ใช้ด้วย `Scanner`
- การสร้างและใช้งานอาร์เรย์ (`Array`)
- การใช้ลูป `for` เพื่อรับข้อมูลหลายค่า
- การคำนวณผลรวมของข้อมูลด้วยตัวแปรสะสม (`total`)
- การคำนวณค่าเฉลี่ย (`Average`) และการแปลงชนิดข้อมูลเป็น `double`
- การใช้ `score.length` เพื่อหาจำนวนสมาชิกในอาร์เรย์
- การแสดงผลด้วย `System.out.println()`
- การปิด `Scanner` ด้วย `sc.close()`