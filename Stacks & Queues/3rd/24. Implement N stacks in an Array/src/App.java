import java.util.Arrays;

class KQueues {
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int n, k;
    int free;

    public KQueues(int k, int n) {
        this.k = k;
        this.n = n;

        arr = new int[n];
        next = new int[n];
        front = new int[k];
        rear = new int[k];

        // Initialize all queues as empty
        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);

        // Initialize all spaces as free
        free = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    public boolean isEmpty(int qNum) {
        return front[qNum] == -1;
    }

    public boolean isFull() {
        return free == -1;
    }

    // To enqueue an item in queue number 'qNum'
    public void enqueue(int data, int qNum) {
        if (isFull())
            return;

        int nextFree = next[free];
        if (isEmpty(qNum))
            front[qNum] = rear[qNum] = free;
        else {
            // Update next of rear and then rear for queue number 'qNum'
            next[rear[qNum]] = free;
            rear[qNum] = free;
        }
        next[free] = -1;

        // Put the item in array
        arr[free] = data;

        // Update index of free slot to index of next slot in free list
        free = nextFree;
    }

    public int dequeue(int qNum) {
        if (isEmpty(qNum))
            return -1;

        // Find index of front item in queue number 'qNum'
        int frontIndex = front[qNum];

        // Change top to store next of previous top
        front[qNum] = next[frontIndex];

        // Attach the previous front to the beginning of free list
        next[frontIndex] = free;
        free = frontIndex;

        return arr[frontIndex];
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int k = 3, n = 10;
        KQueues ks = new KQueues(k, n);

        // Let us put some items in queue number 2
        ks.enqueue(15, 2);
        ks.enqueue(45, 2);

        // Let us put some items in queue number 1
        ks.enqueue(17, 1);
        ks.enqueue(49, 1);
        ks.enqueue(39, 1);

        // Let us put some items in queue number 0
        ks.enqueue(11, 0);
        ks.enqueue(9, 0);
        ks.enqueue(7, 0);

        System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1));
        System.out.println("Dequeued element from queue 0 is " + ks.dequeue(0));
    }
}
