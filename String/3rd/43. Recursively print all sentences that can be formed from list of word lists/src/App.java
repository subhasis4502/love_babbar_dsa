import java.util.Scanner;

public class App {
    static String[] res;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[][] str = { { "you", "we", "" }, { "have", "are", "" }, { "sleep", "eat", "drink" } };
        res = new String[str.length * str[0].length];
        print(str);
        sc.close();
    }

    private static void printUtil(String[][] str, int m, int n) {
        res[m] = str[m][n]; // Add current word to output array

        // If this is last word of
        if (m == str.length - 1) {
            for (int i = 0; i < str.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
            return;
        }

        // Recur for next row
        for (int i = 0; i < str[0].length; i++)
            if (str[m + 1][i] != "" && m < str[0].length)
                printUtil(str, m + 1, i);
    }

    // Consider all words for first row as starting points and print all sentences
    static void print(String[][] str) {
        for (int i = 0; i < str[0].length; i++)
            if (str[0][i] != "")
                printUtil(str, 0, i);
    }
}
