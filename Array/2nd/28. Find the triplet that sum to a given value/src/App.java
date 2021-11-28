import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            find3Numbers(arr, x);
        }
        sc.close();
    }

    private static void find3Numbers(int[] arr, int x) {
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n-2; i++) {
            int j = i+1;
            int k = n-1;

            while(j != k){
                if(arr[i]+arr[j]+arr[k] > x) k--;
                else if(arr[i]+arr[j]+arr[k] < x) j++;
                else {
                    System.out.println("The combination of " + arr[i] + ", " + arr[j] + ", " + arr[k] + " is " + x);
                    j++;
                }
            }
        }
    }
}
