/* Ref: https://www.youtube.com/watch?v=H7iqIjbWty4 */

public class App {
    public static void main(String[] args) throws Exception {
        int sum = 20;
        int digit = 5;
        smallestNumber(sum, digit);
    }

    private static void smallestNumber(int sum, int digit) {
        if((9*digit)<sum) System.out.println("Not possible");
        String res = "";
        for(int i = digit-1; i>=0;i--){
            // Putting '9' at the end
            if(sum>9){
                res = "9"+res;
                sum -= 9;
            }else{
                // For first digit
                if(i == 0){
                    res = String.valueOf(sum)+res;
                } else {
                    // Puttinh the rest end with '1'
                    res = String.valueOf(sum-1)+res;
                    i--;
                    // Putting zero in between
                    while(i>0){
                        res = "0"+res;
                        i--;
                    }
                    res = "1"+res;
                    break;
                }
            }
        }
        System.out.println("Smallest number: " + res);
    }
}
