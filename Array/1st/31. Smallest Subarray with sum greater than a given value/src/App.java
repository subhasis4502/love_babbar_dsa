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

            smallestSubArray(arr, x);
        }
        sc.close();
    }

    private static void smallestSubArray(int[] arr, int x) {
        int sum = arr[0];
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 1;

        while (j < arr.length) {
            if(sum > x){
                minLen = Math.min(minLen, j-i);
                sum -= arr[i++];
            }
            else{
                sum += arr[j++];
            }
        }

        if(minLen == Integer.MAX_VALUE)
            System.out.println("Not possible");
        else
            System.out.println("Minimum sub-array of length " + minLen);
    }
}
