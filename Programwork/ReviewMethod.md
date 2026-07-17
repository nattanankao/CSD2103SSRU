# README - ReviewMethod

## ชื่อโปรแกรม
ReviewMethod (โปรแกรมหาค่ามากที่สุดโดยใช้ Method)

## Input
ผู้ใช้ป้อนข้อมูลจำนวนเต็ม 2 ค่า ได้แก่
- Number 1
- Number 2

## Process
1. รับค่าตัวเลขจำนวนเต็ม 2 จำนวนจากผู้ใช้
2. เรียกใช้เมธอด `findMax(int a, int b)` เพื่อเปรียบเทียบตัวเลขทั้งสอง
3. ภายในเมธอด
   - หาก `a > b` ให้คืนค่า (`return`) ตัวเลข `a`
   - หากไม่ใช่ ให้คืนค่า (`return`) ตัวเลข `b`
4. เก็บค่าที่คืนกลับไว้ในตัวแปร `maximum`
5. แสดงค่าตัวเลขที่มากที่สุด

## Output
แสดงผลค่าตัวเลขที่มากที่สุด

```
Maximum number = ...
```

## วิธีรันโปรแกรม

1. เปิดโปรแกรม Visual Studio Code หรือ IntelliJ IDEA
2. เปิดไฟล์ `ReviewMethod.java`
3. Compile โปรแกรม
   ```
   javac ReviewMethod.java
   ```
4. Run โปรแกรม
   ```
   java ReviewMethod
   ```
5. ป้อนตัวเลขจำนวนเต็ม 2 จำนวน

### ตัวอย่างการทำงาน

ตัวอย่างที่ 1

```
Enter number 1: 25
Enter number 2: 40
Maximum number = 40
```

ตัวอย่างที่ 2

```
Enter number 1: 90
Enter number 2: 55
Maximum number = 90
```

## สิ่งที่ได้เรียนรู้
- การสร้างและเรียกใช้งาน **Method**
- การส่งค่าพารามิเตอร์ (Parameters) เข้าไปในเมธอด
- การคืนค่าจากเมธอดด้วย `return`
- การใช้คำสั่ง `if-else` เพื่อเปรียบเทียบข้อมูล
- การรับข้อมูลจากผู้ใช้ด้วย `Scanner`
- การแสดงผลด้วย `System.out.println()`
- การปิด `Scanner` ด้วย `sc.close()`