import java.util.*;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        if (isAnagram(root1, root2))
            System.out.println("Anagram");
        else
            System.out.println("Not Anagram");
    }

    private static boolean isAnagram(Node root1, Node root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);

        while (true) {
            int n1 = q1.size();
            int n2 = q2.size();

            if (n1 != n2)
                return false;

            if (n1 == 0)
                break;

            ArrayList<Integer> arr1 = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();

            while (n1 > 0) {
                // Level order traversal
                Node temp1 = q1.remove();
                if (temp1.left != null)
                    q1.add(temp1.left);
                if (temp1.right != null)
                    q1.add(temp1.right);
                n1--;

                Node temp2 = q2.remove();
                if (temp2.left != null)
                    q2.add(temp1.left);
                if (temp2.right != null)
                    q2.add(temp1.right);

                arr1.add(temp1.data);
                arr2.add(temp2.data);
            }

            Collections.sort(arr1);
            Collections.sort(arr2);

            return arr1.equals(arr2);
        }

        return false;
    }
}
