/* Ref: https://www.youtube.com/watch?v=4ggF3tXIAp0 */

/* 
Input:
7 23
10 2 3 4 5 7 8

Output:
Possible Combinations: 
2 3 8 10 
2 4 7 10
3 5 7 8
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        fourSum(arr, target);
        sc.close();
    }

    public static void fourSum(int[] arr, int val) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int sum = 0;
        if (arr == null || arr.length < 4)
            System.out.println("No combination is possible");
        else {
            int n = arr.length;
            Arrays.sort(arr);
            for (int i = 0; i < n - 3; i++) {
                // For the same value skipping it
                if (i > 0 && arr[i - 1] == arr[i])
                    continue;
                for (int j = i + 1; j < n - 2; j++) {
                    if (j > i + 1 && arr[j - 1] == arr[j])
                        continue;
                    int left = j + 1, right = n - 1;
                    while (left < right) {
                        int l1 = left;
                        int r1 = right;
                        sum = arr[i] + arr[j] + arr[left] + arr[right];
                        if (sum == val) {
                            ArrayList<Integer> li = new ArrayList<Integer>();
                            li.add(arr[i]);
                            li.add(arr[j]);
                            li.add(arr[left]);
                            li.add(arr[right]);
                            res.add(li);
                            while (left < right && arr[left] == arr[l1])
                                left++;
                            while (left < right && arr[right] == arr[r1])
                                right--;
                        } else if (sum < val)
                            left++;
                        else
                            right--;
                    }
                }
            }
        }

        System.out.println("Possible Combinations: ");
        for (ArrayList<Integer> a : res) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
