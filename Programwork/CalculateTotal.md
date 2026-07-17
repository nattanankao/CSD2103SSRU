# README - CalculateTotal

## ชื่อโปรแกรม
CalculateTotal (โปรแกรมคำนวณคะแนนรวมและตรวจสอบผลสอบ)

## Input
ผู้ใช้ป้อนข้อมูลจำนวนเต็ม 2 ค่า ได้แก่
- คะแนนสอบกลางภาค (Midterm Score)
- คะแนนสอบปลายภาค (Final Score)

## Process
1. รับค่าคะแนนกลางภาคจากผู้ใช้
2. รับค่าคะแนนปลายภาคจากผู้ใช้
3. คำนวณคะแนนรวม
   ```
   totalScore = midtermScore + finalScore
   ```
4. ตรวจสอบคะแนนรวม
   - ถ้าคะแนนรวมตั้งแต่ 50 คะแนนขึ้นไป แสดง "Pass"
   - ถ้าคะแนนรวมน้อยกว่า 50 คะแนน แสดง "Fail"

## Output
- แสดงคะแนนรวม (Total score)
- แสดงผลการสอบ
  - Pass
  - Fail

## วิธีรันโปรแกรม

1. เปิดโปรแกรม Visual Studio Code หรือ IntelliJ IDEA
2. เปิดไฟล์ `CalculateTotal.java`
3. Compile โปรแกรม
   ```
   javac CalculateTotal.java
   ```
4. Run โปรแกรม
   ```
   java CalculateTotal
   ```
5. ป้อนคะแนนกลางภาคและคะแนนปลายภาคตามที่โปรแกรมร้องขอ

### ตัวอย่างการทำงาน

```
Enter midterm score: 25
Enter final score: 30
Total score = 55
Pass
```

อีกตัวอย่าง

```
Enter midterm score: 20
Enter final score: 25
Total score = 45
Fail
```

## สิ่งที่ได้เรียนรู้
- การรับข้อมูลจากผู้ใช้ด้วย `Scanner`
- การใช้ตัวแปรชนิด `int`
- การคำนวณผลรวมของข้อมูล
- การใช้คำสั่ง `if-else` เพื่อตรวจสอบเงื่อนไข
- การแสดงผลข้อมูลด้วย `System.out.println()`
- การปิดการใช้งาน `Scanner` ด้วย `sc.close()`