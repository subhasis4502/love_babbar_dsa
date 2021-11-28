import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printSequence(str);
        sc.close();
    }

    private static void printSequence(String str) {
        String[] dialPad = {"2","22","222","3","33","333","4","44","444","5","55","555","6","66","666","7","77","777","7777","8","88","888","9","99","999","9999"};

        String res = "";
        for (char c : str.toCharArray()) {
            res += dialPad[c-'A'];
        }
        System.out.println(res);
    }
}
