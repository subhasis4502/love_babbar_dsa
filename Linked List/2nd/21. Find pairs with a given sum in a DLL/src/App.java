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

        findPair(head, 7);
    }

    private static void findPair(Node head, int x) {
        Node i = head;
        Node j = head;

        while(j.next != null)
            j = j.next;

        while(i.data < j.data){
            if(i.data + j.data < x)
                i = i.next;
            else if(i.data+j.data > x)
                j = j.prev;
            else{
                System.out.println(i.data + ", " + j.data);
                i = i.next;
            }
        }
    }
}
