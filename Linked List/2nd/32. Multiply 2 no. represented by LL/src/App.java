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
        Node head1 = new Node(5, null);
        head1.next = new Node(4, null);
        head1.next.next = new Node(2, null);
        head1.next.next.next = new Node(9, null);
        head1.next.next.next.next = new Node(8, null);

        Node head2 = new Node(1, null);
        head2.next = new Node(2, null);
        head2.next.next = new Node(7, null);
        head2.next.next.next = new Node(0, null);

        traverse(head1);
        System.out.println();
        traverse(head2);
        System.out.println("\nMultiple: " + multiply(head1, head2));
    }

    private static long multiply(Node head1, Node head2) {
        long mod = 1000000007;
        
        Node n1 = head1;
        Node n2 = head2;
        long num1 = 0;
        long num2 = 0;
        
        while(n1!=null){
            num1 = (num1*10+n1.data)%mod;
            n1 = n1.next;
        }
        
        while(n2 != null){
            num2 = (num2*10+n2.data)%mod;
            n2 = n2.next;
        }
        
        return (num1*num2)%mod;
    }

    private static void traverse(Node head) {
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("NULL");
    }
}
