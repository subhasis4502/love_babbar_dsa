/* 
Input:
10 20
3
1
5
12

Output:
1th smallest element: 10
5th smallest element: 14
Not possible
*/


import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        int noValues = sc.nextInt();
        int[] values = new int[noValues];
        for (int i = 0; i < noValues; i++) {
            values[i] = sc.nextInt();
        }
        for (int i = 0; i < noValues; i++) {
            kthSmallest(low, high, values[i]);
        }
        sc.close();
    }

    private static void kthSmallest(int low, int high, int k) {
        if(high-low+1 < k)
            System.out.println("Not possible");
        else
            System.out.println(k + "th smallest element: " + (low+k-1));
    }
}
