/* Ref: https://www.youtube.com/watch?v=vrRWIbhGK7o */

public class App {
    public static void main(String[] args) throws Exception {
        int chicken = 5;
        int min = 3;
        int barn = 10;
        int time = 5;
        int[] position = { 0, 2, 3, 5, 7 };
        int[] speed = { 2, 1, 1, 1, 4 };

        swapRequired(position, speed, min, barn, time);
    }

    private static void swapRequired(int[] position, int[] speed, int min, int barn, int time) {
        int count = 0, swaps = 0, notPossible = 0;
        for (int i = speed.length - 1; i >= 0; i--) {
            int distanceNeeded = barn - position[i];
            int distancePossible = speed[i] * time;
            if (distancePossible >= distanceNeeded) {
                count++;
                if (notPossible > 0)
                    swaps += notPossible;
            } else {
                notPossible++;
            }

            if (count >= min)
                break;
        }

        if (count >= min) {
            System.out.println("Minimumswaps required: " + swaps);
        } else {
            System.out.println("Not possible");
        }
    }
}
