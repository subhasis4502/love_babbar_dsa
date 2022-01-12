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
        head.next.next = new Node(2, null);
        head.next.next.next = new Node(1, null);
        head.next.next.next.next = new Node(2, null);
        head.next.next.next.next.next = new Node(0, null);
        head.next.next.next.next.next.next = new Node(2, null);

        traverse(head);
        head = sort012(head);
        System.out.println();
        traverse(head);
    }

    private static Node sort012(Node head) {
        int[] count = new int[3];
        Node n = head;
        while(n!=null){
            count[n.data]++;
            n=n.next;
        }

        Node res = null;
        Node resHead = null;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                if(res == null){
                    res = new Node(i, null);
                    resHead = res;
                } else {
                    res.next = new Node(i, null);
                    res = res.next;
                }
            }
        }
        return resHead;
    }

    private static void traverse(Node head) {
        while(head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("NULL");
    }
}
