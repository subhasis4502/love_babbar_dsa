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
        int[] arr = new int[col];
        for (int i = 0; i < col; i++)
            arr[i] = mat[0][i];
        
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
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int area = 0;
        for (int i = 0; i <= arr.length; i++) {
            int val = (i == arr.length) ? 0 : arr[i];
            while (st.peek() != -1 && val <= arr[st.peek()]) {
                int rb = i;
                int currVal = arr[st.pop()];
                int lb = st.peek();
                area = Math.max(area, currVal * (rb - lb - 1));
            }
            st.push(i);
        }
        return area;
    }
}
