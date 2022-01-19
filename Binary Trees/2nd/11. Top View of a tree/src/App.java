import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair {
    int level;
    Node node;

    Pair(int level, Node node) {
        this.level = level;
        this.node = node;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        topView(root);
    }

    private static void topView(Node root) {
        if (root == null)
            System.out.println("The tree is empty");

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair it = q.poll();
            int level = it.level;
            Node temp = it.node;
            if (map.get(level) == null)
                map.put(level, temp.data);
            if (temp.left != null)
                q.add(new Pair(level - 1, temp.left));

            if (temp.right != null)
                q.add(new Pair(level + 1, temp.right));
        }

        for (int k : map.keySet())
            System.out.print(map.get(k) + " ");
    }
}
