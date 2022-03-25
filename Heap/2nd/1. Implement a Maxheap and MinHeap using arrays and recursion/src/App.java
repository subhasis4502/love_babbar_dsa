public class App {
    public static void main(String[] args) throws Exception {
        int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };

        buildMaxHeap(arr, arr.length);
        printHeap(arr, arr.length);

        buildMinHeap(arr, arr.length);
        printHeap(arr, arr.length);
    }

    private static void printHeap(int[] arr, int n) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void buildMaxHeap(int[] arr, int n) {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        for (int i = startIdx; i >= 0; i--) {
            heapifyMax(arr, n, i);
        }
    }

    private static void heapifyMax(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left node
        int r = 2 * i + 2; // right node

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Putting the largest into root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapifyMax(arr, n, largest);
        }
    }

    private static void buildMinHeap(int[] arr, int n) {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        for (int i = startIdx; i >= 0; i--) {
            heapifyMin(arr, n, i);
        }
    }

    private static void heapifyMin(int[] arr, int n, int i) {
        int smallest = i; // Initialize largest as root
        int l = 2 * i + 1; // left node
        int r = 2 * i + 2; // right node

        // If left child is larger than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;

        // Putting the smallest into root
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // Recursively heapify the affected sub-tree
            heapifyMin(arr, n, smallest);
        }
    }
}
