/* Ref: https://www.youtube.com/watch?v=pJdRJqcq-8M */

/* 
Input:
1 2 3

Output:
Present
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int gap = sc.nextInt();
        int find = sc.nextInt();
        if (inSequence(start, gap, find))
            System.out.println("Present");
        else
            System.out.println("Not Present");
        sc.close();
    }

    public static boolean inSequence(int start, int gap, int find) {
        if (gap == 0) {
            if (start == find)
                return true;
            return false;
        } else {
            if ((find - start) / gap < 0)
                return false;
            else {
                if ((find - start) % gap == 0)
                    return true;
                return false;
            }
        }
    }
}
