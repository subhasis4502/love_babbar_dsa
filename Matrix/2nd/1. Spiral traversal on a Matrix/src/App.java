import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static void spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = c-1, top = 0, bottom = r-1, d = 0;
        
        while(left <= right && top <= bottom){
            if(d == 0){
                for(int i = left; i<=right; i++)
                    res.add(matrix[top][i]);
                d++;
                top++;
            } else if(d == 1) {
                for(int i = top; i<=bottom; i++)
                    res.add(matrix[i][right]);
                d++;
                right--;
            } else if(d == 2) {
                for(int i = right; i >= left; i--)
                    res.add(matrix[bottom][i]);
                d++;
                bottom--;
            } else {
                for(int i = bottom; i >= top; i--)
                    res.add(matrix[i][left]);
                d=0;
                left++;
            }
        }
        
        for (int i : res) {
            System.out.print(i + " ");;
        }
    }
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

        spirallyTraverse(mat, row, col);
        sc.close();
    }
}
