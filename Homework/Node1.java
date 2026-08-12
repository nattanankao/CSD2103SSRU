package Homework;
public class Node1<T>{
    // เก็บข้อมูล
    public T nodeValue;
    // เก็บ next ยัง node ถัดไป
    public Node1<T> next;
 
 
    public Node1(){
        nodeValue = null;
        next = null; }
    
    public Node1(T Value) {
        nodeValue = Value;
        next = null;
    }
 
    // 1. คำสั่งในการค้นหา node ที่มีค่า value ใน list
    public static Node1<String> search(Node1<String> head, String value) {
        Node1<String> current = head;
        while (current != null) {
            if (current.nodeValue.equals(value)) {
                return current;   // เจอแล้ว คืนค่า node นั้น
            }
            current = current.next;
        }
        return null;   // วิ่งจนสุด list แล้วไม่เจอ
    }
 
    // 2. method ในการนับจำนวน node ใน list
    public static int countNodes(Node1<String> head) {
        int count = 0;
        Node1<String> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
 
    public static void main(String[] args) {
        Node1<String> p = new Node1<>("red");
        Node1<String> q = new Node1<>("green");
        Node1<String> m = new Node1<>("pink");
        Node1<String> n = new Node1<>("yellow");
 
        System.out.println("p: " + p);
        System.out.println("p.nodeValue: " + p.nodeValue);
        System.out.println("p.nextbefore: " + p.next);
        System.out.println("q: " + q);
        System.out.println("q.nodeValue: " + q.nodeValue);
        System.out.println("q.nextbefore: " + q.next);
 
        Node1<String> head= p;
        System.out.println("head: " + head);
 
 
        p.next = q;
        System.out.println("p.next After =  " + p.next);
 
        System.out.println("m: " + m);
        System.out.println("m.nodeValue: " + m.nodeValue);
        System.out.println("m.nextbefore: " + m.next);
 
        q.next = m;
        System.out.println("q.next After =  " + q.next);
 
        Node1<String> tail= m;
        System.out.println("tail: " + tail);
 
        Node1<String> temp = n;
        p.next = temp;
        n.next = q;
 
        System.out.println("p.next After =  " + p.next);
        System.out.println("n.next After =  " + n.next);
 
        //เรียกใช้ method
 
        // 1. ค้นหา node ที่มีค่า blue
        Node1<String> found = search(head, "blue");
        if (found != null) {
            System.out.println("เจอ node: " + found.nodeValue);
        } else {
            System.out.println("ไม่พบ node ที่มีค่า blue");
        }
 
        // 2. นับจำนวน node ทั้งหมดใน list
        int total = countNodes(head);
        System.out.println("จำนวน node ทั้งหมด: " + total);
    }
}
 