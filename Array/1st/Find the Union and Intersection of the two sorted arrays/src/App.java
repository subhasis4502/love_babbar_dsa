import java.util.*;
public class App {
    public static void findUnionIntersection(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> hash1 = new HashMap<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        for(int i : a){
            hash1.put(i, hash1.getOrDefault(i, 0)+1);
            set.add(i);
        }
        
        for(int i : b){
            hash2.put(i, hash2.getOrDefault(i, 0)+1);
            set.add(i);
        }

        System.out.print("Union: ");
        for (int i : set)
            System.out.print(i + " ");
        
        System.out.print("\nIntersection: ");
        for (int i : hash1.keySet())
            if(hash2.containsKey(i))
                System.out.print(i + " ");
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

            findUnionIntersection(arr1, arr2);
        }
        sc.close();
    }
}
