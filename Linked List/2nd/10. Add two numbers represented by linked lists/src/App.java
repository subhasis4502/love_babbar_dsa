/* Ref: https://www.youtube.com/watch?v=LBVsXSMOIk4 */

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
        Node head1 = new Node(2, null);
        head1.next = new Node(4, null);
        head1.next.next = new Node(3, null);
        
        Node head2 = new Node(5, null);
        head2.next = new Node(6, null);
        head2.next.next = new Node(7, null);
        head2.next.next.next = new Node(9, null);

        Node sum = add(head1, head2);
        traverse(sum);
    }

    private static Node add(Node head1, Node head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node res = null;
        Node resHead = null;
        int carry = 0;

        while(head1 != null || head2 != null || carry == 1){
            int sum = 0;
            if(head1 != null){
                sum += head1.data;
                head1 = head1.next;
            }

            if(head2 != null){
                sum += head2.data;
                head2 = head2.next;
            }

            sum += carry;
            carry = sum/10;
            sum = sum%10;

            if(res == null){
                res = new Node(sum, null);
                resHead = res;
            } else {
                res.next = new Node(sum, null);
                res = res.next;
            }
        }

        resHead = reverse(resHead);
        return resHead;
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
    }
}
