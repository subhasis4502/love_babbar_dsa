class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(8);
        Node node7 = new Node(9);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        node2.prev = head;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;
        node7.prev = node6;

        findTriplets(head, 11);
    }

    private static void findTriplets(Node head, int x) {
        Node i = head;
        Node tail = head;
        while (tail.next != null)
            tail = tail.next;

        while (i.next.next != null) {
            Node j = i.next;
            Node k = tail;

            while (j.data < k.data) {
                if (i.data + j.data + k.data < x)
                    j = j.next;
                else if (i.data + j.data + k.data > x)
                    k = k.prev;
                else {
                    System.out.println(i.data + " " + j.data + " " + k.data);
                    j = j.next;
                }
            }

            i = i.next;
        }
    }
}
