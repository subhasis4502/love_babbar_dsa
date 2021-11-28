import java.util.*;

public class App {
    public static void mergeSortArr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int i = n-1;
        int j = 0;
        
        while(i>=0 && j <m){
            if(arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                
                i--;
                j++;
            }
            else
                break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
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

            mergeSortArr(arr1, arr2);
            
            for (int i : arr1) 
                System.out.print(i + " ");

            for (int i : arr2) 
                System.out.print(i + " ");
            
        }
        sc.close();
    }
}
