# README - NumberEvenOdd

## ชื่อโปรแกรม
NumberEvenOdd (โปรแกรมนับจำนวนเลขคู่และเลขคี่)

## Input
ผู้ใช้ป้อนข้อมูลจำนวนเต็มทั้งหมด **10 จำนวน**

## Process
1. สร้างอาร์เรย์ `number` ขนาด 10 ช่องสำหรับเก็บตัวเลข
2. สร้างตัวแปร `evenCount` และ `oddCount` เพื่อเก็บจำนวนเลขคู่และเลขคี่
3. ใช้ลูป `for` รับตัวเลขจากผู้ใช้ทีละจำนวนจนครบ 10 จำนวน
4. ตรวจสอบแต่ละตัวเลขด้วยตัวดำเนินการหารเอาเศษ (`%`)
   - ถ้า `number[i] % 2 == 0` ให้เพิ่มค่า `evenCount`
   - หากไม่ใช่ ให้เพิ่มค่า `oddCount`
5. เมื่อรับข้อมูลครบแล้ว แสดงจำนวนเลขคู่และเลขคี่ทั้งหมด

## Output
แสดงผลจำนวนของเลขคู่และเลขคี่

```
Even count = ...
Odd count = ...
```

## วิธีรันโปรแกรม

1. เปิดโปรแกรม Visual Studio Code หรือ IntelliJ IDEA
2. เปิดไฟล์ `NumberEvenOdd.java`
3. Compile โปรแกรม
   ```
   javac NumberEvenOdd.java
   ```
4. Run โปรแกรม
   ```
   java NumberEvenOdd
   ```
5. ป้อนตัวเลขจำนวนเต็ม 10 จำนวนตามที่โปรแกรมร้องขอ

### ตัวอย่างการทำงาน

```
Enter 10 numbers:
Enter number 1: 10
Enter number 2: 5
Enter number 3: 8
Enter number 4: 7
Enter number 5: 12
Enter number 6: 15
Enter number 7: 20
Enter number 8: 3
Enter number 9: 18
Enter number 10: 9

Even count = 5
Odd count = 5
```

## สิ่งที่ได้เรียนรู้
- การรับข้อมูลจากผู้ใช้ด้วย `Scanner`
- การสร้างและใช้งานอาร์เรย์ (`Array`)
- การใช้ลูป `for` เพื่อรับและประมวลผลข้อมูลหลายค่า
- การใช้ตัวดำเนินการหารเอาเศษ (`%`) เพื่อตรวจสอบเลขคู่และเลขคี่
- การนับจำนวนข้อมูลด้วยตัวแปร (`evenCount` และ `oddCount`)
- การแสดงผลด้วย `System.out.println()`
- การปิด `Scanner` ด้วย `sc.close()`