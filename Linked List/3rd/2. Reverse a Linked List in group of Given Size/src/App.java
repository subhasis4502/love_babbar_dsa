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
        head.next.next.next.next = new Node(5, null);
        head.next.next.next.next.next = new Node(6, null);
        head.next.next.next.next.next.next = new Node(7, null);

        traverse(head);
        head = kReverse(head, 3);
        System.out.println();
        traverse(head);
    }

    private static Node kReverse(Node node, int k) {
        Node pre=null;
		Node next=null;
		Node curr= node;
		int count= 0;
		
		while(count<k && curr!=null) {
			next=curr.next;
			curr.next=pre;
			pre=curr;
			curr=next;
			count++;
		}
		
		if(next!=null) 
			node.next = kReverse(next, k);
		
		return pre;
    }

    private static void traverse(Node head) {
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("NULL");
    }
}
