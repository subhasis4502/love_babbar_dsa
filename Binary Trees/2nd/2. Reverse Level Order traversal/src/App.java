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

        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.poll();
            res.add(n.data);

            if (n.right != null)
                q.add(n.right);

            if (n.left != null)
                q.add(n.left);
        }

        Collections.reverse(res);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
