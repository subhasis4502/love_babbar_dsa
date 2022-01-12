/* 
Input:
hello

Output:
olleh
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        reverseString(str.toCharArray());
        sc.close();
    }

    public static void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while(i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            
            i++;
            j--;
        }

        for (char c : s) {
            System.out.print(c);
        }
    }
}
