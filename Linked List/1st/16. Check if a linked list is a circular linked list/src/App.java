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
        Node head = new Node(3, null);
        head.next = new Node(5, null);
        head.next.next = new Node(2, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = head;

        if(isCircular(head))
            System.out.println("This is a circular linked list");
        else
            System.out.println("This is not a circular linked list");
    }

    private static boolean isCircular(Node head) {
        Node n = head.next;
        while(n != null){
            if(n == head)
                return true;
            n = n.next;
        }
        return false;
    }
}
