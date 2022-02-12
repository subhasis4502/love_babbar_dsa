/* Ref: https://www.youtube.com/watch?v=5crucASFoA4 */

public class App {
    public static void main(String[] args) throws Exception {
        String str = "3435335";
        int k = 3;
        findMaximumNum(str.toCharArray(), k);
        System.out.println(max);
    }

    static String max = "0";

    private static void findMaximumNum(char[] str, int k) {
        if (new String(str).compareTo(max) > 0)
            max = new String(str);

        if (k == 0)
            return;

        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[j] > str[i]) {
                    swap(str, i, j);
                    findMaximumNum(str, k - 1);
                    swap(str, i, j);
                }
            }
        }
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
