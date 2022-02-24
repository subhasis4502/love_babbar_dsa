import java.util.Arrays;
import java.util.Stack;

class Pair {
    int start, finish;

    Pair(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Pair m1 = new Pair(1, 3);
        Pair m2 = new Pair(2, 4);
        Pair m3 = new Pair(6, 8);
        Pair m4 = new Pair(9, 10);
        Pair[] meetings = {m1,m2,m3,m4};
        overlappedInterval(meetings);
    }

    private static void overlappedInterval(Pair[] meetings) {
        Arrays.sort(meetings, (Pair a, Pair b) -> a.start-b.start);
        Stack<Pair> stack = new Stack<>();

        for (Pair p : meetings) {
            if(stack.isEmpty() || stack.peek().finish < p.start)
                stack.push(p);
            else
                stack.peek().finish = p.finish;
        }

        for (Pair pair : stack) {
            System.out.println(pair.start + " " + pair.finish);
        }
    }
}
