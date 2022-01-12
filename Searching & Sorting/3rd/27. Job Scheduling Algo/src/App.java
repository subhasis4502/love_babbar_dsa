/* Ref: https://www.youtube.com/watch?v=V59YYFPN5KA */

/* 
Input:
4
1 3 50
2 4 10
3 5 40
3 6 70

Output:
Maximum profit: 120
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> jobs = new ArrayList<>();
        int noJob = sc.nextInt();
        for (int i = 0; i < noJob; i++) {
            ArrayList<Integer> job = new ArrayList<>();
            job.add(sc.nextInt());
            job.add(sc.nextInt());
            job.add(sc.nextInt());
            jobs.add(job);
        }
        jobScheduling(jobs);
        sc.close();
    }

    private static void jobScheduling(ArrayList<ArrayList<Integer>> jobs) {
        Collections.sort(jobs, new Comparator<ArrayList<Integer>> () {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(1)-b.get(1);
            }
        });

        int[] dp = new int[jobs.size()];
        dp[0] = jobs.get(0).get(2);

        for (int i = 1; i < dp.length; i++) {
            int include  =jobs.get(i).get(2);
            int last = -1;
            int low = 0;
            int high = i-1;
            while(low <= high){
                int mid = (low+high)/2;
                if(jobs.get(mid).get(1) <= jobs.get(i).get(0)){
                    last = mid;
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            if(last != -1)
                include += dp[last];
            int exclude = dp[i-1];
            dp[i] = Math.max(include, exclude);
        }

        System.out.println("Maximum profit: " + dp[dp.length-1]);
    }
}
