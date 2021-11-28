import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            maxMul(arr);
        }
        sc.close();
    }

    private static void maxMul(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        
        int maxMul = arr[0];
        for(int i = 1; i<arr.length; i++){
            // Swap max,min if negative number appears
            if(arr[i] < 0){
                int temp = min;
                min = max;
                max = temp;
            }
            
            min = Math.min(arr[i], min*arr[i]);
            max = Math.max(arr[i], max*arr[i]);
            
            maxMul = Math.max(maxMul, max);
        }
        System.out.println("Maximum multiply possible: " + maxMul);
    }
}
