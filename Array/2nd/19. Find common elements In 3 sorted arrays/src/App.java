import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size1 = sc.nextInt();
            int size2 = sc.nextInt();
            int size3 = sc.nextInt();
            int[] arr1 = new int[size1];
            int[] arr2 = new int[size2];
            int[] arr3 = new int[size3];

            for (int i = 0; i < size1; i++)
                arr1[i] = sc.nextInt();

            for (int i = 0; i < size2; i++)
                arr2[i] = sc.nextInt();

            for (int i = 0; i < size3; i++)
                arr3[i] = sc.nextInt();

            findCommon(arr1, arr2, arr3);
        }
        sc.close();
    }

    private static void findCommon(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0;
        int j = 0;
        int k = 0;

        System.out.print("Common elements: ");
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j])
                i++;

            else if (arr2[j] < arr3[k])
                j++;

            else
                k++;
        }
    }
}
