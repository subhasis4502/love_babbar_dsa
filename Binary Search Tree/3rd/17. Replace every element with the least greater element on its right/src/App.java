/* Ref: https://www.youtube.com/watch?v=Mo6OOe9KZM0 */

class Node {
    int data;
    Node left, right, next;

    Node(int data) {
        this.data = data;
        left = right = next = null;
    }
}

public class App {
    static Node succ;
    static Node root;

    App() {
        succ = null;
        root = null;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = { 8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28 };
        replace(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void replace(int[] arr) {
        App tree = new App();

        for (int i = arr.length - 1; i >= 0; i--) {
            succ = null;
            root = tree.insert(root, arr[i]);

            if (succ != null)
                arr[i] = succ.data;
            else
                arr[i] = -1;
        }
    }

    Node insert(Node node, int data) {

        if (node == null) {
            node = new Node(data);
        }

        if (data < node.data) {
            succ = node;
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }
}