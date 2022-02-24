class TwoStack {
    int size;
    int top1, top2;
    int arr[] = new int[100];

    TwoStack() {
        size = 100;
        top1 = -1;
        top2 = size;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        TwoStack sq = new TwoStack();
        push1(2, sq);
        push1(3, sq);
        push2(4, sq);
        System.out.println(pop1(sq));
        System.out.println(pop2(sq));
        System.out.println(pop2(sq));
    }

    private static int pop2(TwoStack sq) {
        if(sq.top2 == sq.size)
            return -1;
        return sq.arr[sq.top2++];
    }

    private static int pop1(TwoStack sq) {
        if(sq.top1 == -1)
            return -1;
        return sq.arr[sq.top1--];
    }

    private static void push2(int x, TwoStack sq) {
        sq.top2--;
        if(sq.top1 == sq.top2) return;
        sq.arr[sq.top2] = x;
    }

    private static void push1(int x, TwoStack sq) {
        sq.top1++;
        if(sq.top1 == sq.top2) return;
        sq.arr[sq.top1] = x;
    }
}
