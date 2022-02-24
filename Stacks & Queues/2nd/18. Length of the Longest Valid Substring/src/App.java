/* Ref: https://www.youtube.com/watch?v=G53_EUjUYcQ */

public class App {
    public static void main(String[] args) throws Exception {
        String s = "()(())(";
        findMaxLen(s);
    }

    private static void findMaxLen(String s) {
        int left = 0, right = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                left++;
            else
                right++;

            if (left == right)
                count = Math.max(count, 2 * right);
            else if (right > left)
                left = right = 0;
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                count = Math.max(count, 2 * right);
            else if (left > right)
                left = right = 0;
        }

        System.out.println("Maximum valid parenthesis: " + count);
    }
}
