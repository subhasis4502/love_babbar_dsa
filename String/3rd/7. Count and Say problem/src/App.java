import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countAndSay(n));
        sc.close();
    }

    private static String countAndSay(int n) {
        if(n == 1)
            return "1";
        if(n == 2)
            return "11";
        String s = "11";
        for(int i = 3; i<=n; i++){
            String t = "";
            s += "&";
            int c = 1;
            for(int j = 1; j<s.length(); j++){
                if(s.charAt(j) != s.charAt(j-1)){
                    t += Integer.toString(c)+s.charAt(j-1);
                    c = 1;
                }
                else
                    c++;
            }
            s = t;
        }
        return s;
    }
}
