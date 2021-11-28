/* Ref: https://www.youtube.com/watch?v=FyJmnhqATko */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr1 = new int[size];
            int[] arr2 = new int[size];

            for (int i = 0; i < size; i++)
                arr1[i] = sc.nextInt();

            for (int i = 0; i < size; i++)
                arr2[i] = sc.nextInt();

            sortedMedian(arr1, arr2);
        }
        sc.close();
    }

    private static void sortedMedian(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int count = 0;
        int i = 0, j = 0;

        while(i <= arr1.length && j <= arr2.length && count < n){
            if(arr1[i] <= arr2[j])
                i++;
            else
                j++;
            count++;
        }

        int mean = 0;
        if(n%2 == 0)
            mean = ((arr1[i] + arr2[j-1])/2);
        else
            mean = ((arr1[i-1] + arr2[j])/2);

        System.out.println("The median is " + mean);
    }
}
