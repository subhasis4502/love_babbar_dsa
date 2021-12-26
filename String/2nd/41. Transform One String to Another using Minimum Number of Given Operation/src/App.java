import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int res = minOps(str1, str2);
        if (res == -1)
            System.out.println("Not possible");
        else
            System.out.println("Minimum no. of operation require: " + res);
        sc.close();
    }

    private static int minOps(String str1, String str2) {
        if (str1.length() != str2.length())
            return -1;

        int count[] = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }

        for(int i = 0; i < 256; i++)
            if(count[i] != 0)
                return -1;

        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int res = 0;

        while (i >= 0) {
            if (str1.charAt(i) != str2.charAt(j)) {
                res++;
                j--;
            }
            i--;
        }
        return res;
    }
}
