import java.util.Scanner;

public class App {
    public static void moveNegative(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 && i != j) {
                swap(arr, i, j);
                j++;
            }
        }

        for (int in : arr) {
            System.out.print(in + " ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            moveNegative(arr);
        }
        sc.close();
    }
}
