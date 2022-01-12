class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(4);
        head2.next = new Node(5);

        Node head3 = new Node(5);
        head3.next = new Node(6);

        Node head4 = new Node(7);
        head4.next = new Node(8);

        Node[] arr = { head1, head2, head3, head4 };
        Node head = mergeKNode(arr, arr.length);
        traverse(head);
    }

    private static Node mergeKNode(Node[] arr, int k) {
        if (k == 1)
            return arr[0];

        Node res = merge(arr[k - 2], arr[k - 1]);
        for (int i = 0; i < k - 2; i++) {
            res = merge(arr[i], res);
        }
        return res;
    }

    static Node merge(Node a, Node b) {
        Node res = new Node(0);
        Node resHead = res;

        while (a != null && b != null) {
            if(a.data < b.data){
                res.next = new Node(a.data);
                res = res.next;
                a = a.next;
            } else {
                res.next = new Node(b.data);
                res = res.next;
                b = b.next;
            }
        }

        if(a!=null) res.next = a;
        else res.next = b;

        return resHead.next;
    }

    private static void traverse(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("NULL");
    }
}
