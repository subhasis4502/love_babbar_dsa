class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class ListNode {
    int data;
    ListNode prev, next;

    ListNode(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);

        treeTraversal(root);
        System.out.println();
        ListNode head = treeToDLL(root);
        listTraversal(head);
    }

    static ListNode dll = null;
    static ListNode dllHead = null;

    private static ListNode treeToDLL(TreeNode root) {
        if (root == null)
            return null;

        treeToDLL(root.left);

        if (dll == null) {
            dll = new ListNode(root.data);
            dllHead = dll;
        } else {
            dll.next = new ListNode(root.data);
            dll = dll.next;
        }

        treeToDLL(root.right);

        return dllHead;
    }

    private static void listTraversal(ListNode head) {
        System.out.print("NULL <- ");
        while (head != null) {
            System.out.print(head.data + " <-> ");
            head = head.next;
        }
        System.out.print("NULL");
    }

    private static void treeTraversal(TreeNode root) {
        if (root == null)
            return;

        treeTraversal(root.left);
        System.out.print(root.data + " ");
        treeTraversal(root.right);
    }
}
