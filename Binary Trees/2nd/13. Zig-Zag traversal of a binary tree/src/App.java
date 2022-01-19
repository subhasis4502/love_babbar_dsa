import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        zigzagTraversal(root);
    }

    private static void zigzagTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        q.add(root);
        int flag = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int insPoint = res.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();

                if (flag%2 == 0) {
                    res.add(temp.data);
                } else {
                    res.add(insPoint, temp.data);
                }

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }
            flag++;
        }

        for (int i : res)
            System.out.print(i + " ");
    }
}
