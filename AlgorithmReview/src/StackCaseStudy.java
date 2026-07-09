import java.util.Stack;

public class StackCaseStudy {
    public static void main(String[] args) {
        //ให้นักศึกษาเขียนโปรแกรม Java โดยใช้ Stack<String> 
        Stack<String> stack = new Stack<>();
        //1. เพิ่มคำสั่งทั้งหมดลงใน Stack
        //ลำดับคำสั่งที่ผู้ใช้ทำคือ
        //Type Data
        //Type Structure
        //Delete Structure
        //Type Algorithm
        //Type Java
        stack.push("Type Data");
        stack.push("Type Structure");
        stack.push("Delete Structure");
        stack.push("Type Algorithm");
        stack.push("Type Java");

        //2. แสดงคำสั่งทั้งหมดใน Stack
        System.out.println(stack);

        //3. Undo คำสั่งล่าสุด 2 ครั้ง
        String undo1 = stack.pop();
        String undo2 = stack.pop();
        //4. แสดงคำสั่งที่ถูก Undo
        System.out.println("Undo 1: " + undo1);
        System.out.println("Undo 2: " + undo2);

        //5. แสดงสถานะของ Stack หลังจาก Undo
        System.out.println("สถานะของ Stack หลังจาก Undo: " + stack);
        
        //6. ตรวจสอบก่อน pop() ว่า Stack ว่างหรือไม่
        if (!stack.isEmpty()) {
            System.out.println("Stack ไม่ว่าง");
        } else {
            System.out.println("Stack ว่าง");
        }

        //7.อธิบายว่า Stack ใช้หลักการ LIFO อย่างไร
        System.out.println("อธิบายว่า Stack ใช้หลักการ LIFO อย่างไร : Stack ใช้หลักการ LIFO (Last In, First Out) คือ คำสั่งที่ถูกเพิ่มเข้ามาล่าสุดจะถูกนำออกไปก่อน คำสั่งที่ถูกเพิ่มเข้ามาก่อนจะถูกนำออกไปทีหลัง ถ้าเรามีคำสั่ง A, B, C ถูกเพิ่มเข้ามาใน Stack ตามลำดับ เมื่อเราทำการ pop() คำสั่ง C จะถูกนำออกไปก่อน จากนั้นคำสั่ง B และสุดท้ายคำสั่ง A จะถูกนำออกไปทีหลัง");
    }
}
