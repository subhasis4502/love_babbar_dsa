/* Ref: https://www.youtube.com/watch?v=naDecrj9Cyc */

import java.util.Arrays;
import java.util.HashMap;

class Train {
    int no, arrival, departure, platform;

    public Train(int no, int arrival, int departure, int platform) {
        this.no = no;
        this.arrival = arrival;
        this.departure = departure;
        this.platform = platform;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Train t1 = new Train(1, 1000, 1030, 1);
        Train t2 = new Train(2, 1010, 1030, 1);
        Train t3 = new Train(3, 1000, 1020, 2);
        Train t4 = new Train(4, 1030, 1230, 2);
        Train t5 = new Train(5, 1200, 1230, 3);
        Train t6 = new Train(6, 900, 1005, 1);

        Train[] trains = { t1, t2, t3, t4, t5, t6 };
        maxStoppage(trains);
    }

    private static void maxStoppage(Train[] trains) {
        Arrays.sort(trains, (Train a, Train b) -> a.departure - b.departure);
        HashMap<Integer, Train> hash = new HashMap<>();
        for (Train train : trains) {
            hash.put(train.platform, null);
        }
        int count = 0;
        for (Train train : trains) {
            if (hash.get(train.platform) == null) {
                hash.put(train.platform, train);
                count++;
            } else {
                Train old = hash.get(train.platform);
                if (old.departure < train.arrival) {
                    hash.put(train.platform, train);
                    count++;
                }
            }
        }

        System.out.println("Maximum platform available for: " + count + " trains");
    }
}
