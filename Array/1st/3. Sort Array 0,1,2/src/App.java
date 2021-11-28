import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void sort012(int[] arr) {
        int zero = 0, one = 0, two = 0;
        for(int i : arr){
            if(i == 0) zero++;
            else if(i == 1) one++;
            else two++;
        }
        for(int i = 0; i < zero; i++) arr[i] = 0;
        for(int i = zero; i < zero+one; i++) arr[i] = 1;
        for(int i = zero+one; i < arr.length; i++) arr[i] = 2;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            sort012(arr);
            for (int i : arr)
                System.out.print(i + " ");
        }
        System.out.println();
        sc.close();
    }
}
