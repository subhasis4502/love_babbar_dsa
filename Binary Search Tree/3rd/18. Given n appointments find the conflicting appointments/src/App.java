/* Ref: https://www.youtube.com/watch?v=OXSmfJ3NdbA */

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Interval i1 = new Interval(1, 5);
        Interval i2 = new Interval(3, 7);
        Interval i3 = new Interval(2, 6);
        Interval i4 = new Interval(10, 15);
        Interval i5 = new Interval(5, 6);
        Interval i6 = new Interval(4, 100);
        Interval[] intervals = { i1, i2, i3, i4, i5, i6 };

        ArrayList<ArrayList<Interval>> conflicts = findConflict(intervals);
        for (ArrayList<Interval> conflict : conflicts) {
            for (Interval c : conflict) {
                System.out.print("(" + c.start + ", " + c.end + ") ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Interval>> findConflict(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        ArrayList<ArrayList<Interval>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j].start < intervals[j].end) {
                    ArrayList<Interval> conflicts = new ArrayList<>();
                    conflicts.add(intervals[i]);
                    conflicts.add(intervals[j]);
                    result.add(conflicts);
                }
            }
        }

        return result;
    }
}
