/* 
Input:
9 5
1 3 5 5 5 5 67 123 125

Output:
Starting index: 2
Ending index: 5
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        find(arr, x);
        sc.close();
    }

    private static void find(int[] arr, int x) {
        int n = arr.length;
        int i = 0, j = n-1;
        while(i < n && (int)arr[i] != x) i++;
        while(j > 0 && (int)arr[j] != x) j--;
        
        System.out.println("Starting index: "+firstOccurance(arr, n, x));
        System.out.println("Ending index: " + lastOccurance(arr, n, x));
    }

    static int firstOccurance(int arr[], int n, int x) {
        int start = 0;
        int end = n-1;
        int res = -1;
        
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] >= x)
                end = mid-1;
            else
                start = mid+1;
            
            if(arr[mid] == x)
                res = mid;
        }
        
        return res;
    }
    
    static int lastOccurance(int arr[], int n, int x) {
        int start = 0;
        int end = n-1;
        int res = -1;
        
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] <= x)
                start = mid+1;
            else
                end = mid-1;
            
            if(arr[mid] == x)
                res = mid;
        }
        
        return res;
    }
}
