/* Ref: https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/ */

/* 
Test:
I/P - 3 13
GEEKSFORGEEKS
GEEKSQUIZGEEK
IDEQAPRACTICE
GEEKS

O/P - 
Pattern found at 0, 0
Pattern found at 0, 8
Pattern found at 1, 0
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        char[][] hay = new char[row][col];
        for (int i = 0; i < row; i++) {
            String s = sc.nextLine();
            hay[i] = s.toCharArray();
        }
        String str = sc.nextLine();
        searchWord(hay, str);
        sc.close();
    }

    // All 8 direction co-ordinates
    static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void searchWord(char[][] grid, String word) {
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (check(i, j, grid, word))
                    System.out.println("Pattern found at " + i + ", " + j);
    }

    static boolean check(int i, int j, char grid[][], String word) {
        if (grid[i][j] != word.charAt(0))
            return false;
        for (int dir = 0; dir < 8; dir++) {
            int x = dx[dir] + i;
            int y = dy[dir] + j;
            int index = 0;
            for (index = 1; index < word.length(); index++) {
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == word.charAt(index)) {
                    x += dx[dir];
                    y += dy[dir];
                } else
                    break;
            }
            if (index == word.length())
                return true;
        }
        return false;
    }
}
