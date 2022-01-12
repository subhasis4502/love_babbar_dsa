import java.util.Scanner;

public class App {
    public static String reverseString(String s){
        char[] str = s.toCharArray();
        s = "";
        int i = 0;
        int j = str.length-1;
        while(i < j){
            swap(str, i, j);
            i++;
            j--;
        }
        return String.valueOf(str);
    }
    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            s = reverseString(s);
            System.out.println(s);
        }
        sc.close();
    }
}
