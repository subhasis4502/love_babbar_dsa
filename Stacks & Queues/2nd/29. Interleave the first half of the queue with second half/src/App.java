/* Ref: youtube.com/watch?v=h9Oi5IumE88 */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeaveQueue(q);
    }

    private static void interLeaveQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        int half = q.size() / 2;

        // Putting the first-half into stack
        for(int i = 0; i<half; i++) 
            stack.push(q.remove());
        
        // Adding the first-half to the end of queue
        while(!stack.isEmpty())
            q.add(stack.pop());

        // // Putting the last-half into stack
        for (int i = 0; i < half; i++) {
            stack.add(q.remove());
        }

        while(!stack.isEmpty()){
            q.add(stack.pop()); // One element from last half
            q.add(q.remove()); // One element from first half
        }

        reverse(q);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
    }

    private static void reverse(Queue<Integer> q) {
        if(!q.isEmpty()){
            int temp = q.remove();
            reverse(q);
            q.add(temp);
        }
        return;
    }
}
