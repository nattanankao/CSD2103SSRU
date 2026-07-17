````markdown id="r4m8kd"
# README - MaxNumber

## ชื่อโปรแกรม
MaxNumber (โปรแกรมหาค่าตัวเลขที่มากที่สุด)

## Input
ผู้ใช้ป้อนข้อมูลจำนวนเต็ม 3 ค่า ได้แก่
- Number 1
- Number 2
- Number 3

## Process
1. รับค่าตัวเลขจำนวนเต็ม 3 จำนวนจากผู้ใช้
2. กำหนดให้ตัวเลขตัวแรกเป็นค่ามากที่สุดเริ่มต้น
   ```
   maximum = number1;
   ```
3. เปรียบเทียบ `number2` กับ `maximum`
   - หาก `number2` มากกว่า ให้กำหนด `maximum = number2`
4. เปรียบเทียบ `number3` กับ `maximum`
   - หาก `number3` มากกว่า ให้กำหนด `maximum = number3`
5. แสดงค่าที่มากที่สุด

## Output
แสดงผลค่าตัวเลขที่มากที่สุด

```
Maximum number = ...
```

## วิธีรันโปรแกรม

1. เปิดโปรแกรม Visual Studio Code หรือ IntelliJ IDEA
2. เปิดไฟล์ `MaxNumber.java`
3. Compile โปรแกรม
   ```
   javac MaxNumber.java
   ```
4. Run โปรแกรม
   ```
   java MaxNumber
   ```
5. ป้อนตัวเลขจำนวนเต็ม 3 จำนวน

### ตัวอย่างการทำงาน

ตัวอย่างที่ 1

```
Enter number 1: 15
Enter number 2: 30
Enter number 3: 22
Maximum number = 30
```

ตัวอย่างที่ 2

```
Enter number 1: 50
Enter number 2: 18
Enter number 3: 45
Maximum number = 50
```

## สิ่งที่ได้เรียนรู้
- การรับข้อมูลจากผู้ใช้ด้วย `Scanner`
- การใช้ตัวแปรชนิด `int`
- การกำหนดค่าเริ่มต้นให้ตัวแปร
- การใช้คำสั่ง `if` เพื่อเปรียบเทียบค่าตัวเลข
- การหาค่าสูงสุด (Maximum) จากข้อมูลหลายค่า
- การแสดงผลด้วย `System.out.println()`
- การปิด `Scanner` ด้วย `sc.close()`
````
