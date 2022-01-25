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
        Node root1 = new Node(12);
        root1.left = new Node(9);
        root1.left.left = new Node(6);
        root1.left.right = new Node(11);

        Node root2 = new Node(8);
        root2.left = new Node(5);
        root2.right = new Node(10);
        root2.left.left = new Node(2);

        traverse(root1);
        System.out.println();
        traverse(root2);
        System.out.println();
        Node root = merge(root1, root2);
        traverse(root);
    }

    static ArrayList<Integer> arr1 = new ArrayList<>();
    static ArrayList<Integer> arr2 = new ArrayList<>();
    static ArrayList<Integer> arr = new ArrayList<>();

    private static Node merge(Node root1, Node root2) {
        inorder(root1, arr1);
        inorder(root2, arr2);
        mergeArr(arr1, arr2);
        Node root = insert(0, arr.size() - 1);
        return root;
    }

    private static Node insert(int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node n = new Node(arr.get(mid));
        n.left = insert(start, mid - 1);
        n.right = insert(mid + 1, end);
        return n;
    }

    private static void mergeArr(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        int i = 0;
        int j = 0;

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                arr.add(arr1.get(i++));
            } else {
                arr.add(arr2.get(j++));
            }
        }

        while (i < arr1.size())
            arr.add(arr1.get(i++));

        while (j < arr2.size())
            arr.add(arr2.get(j++));
    }

    private static void inorder(Node root, ArrayList<Integer> arr) {
        if (root == null)
            return;
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    private static void traverse(Node root) {
        if (root == null)
            return;

        traverse(root.left);
        System.out.print(root.data + " ");
        traverse(root.right);
    }
}