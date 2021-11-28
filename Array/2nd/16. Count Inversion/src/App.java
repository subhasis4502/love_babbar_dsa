/* Ref: https://www.youtube.com/watch?v=uojx--MK_n0&t=267s */

import java.util.Scanner;

public class App {
    static int count = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            countInversion(arr);
            System.out.println("Number of inversion: " + count);
        }
        sc.close();
    }

    private static void countInversion(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private static int[] mergeSort(int[] arr, int low, int high) {
        if(low == high){
            int[] a = {arr[low]};
            return a;
        }
        int mid = (low+high)/2;
        int[] li = mergeSort(arr, low, mid);
        int[] hi = mergeSort(arr, mid+1, high);

        return merged(li, hi);
    }

    private static int[] merged(int[] li, int[] hi) {
        int i = 0;
        int j = 0;
        int k = 0;
        
        int[] merArr = new int[li.length+hi.length];
        
        while(i < li.length && j < hi.length){
            if(li[i] > hi[j]){
                count += (li.length - i);
                merArr[k++] = hi[j++];
            }
            else
                merArr[k++] = li[i++];
            
        }
        
        while(i < li.length)
            merArr[k++] = li[i++];
            
        while(j < hi.length)
            merArr[k++] = hi[j++];
            
        return merArr;
    }

}
