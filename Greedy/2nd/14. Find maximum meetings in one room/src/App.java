/* Ref: https://www.youtube.com/watch?v=nSWWppCGYy8 */

import java.util.*;

class Pair {
    int start, end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int[] startTimes = { 1, 3, 0, 5, 8, 5 };
        int[] endTimes = { 2, 4, 6, 7, 9, 9 };

        maxMeetings(startTimes, endTimes);
    }

    private static void maxMeetings(int[] startTimes, int[] endTimes) {
        ArrayList<Pair> meetings = new ArrayList<>();
        for (int i = 0; i < startTimes.length; i++) {
            meetings.add(new Pair(startTimes[i], endTimes[i]));
        }
        Collections.sort(meetings, (Pair a, Pair b) -> a.end - b.end);
        int count = 1;
        int i = 0;
        int j = i + 1;
        while (j < meetings.size()) {
            if (meetings.get(i).end < meetings.get(j).start) {
                count++;
                i = j;
                j++;
            } else {
                j++;
            }
        }

        System.out.println("Total meetings: " + count);
    }
}
