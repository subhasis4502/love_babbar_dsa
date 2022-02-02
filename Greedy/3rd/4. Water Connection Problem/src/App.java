/* Ref: https://www.youtube.com/watch?v=PxYviqEuWlA */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(7, 5, 4, 2, 9, 3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(4, 9, 6, 8, 7, 1));
        ArrayList<Integer> d = new ArrayList<>(Arrays.asList(98, 72, 10, 22, 17, 66));

        int house = 9;
        int pipe = 6;
        solve(house, pipe, a, b, d);
    }

    private static void solve(int house, int pipe, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> d) {
        // Output pipes
        HashMap<Integer, Integer> out = new HashMap<>();
        // Input pipes
        HashMap<Integer, Integer> in = new HashMap<>();

        for (int i = 0; i < pipe; i++) {
            out.put(a.get(i), i);
            in.put(b.get(i), i);
        }

        // Houses with no input pipes
        ArrayList<Integer> start = new ArrayList<>();

        for (int i = 1; i <= house; i++) {
            if (out.containsKey(i) && !in.containsKey(i)) {
                start.add(i);
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < start.size(); i++) {
            int min = Integer.MAX_VALUE;
            int k = start.get(i); // Starting of the pipe
            int z = k;
            //Travering until we find the house with no output
            while (out.containsKey(k)) {
                min = Math.min(d.get(out.get(k)), min); // Finding the minimum diameter
                k = b.get(out.get(k)); 
            }

            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(z);
            ans.add(k);
            ans.add(min);
            res.add(ans);

        }

        for (ArrayList<Integer> array : res) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
