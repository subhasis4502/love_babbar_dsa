import java.util.Scanner;

public class App {
    public static void kadensAlgo(int[] arr) {
        long sum = arr[0];
        long bestSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (sum < 0)
                sum = arr[i];
            else
                sum += arr[i];

            bestSum = Math.max(bestSum, sum);
        }
        System.out.println(bestSum);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            kadensAlgo(arr);
        }
        sc.close();
    }
}
