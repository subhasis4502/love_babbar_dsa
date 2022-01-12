import java.util.HashMap;

class Node {
    int data;
    Node next, arb;

    public Node(int data) {
        this.data = data;
        next = arb = null;

    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head.arb = node3;
        node2.arb = head;
        node3.arb = node5;
        node4.arb = node3;
        node5.arb = node2;

        traverse(head);
        System.out.println();
        head = copyList(head);
        traverse(head);

    }

    private static Node copyList(Node head) {
        HashMap<Node, Node> hash = new HashMap<>();
        Node res = null;
        Node resHead = null;

        Node n = head;
        while (n != null) {
            hash.put(n, n.arb);
            if(res == null){
                res = new Node(n.data);
                resHead = res;
            } else {
                res.next = new Node(n.data);
                res = res.next;
            }
            n = n.next;
        }

        res = resHead;
        for(Node node : hash.keySet()){
            res.arb = hash.get(node);
            res = res.next;
        }
        return resHead;
    }

    private static void traverse(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("NULL");
    }
}
