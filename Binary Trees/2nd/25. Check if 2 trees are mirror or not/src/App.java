import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] a = {1, 2, 1, 3};
        int[] b = {1, 3, 1, 2};

        if(checkMirrorTree(a, b, 2))
            System.out.println("Two tree are mirriors");
        else
            System.out.println("Two tree are not mirriors");

    }

    private static boolean checkMirrorTree(int[] a, int[] b, int e) {
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();

        for (int i = 0; i < 2*e; i+=2) {
            if(!map.containsKey(a[i]))
                map.put(a[i], new Stack<>());
            map.get(a[i]).add(a[i+1]);
        }

        for (int i = 0; i < 2*e; i+=2) {
            if(map.get(b[i]).pop() != b[i+1])
                return false;
        }
        return true;
    }
}
