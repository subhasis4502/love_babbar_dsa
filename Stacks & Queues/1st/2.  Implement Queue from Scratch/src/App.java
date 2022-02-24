class Queue {
    private int front, rear, size;
    private int[] qArr;

    public Queue(int size) {
        this.size = size;
        front = -1;
        rear = -1;
        qArr = new int[size];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void enqueue(int data) {
        if (!isFull())
            qArr[++rear] = data;
        return;
    }

    public int dequeue() {
        if (!isEmpty())
            return qArr[++front];
        return -1;
    }

    public int front() {
        if (!isEmpty())
            return qArr[front + 1];
        return -1;
    }

    public int rear() {
        if (!isEmpty())
            return qArr[rear];
        return -1;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);

        q.dequeue();
        q.dequeue();
        q.dequeue();

        System.out.println(q.front());
        System.out.println(q.rear());
    }
}
