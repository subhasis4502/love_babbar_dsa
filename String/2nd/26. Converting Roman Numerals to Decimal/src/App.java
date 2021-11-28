/* Ref: https://www.youtube.com/watch?v=hEhf_oz3wsM */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        romanToDecimal(str.toUpperCase());
        sc.close();
    }

    private static void romanToDecimal(String str) {
        HashMap<Character, Integer> hash = new HashMap<>();
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);
        
        int sum = hash.get(str.charAt(0));
        for(int i = 1; i<str.length(); i++){
            if(hash.get(str.charAt(i-1)) < hash.get(str.charAt(i)))
                sum -= 2*hash.get(str.charAt(i-1));
            sum += hash.get(str.charAt(i));
        }
        System.out.println("The decimal value of '" + str + "' is " + sum);
    }
}
