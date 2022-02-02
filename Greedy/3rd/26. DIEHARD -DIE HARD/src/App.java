/* Ref: https://www.youtube.com/watch?v=KrXzcYTDn2s */

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] dp = new int[1001][1001];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        int health = 20, armor = 8;
        int air = solve(dp, health + 3, armor + 2, 1);
        int water = solve(dp, health - 5, armor - 10, 2);
        int fire = solve(dp, health - 20, armor + 5, 3);
        System.out.println(Math.max(Math.max(air, water), fire));
    }

    private static int solve(int[][] dp, int health, int armor, int path) {
        if (health <= 0 || armor <= 0)
            return 0;
        if (dp[health][armor] != -1)
            return dp[health][armor];
        int x = 0, y = 0, z = 0;
        if (path != 1)
            x = 1 + solve(dp, health + 3, armor + 2, 1);
        if (path != 2)
            y = 1 + solve(dp, health - 5, armor - 10, 2);
        if (path != 3)
            z = 1 + solve(dp, health - 20, armor + 5, 3);

        return dp[health][armor] = Math.max(Math.max(x, y), z);
    }
}
