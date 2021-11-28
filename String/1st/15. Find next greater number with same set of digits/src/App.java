import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        nextPermutation(arr);
        sc.close();
    }

    private static void nextPermutation(int[] arr) {
        int N = arr.length;
        int i = N-2;
        while(i >= 0 && arr[i] > arr[i+1]) i--;
        
        if(i >= 0){
            int j = N-1;
            while(j >= 0 && arr[j] <= arr[i]) j--;
            swap(arr, i, j);
        }
        reverse(arr, i+1);
        
        for(int n : arr){
            System.out.print(n + " ");
        }
    }

    private static void reverse(int[] arr, int start) {
        int end = arr.length-1;
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
