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
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node root = new Node(5);
        root.left = new Node(6);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(11);

        traversal(root);
        System.out.println();
        minSwapBST(root);
    }

    private static void minSwapBST(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        System.out.println("Minimum swap required: " + swapCount(arr));
    }

    private static int swapCount(ArrayList<Integer> arr) {
        int n = arr.size();
        int ans = 0;
        ArrayList<Pair> arrPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrPos.add(new Pair(arr.get(i), i));
        }
        // Sort the elements to its correct position
        arrPos.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.first - o2.first;
            }
        });
        // Visited array
        int[] vis = new int[n];

        for (int i = 0; i < n; i++) {
            // If already corrected or already in right position
            if (vis[i] == 1 || arrPos.get(i).first == i)
                continue;

            int cycleSize = 0;
            int j = i;
            while (vis[j] == 0) {
                vis[j] = 1;

                j = arrPos.get(j).second;
                cycleSize++;
            }

            if (cycleSize > 0)
                ans += (cycleSize - 1);
        }

        return ans;
    }

    private static void inorder(Node root, ArrayList<Integer> arr) {
        if (root == null)
            return;

        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    private static void traversal(Node root) {
        if (root == null)
            return;

        traversal(root.left);
        System.out.print(root.data + " ");
        traversal(root.right);
    }

}
