/* Ref: https://www.youtube.com/watch?v=IhsUbEMfIbY */

import java.util.Scanner;

public class App {

    public static void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        // Finding the first decreasing number
        while(i >= 0 && nums[i] >= nums[i+1])
            i--;
        // Finding the number of substitution
        if(i>=0){
            int j = nums.length-1;
            // Finding the next highest number than the pointed number 
            while(j >= 0 && nums[j] <= nums[i]) 
                j--;
            swap(nums, i, j);
        }
        
        reverse(nums,i+1);

        for (int in : nums) {
            System.out.print(in + " ");
        }
    }
    
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            nextPermutation(arr);
        }
        sc.close();
    }
}
