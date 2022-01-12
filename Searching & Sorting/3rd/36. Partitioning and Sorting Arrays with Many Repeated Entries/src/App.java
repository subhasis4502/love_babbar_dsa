/* Ref: https://www.baeldung.com/java-sorting-arrays-with-repeated-entries */

/* 
Input:
7
4 4 4 2 4 4 5 

Output:
2 4 4 4 4 4 5 
*/

import java.util.Scanner;

class Partition {
    private int left;
    private int right;

    public Partition(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end <= start)
            return;

        Partition middlePartition = partition(arr, start, end);

        quickSort(arr, start, middlePartition.getLeft() - 1);
        quickSort(arr, middlePartition.getRight() + 1, end);
    }

    public static Partition partition(int[] arr, int start, int end) {
        int lt = start, current = start, gt = end;
        int partitioningValue = arr[start];

        while (current <= gt) {
            int compareCurrent = compare(arr[current], partitioningValue);
            switch (compareCurrent) {
                case -1:
                    swap(arr, current++, lt++);
                    break;
                case 0:
                    current++;
                    break;
                case 1:
                    swap(arr, current, gt--);
                    break;
            }
        }
        return new Partition(lt, gt);
    }

    public static void swap(int[] array, int position1, int position2) {
        if (position1 != position2) {
            int temp = array[position1];
            array[position1] = array[position2];
            array[position2] = temp;
        }
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2)
            return 1;
        else if (num1 < num2)
            return -1;
        else
            return 0;
    }
}
