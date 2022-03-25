import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {6, 8, 4, 5, 2, 3};
        minSum(arr);
    }

    private static void minSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
            
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for(int i = n-1, j = n-2; i>=0 && j>=0; i-=2, j-=2){
            carry += arr[i]+arr[j];
            if(carry == 0)
                break;
            res.append(carry%10);
            carry /= 10;
        }
        
        if(n%2 !=0)
            carry += arr[0];
        if(carry > 0)
            res.append(carry%10);
        if(carry > 9)
            res.append(carry/10);
        res.reverse();
        
        System.out.println(res);
    }
}
