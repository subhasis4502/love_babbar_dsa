import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            largeFact(n);
        }
        sc.close();
    }

    private static void largeFact(int N) {
        ArrayList<Integer> arr = new ArrayList<>();
        int num = 2;
        int carry = 0;
        arr.add(1);

        while (num <= N) {
            // Multiplying for the total arraylist
            for (int i = arr.size() - 1; i >= 0; i--) {
                int mul = arr.get(i) * num + carry;
                arr.set(i, mul % 10);
                carry = mul / 10;
            }

            // Adding the carry digits to the arraylist
            while (carry != 0) {
                arr.add(0, carry % 10);
                carry = carry / 10;
            }
            num++;
        }

        for (int i : arr) {
            System.out.print(i);
        }
    }
}
