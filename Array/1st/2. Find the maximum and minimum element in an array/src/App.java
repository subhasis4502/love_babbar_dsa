import java.util.Scanner;

public class App {
    public static void findMinmax(int[] arr) {
        int min_val = Integer.MAX_VALUE; 
        int max_val = Integer.MIN_VALUE;

        for(int i : arr){
            if(i < min_val) min_val = i;
            if(i > max_val) max_val = i;
        }
        System.out.println("Min value: " + min_val);
        System.out.println("Max value: " + max_val);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            findMinmax(arr);
        }
        sc.close();
    }
}
