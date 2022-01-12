import java.util.HashSet;
import java.util.Set;

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
        Node head = new Node(2, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(2, null);
        head.next.next.next.next = new Node(7, null);

        traverse(head);
        head = removeDuplicate(head);
        System.out.println();
        traverse(head);
    }

    private static Node removeDuplicate(Node head) {
        Set<Integer> hash = new HashSet<>();
        Node n = head;
        Node res = null;
        Node resHead = null;
        
        while (n != null) {
            if(hash.isEmpty() || !hash.contains(n.data)){
                if(resHead == null){
                    res = new Node(n.data, null);
                    resHead = res;
                } else {
                    res.next = new Node(n.data, null);
                    res = res.next;
                }
                hash.add(n.data);
            }
            n = n.next;
        }
        return resHead;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
