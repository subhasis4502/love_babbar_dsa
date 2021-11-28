import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        kmp(str);
        sc.close();
    }

    private static void kmp(String str) {
        int[] t = new int[str.length()];
        int i=1,j=0;
        
        while(i<str.length()){
            if(str.charAt(i)==str.charAt(j)){
                t[i]=j+1;
                i++;
                j++;
            }
            else{
                // Untill one single match found
                if(j==0)
                    i++;
                else
                    j = t[j-1];
            }
        }
        System.out.println("Longest prefix-suffix: " + str.substring(0, t[t.length-1]));
    }
}
