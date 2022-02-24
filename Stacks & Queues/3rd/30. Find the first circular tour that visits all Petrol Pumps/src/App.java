/* Ref: https://www.youtube.com/watch?v=7WYwqvOSaa8 */

public class App {
    public static void main(String[] args) throws Exception {
        int[] petrol = { 4, 6, 7, 4 };
        int[] distance = { 6, 5, 3, 5 };

        tourStart(petrol, distance);
    }

    private static void tourStart(int[] petrol, int[] distance) {
        int start = 0;
        int end = 1;

        int curr_petrol = petrol[start] - distance[start];

        while (end != start || curr_petrol < 0) {
            // If curremt amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while (curr_petrol < 0 && start != end) {
                // Remove starting petrol pump. Change start
                curr_petrol -= petrol[start] - distance[start];
                start = (start + 1) % petrol.length;// To make sure start not increase more than length

                // If 0 is being considered as start again, then there is no
                // possible solution
                if (start == 0) {
                    System.out.println("Not possible");
                    return;
                }
            }

            // Add a petrol pump to current tour
            curr_petrol += petrol[end] - distance[end];

            end = (end + 1) % petrol.length;
        }

        System.out.println("The starting point of the tour: " + start);
    }
}
