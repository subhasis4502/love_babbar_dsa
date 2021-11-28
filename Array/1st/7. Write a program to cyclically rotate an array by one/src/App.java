import java.util.Scanner;

public class App {
    public static void rotateLeft(int[] arr) {
        int temp = arr[0];
        for(int i = 0; i<arr.length-1; i++)
            arr[i] = arr[i+1];
        
        arr[arr.length -1] = temp;

        System.out.print("After left rotation: ");
        for(int i : arr)
            System.out.print(i + " ");
    }

    public static void rotateRight(int[] arr) {
        int temp = arr[arr.length-1];
        for(int i = arr.length-2; i>=0; i--)
            arr[i+1] = arr[i];
        arr[0] = temp;

        System.out.print("\nAfter right rotation: ");
        for(int i : arr)
            System.out.print(i + " ");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            //rotateLeft(arr);
            rotateRight(arr);
        }
        sc.close();
    }
}
