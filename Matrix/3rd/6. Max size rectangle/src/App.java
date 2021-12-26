/* Ref: https://www.youtube.com/watch?v=oaN9ibZKMpA, https://www.youtube.com/watch?v=0do2734xhnU */

/* 
Test:
I/P - 
6 5
1 1 0 1 1
1 1 1 1 1
0 1 1 1 1
1 1 1 1 1
1 0 1 1 1
1 1 1 1 1

O/P - 
Maximum size of the rectangle: 15
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] mat = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        maxSizeRectangle(mat, row, col);
        sc.close();
    }

    private static void maxSizeRectangle(int[][] mat, int row, int col) {
        int[] arr = mat[0];
        int ans = 0;
        ans = Math.max(ans, maxAreaOfHistogram(arr));
        for(int i = 1; i < row; i++){
            for(int j = 0; j<col; j++){
                if(mat[i][j] == 0)
                    arr[j] = 0;
                else
                    arr[j]++;
            }
            ans = Math.max(ans, maxAreaOfHistogram(arr));
        }
        System.out.println("Maximum size of the rectangle: " + ans);;
    }

    public static int maxAreaOfHistogram(int[] arr) {
        int[] lsi = new int[arr.length]; // Left smaller element index
        Stack<Integer> stl = new Stack<>();
        stl.push(0);
        lsi[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while(stl.size() > 0 && arr[i] < arr[stl.peek()])
                stl.pop();
            if(stl.size() == 0)
                lsi[i] = -1;
            else
                lsi[i] = stl.peek();
            
            stl.push(i);
        }

        int[] rsi = new int[arr.length]; // Right smaller element index 
        Stack<Integer> str = new Stack<>();
        str.push(arr.length-1);
        rsi[arr.length-1] = arr.length;

        for (int i = arr.length-2; i >= 0; i--) {
            while(str.size() > 0 && arr[i] < arr[str.peek()])
                str.pop();
            if(str.size() == 0)
                rsi[i] = arr.length;
            else
                rsi[i] = str.peek();
            
            str.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int area = (rsi[i]-lsi[i]-1)*arr[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
