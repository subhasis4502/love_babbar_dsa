/* 
Input:
10

Output:
Number of squares below 10 is: 3
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        countSquares(n);
        sc.close();
    }

    static void countSquares(int n) {
        System.out.println("Number of squares below " + n + " is: " + (int)Math.sqrt(n-1));
    }
}
