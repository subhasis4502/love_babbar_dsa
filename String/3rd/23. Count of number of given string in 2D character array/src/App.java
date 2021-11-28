import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        char[][] hay = new char[size][size];
        for (int i = 0; i < size; i++) {
            String s = sc.nextLine();
            hay[i] = s.toCharArray();
        }
        String str = sc.nextLine();
        searchString(str, hay);
        sc.close();
    }

    private static void searchString(String str, char[][] hay) {
        int res = 0;
        int size = str.length();
        for (int i = 0; i < hay[0].length; i++) {
            for (int j = 0; j < hay.length; j++) {
                res += solve(i, j, str, hay, size, 0);
            }
        }
        System.out.println(str + " appeared for " + res + " times.");
    }

    private static int solve(int i, int j, String str, char[][] hay, int size, int k) {
        int found = 0;
        if (i >= 0 && j >= 0 && i < hay.length && j < hay.length && str.charAt(k) == hay[i][j]) {
            char temp = str.charAt(k);
            hay[i][j] = 0;
            k++;
            if (k == size)
                found = 1;
            else {
                // Searching in all direction
                found += solve(i + 1, j, str, hay, size, k);
                found += solve(i - 1, j, str, hay, size, k);
                found += solve(i, j + 1, str, hay, size, k);
                found += solve(i, j - 1, str, hay, size, k);
            }
            hay[i][j] = temp; // Backtracking
        }
        return found;
    }
}
