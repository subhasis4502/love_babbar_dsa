public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        heapSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(int[] arr, int n) {
        int startIndex = (n / 2) - 1;
        for (int i = startIndex; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if (l < n && arr[l] > arr[smallest])
            smallest = l;

        if (r < n && arr[r] > arr[smallest])
            smallest = r;

        if (smallest != i) {
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;

            heapify(arr, n, smallest);
        }
    }
}
