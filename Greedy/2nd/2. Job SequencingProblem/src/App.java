/* Ref: https://www.youtube.com/watch?v=bID397v7ja4 */

import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Job j1 = new Job(1, 2, 100);
        Job j2 = new Job(2, 1, 19);
        Job j3 = new Job(3, 2, 27);
        Job j4 = new Job(4, 1, 25);
        Job j5 = new Job(5, 1, 15);

        Job[] jobs = { j1, j2, j3, j4, j5 };
        jobScheduling(jobs);
    }

    private static void jobScheduling(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        Set<Integer> possible = new HashSet<>();
        int count = 0;
        int maxProfit = 0;
        for (Job j : jobs) {
            for (int i = j.deadline; i > 0; i--) {
                if (!possible.contains(i)) {
                    possible.add(i);
                    count++;
                    maxProfit += j.profit;
                    break;
                }
            }
        }
        System.out.println("Number of jobs: " + count);
        System.out.println("Maximum profit: " + maxProfit);
    }
}
