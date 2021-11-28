import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size1 = sc.nextInt();
            int size2 = sc.nextInt();
            int[] arr1 = new int[size1];
            int[] arr2 = new int[size2];

            for (int i = 0; i < size1; i++)
                arr1[i] = sc.nextInt();

            for (int i = 0; i < size2; i++)
                arr2[i] = sc.nextInt();

            isSubset(arr1, arr2);
        }
        sc.close();
    }

    private static void isSubset(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for (int i : arr1)
            set.add(i);

        for (int i : arr2)
            if (!set.contains(i))
                System.out.println("No, this is not a subset");

        System.out.println("Yes, this is a subset");
    }
}
