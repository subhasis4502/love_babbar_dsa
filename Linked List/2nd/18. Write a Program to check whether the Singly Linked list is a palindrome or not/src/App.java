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
        head.next.next.next = new Node(2, null);
        head.next.next.next.next = new Node(1, null);

        if(isPalidrome(head))
            System.out.println("This list is a palindrome");
        else
            System.out.println("This list is a palindrome");
    }

    private static boolean isPalidrome(Node head) {
        // Base cases
        if(head == null || head.next == null)
            return true;
            
        // Finding the mid point
        Node slow = head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reversing after the mid
        Node r = reverse(slow.next);

        // Comparing
        while(head != null && r != null){
            if(head.data != r.data)
                return false;
            head = head.next;
            r = r.next;
        }
        return true;
    }    
    
    static Node reverse(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}
