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

            rearrange(arr);
        }
        sc.close();
    }

    private static void rearrange(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n-1;

        // Separating the positive and negative number
        while(i < j){
            if(arr[i] > 0)
                i++;
            else if(arr[j] < 0)
                j--;

            if(arr[i] < 0 && arr[j] > 0){
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Placing them alternatively
        int pos = 0;
        int neg = i;

        while(pos < n && neg < n){
            swap(arr, pos, neg);
            pos += 2;
            neg ++;
        }

        for (int k : arr) {
            System.out.print(k + " ");
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
