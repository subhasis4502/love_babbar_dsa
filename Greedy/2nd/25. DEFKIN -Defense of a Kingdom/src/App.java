/* Ref: https://www.youtube.com/watch?v=fk1yIirivEo */

import java.util.ArrayList;
import java.util.Collections;

class Tower {
    int row, col;

    public Tower(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int height = 15;
        int width = 8;
        Tower t1 = new Tower(3, 8);
        Tower t2 = new Tower(11, 2);
        Tower t3 = new Tower(8, 6);
        Tower[] towers = { t1, t2, t3 };

        penaltyRectangle(towers, height, width);
    }

    private static void penaltyRectangle(Tower[] towers, int height, int width) {
        ArrayList<Integer> h = new ArrayList<>();
        ArrayList<Integer> v = new ArrayList<>();

        // Adding starting point
        h.add(0);
        v.add(0);
        for (Tower t : towers) {
            h.add(t.row);
            v.add(t.col);
        }
        // Adding ending point
        h.add(height + 1);
        v.add(width + 1);

        Collections.sort(h);
        Collections.sort(v);

        int maxHeight = 0;
        int maxWidth = 0;
        for (int i = 0; i < h.size() - 1; i++) {
            maxHeight = Math.max(maxHeight, h.get(i + 1) - h.get(i) - 1);
            maxWidth = Math.max(maxWidth, v.get(i + 1) - v.get(i) - 1);
        }

        System.out.println("Maximum area: " + maxHeight * maxWidth);
    }
}
