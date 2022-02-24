/* Ref: https://www.youtube.com/watch?v=9x7TYLP3714 */

import java.util.Arrays;

class KStack {
    int[] arr;
    int[] top;
    int[] next;
    int n, k;
    int free;

    public KStack(int k, int n) {
        this.k = k;
        this.n = n;

        arr = new int[n];
        next = new int[n];
        top = new int[k];

        Arrays.fill(top, -1);
        free = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    public boolean isEmpty(int stNum) {
        return top[stNum] == -1;
    }

    public boolean isFull() {
        return free == -1;
    }

    public void push(int data, int stNum){
        if(isFull())
            return;
        int i = free;
        free = next[i];
        next[i] = top[stNum];
        top[stNum] = i;

        arr[i] = data;
    }

    public int pop(int stNum){
        if(isEmpty(stNum))
            return -1;
        int i = top[stNum];
        top[stNum] = next[i];
        next[i] = free;
        free = i;

        return arr[i];
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int k = 3, n = 10;
        KStack ks = new KStack(k, n);

        ks.push(15, 2);
        ks.push(45, 2);
  
        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);
  
        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);
  
        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }
}
