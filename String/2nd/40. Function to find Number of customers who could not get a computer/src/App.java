import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int noComp = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        runCusSimul(noComp, str);
        sc.close();
    }

    private static void runCusSimul(int n, String str) {
        // seen[i] = 0, indicates that customer 'i' is not in cafe
        // seen[1] = 1, indicates that customer 'i' is in cafe but
        // computer is not assigned yet.
        // seen[2] = 2, indicates that customer 'i' is in cafe and
        // has occupied a computer.
        char[] seen = new char[26];
        int res = 0;
        int occupied = 0;

        for (char c : str.toCharArray()) {
            // Find index of current character in seen[0...25]
            int ind = c - 'A';

            // If First occurrence of 'str[i]'
            if (seen[ind] == 0) {
                // set the current character as seen
                seen[ind] = 1;

                // If number of occupied computers is less than
                // n, then assign a computer to new customer
                if (occupied < n) {
                    occupied++;

                    // Set the current character as occupying a computer
                    seen[ind] = 2;
                }

                // Else this customer cannot get a computer,
                // increment result
                else
                    res++;
            }

            // If second occurrence of 'str[i]'
            else {
                if (seen[ind] == 2)
                    occupied--;
                seen[ind] = 0;
            }
        }
        System.out.println("Customer not geeting computer: " + res);
    }
}
