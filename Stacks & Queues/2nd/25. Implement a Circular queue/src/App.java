class CirularQueue {
    int front, rear;
    int[] arr;

    CirularQueue(int size) {
        arr = new int[size];
        front = rear = -1;
    }

    boolean isEmpty() {
        return rear == front;
    }

    boolean isFull() {
        if ((front == -1 && rear == arr.length-1) || rear == (front - 1) % (arr.length - 1))
            return true;
        return false;
    }

    void enqueue(int val) {
        if (isFull())
            System.out.println("The queue is full");
        else {
            rear = (rear+1) % arr.length;
            arr[rear] = val;
        }
    }

    int dequeue() {
        if (isEmpty())
            return -1;
        else {
            front = (front + 1) % arr.length;
            return arr[front];
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        CirularQueue q = new CirularQueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(6);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
