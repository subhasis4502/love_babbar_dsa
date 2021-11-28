import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        maxSubStr(str);
        sc.close();
    }

    private static void maxSubStr(String str) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);

        for (char c : str.toCharArray()) {
            if(c == '0')
                sum -= 1;
            else
                sum += 1;
            
            if(hash.containsKey(sum)){
                count ++;
                hash.put(sum, hash.get(sum)+1);
            }
            else
                hash.put(sum, 1);
        }
        
        System.out.println("The number of substrings: " + count/2);
    }
}
