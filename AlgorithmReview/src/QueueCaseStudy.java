import java.util.LinkedList;
import java.util.Queue;

public class QueueCaseStudy {
    public static void main(String[] args) {
        //ระบบคิวผู้ป่วยในคลินิกสุขภาพ
        //คลินิกสุขภาพแห่งหนึ่งมีผู้ป่วยมาลงทะเบียนรับบริการตามลำดับดังนี้
        //P001, P002, P003, P004, P005
        Queue<String> queue = new LinkedList<>();
        // 1. เพิ่มผู้ป่วย P001 ถึง P005 ลงใน Queue
        queue.offer("P001");
        queue.offer("P002");
        queue.offer("P003");
        queue.offer("P004");
        queue.offer("P005");

        //2.เรียกผู้ป่วยออกจากคิว 2 คน
        System.out.println("ผู้ป่วยที่รับบริการแล้ว: " + queue.remove());
        System.out.println("ผู้ป่วยที่รับบริการแล้ว: " + queue.remove());

        //3. เพิ่มผู้ป่วย P006 และ P007 เข้า Queue
        queue.offer("P006");
        queue.offer("P007");

        //4. แสดงผู้ป่วยคนถัดไปด้วย peek()
        System.out.println("ผู้ป่วยคนถัดไป: " + queue.peek());

        //5. แสดงจำนวนผู้ป่วยที่ยังรออยู่ด้วย size()
        System.out.println("จำนวนผู้ป่วยที่ยังรออยู่: " + queue.size());

        //6. แสดงสถานะของ Queue หลังจากดำเนินการทั้งหมด
        System.out.println("สถานะของ Queue หลังจากดำเนินการทั้งหมด: " + queue);

        //7.ตรวจสอบก่อน remove() ว่า Queue ว่างหรือไม่
        if (!queue.isEmpty()) {
            System.out.println("Queue ไม่ว่าง");
        } else {
            System.out.println("Queue ว่าง");
        }
        //อธิบายว่า Queue ใช้หลักการ FIFO อย่างไร
        System.out.println("อธิบายว่า Queue ใช้หลักการ FIFO อย่างไร: Queue ใช้หลักการ FIFO (First In First Out) หมายความว่าผู้ป่วยที่มาถึงก่อนจะถูกให้บริการก่อน และผู้ป่วยที่มาทีหลังจะต้องรอคิวต่อไป เช่น ถ้าผู้ป่วย P001 มาถึงก่อน P002 ดังนั้น P001 จะได้รับบริการก่อน P002 และถ้าผู้ป่วย P003 มาถึงหลัง P002 ดังนั้น P003 จะต้องรอคิวต่อไปจนกว่าผู้ป่วย P001 และ P002 จะได้รับบริการเสร็จสิ้น");
    }
}