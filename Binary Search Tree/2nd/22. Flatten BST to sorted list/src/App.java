import java.util.ArrayList;

class Node {
    int data;
    Node left, right, next;

    Node(int data) {
        this.data = data;
        left = right = next = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        flatten(root);
        for(int i : res) {
            System.out.print(i + " -> ");
        }
        System.out.print("NULL");
    }

    static ArrayList<Integer> res = new ArrayList<>();
    private static void flatten(Node root) {
        if(root == null)
            return;
        flatten(root.left);

        res.add(root.data);

        flatten(root.right);
    }
}