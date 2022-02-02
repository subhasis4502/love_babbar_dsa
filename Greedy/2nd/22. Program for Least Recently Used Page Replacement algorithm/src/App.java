import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] pages = {5, 0, 1, 3, 2, 4, 1, 0, 5};
        int capacity = 4;
        pageFault(pages, capacity);
    }

    private static void pageFault(int[] pages, int capacity) {
        Queue<Integer> q = new LinkedList<>();
        int faults = 0;
        
        for(int i : pages){
            // When queue is not full
            if(!q.contains(i) && q.size() < capacity){
                q.add(i);
                faults++;
            // When queue fulled
            } else if(!q.contains(i) && q.size() == capacity) {
                q.remove();
                q.add(i);
                faults++;
            // When already present in the queue
            } else if(q.contains(i)){
                q.remove(i);
                q.add(i);
            }
        }

        System.out.println("Total page faults occured: " + faults);
    }
}
