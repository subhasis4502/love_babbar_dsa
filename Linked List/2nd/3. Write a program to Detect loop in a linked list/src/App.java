/* Ref: https://www.youtube.com/watch?v=354J83hX7RI */

/* 
Output:
Loop existed
*/

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = head.next;

        if(detectLoop(head)){
            System.out.println("Loop existed");
        } else {
            System.out.println("No loop present");
        }
    }

    public static boolean detectLoop(Node head){
        if(head == null || head.next == null)
            return false;
        
        Node fast = head;
        Node slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
