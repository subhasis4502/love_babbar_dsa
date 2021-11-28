import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(isPailndrome(str))
            System.out.println("The string is palindrome");
        else
            System.out.println("The string is not palindrome");
        sc.close();
    }

    private static boolean isPailndrome(String str) {
        int i = 0, j = str.length()-1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
