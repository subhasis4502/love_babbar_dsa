/* 
Input:
Enter the line co-ordinates:
1 -1 -3 
How many points?
5       
-3 -2
-1 0
-1 2
1 2
3 4

Output:
Optimal Distance: 20.787127583509818
*/

import java.util.Scanner;

public class App {
    static class Line {
        int a, b, c;

        public Line(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }

    static class Point {
        int x, y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int EPS = (int) (1e-6) + 1;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the line co-ordinates:");
        Line l = new Line(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("How many points?");
        int[][] points = new int[sc.nextInt()][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        System.out.println("Optimal Distance: " + findOptimumCost(points, l));
        sc.close();
    }

    private static double findOptimumCost(int[][] points, App.Line l) {
        Point[] p = new Point[points.length];

        // converting 2D array input to point array
        for (int i = 0; i < points.length; i++)
            p[i] = new Point(points[i][0], points[i][1]);

        return findOptimumCostUtil(p, l);
    }

    private static double findOptimumCostUtil(Point[] p, Line l) {
        double low = -1e6;
        double high = 1e6;

        // loop until difference between low and high
        // become less than EPS
        while ((high - low) > EPS) {
            // mid1 and mid2 are representative x
            // co-ordiantes of search space
            double mid1 = low + (high - low) / 3;
            double mid2 = high - (high - low) / 3;

            double dist1 = compute(p, l, mid1);
            double dist2 = compute(p, l, mid2);

            // if mid2 point gives more total distance,
            // skip third part
            if (dist1 < dist2)
                high = mid2;

            // if mid1 point gives more total distance,
            // skip first part
            else
                low = mid1;
        }

        // compute optimum distance cost by sending average
        // of low and high as X
        return compute(p, l, (low + high) / 2);
    }

    /*
     * Utility method to compute total distance all points
     * when choose point on given line has x-coordinate
     * value as X
     */
    static double compute(Point p[], Line l, double X) {
        double res = 0;
        int n = p.length;
        // calculating Y of chosen point by line equation
        double Y = -1 * (l.c + l.a * X) / l.b;
        for (int i = 0; i < n; i++)
            res += Math.sqrt(Math.pow((X - p[i].x), 2) + Math.pow((Y - p[i].y), 2));
        return res;
    }
}
