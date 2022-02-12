import java.util.*;

public class App {
    static ArrayList<String> res;

    public static void main(String[] args) throws Exception {
        String str = "ABSG";
        res = new ArrayList<>();
        permutation(str, "");
        Collections.sort(res);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }

    private static void permutation(String str, String asf) {
        if (str.length() == 0) {
            res.add(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            permutation(left + right, asf + c);
        }
    }
}
