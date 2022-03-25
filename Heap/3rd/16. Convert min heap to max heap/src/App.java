public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 3, 5, 9, 6, 8, 20, 10, 12, 18, 9 };
        display(arr);
        System.out.println();
        convertMaxHeap(arr);
        display(arr);
    }

    private static void convertMaxHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    private static void heapify(int[] arr, int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;

        if (l < n && arr[l] > arr[i])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if(i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, n);
        }
    }

    private static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
