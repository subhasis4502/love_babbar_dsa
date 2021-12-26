/* Ref: https://www.youtube.com/watch?v=1ZGJzvkcLsA */

/* 
Test:
I/P - 4 4
      0 1 1 1 0 0 1 1 1 1 1 1 0 0 0 0 
O/P - 2
*/

import java.util.Scanner;

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

        rowWithMax1s(mat, row, col);
        sc.close();
    }

    private static void rowWithMax1s(int[][] mat, int row, int col) {
        int maxCount = 0;
        int res = -1;
        for(int i = 0; i<row; i++){
            int count = 0;
            for(int j = 0; j<col; j++){
                if(mat[i][j] == 1)
                    count++;
            }
            
            if(maxCount < count){
                maxCount = count;
                res = i;
            }
        }
        
        System.out.println("Max no. of 1 is present in row " + (res+1));
    }

}
