import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("After removing consecutive characters: "+removeConsecutiveCharacter(str));
        sc.close();
    }

    public static String removeConsecutiveCharacter(String S){
        if(S.length() == 1)
            return S;
        char c = S.charAt(0);
        String next = S.substring(1);
        String res = removeConsecutiveCharacter(next);
        if(res.charAt(0) == c)
            return res;
        else
            return c+res;
    }
}
