import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] chocklates = { 3, 4, 1, 9, 56, 7, 9, 12 };
        int students = 5;
        chocklateDiribution(chocklates, students);
    }

    private static void chocklateDiribution(int[] chocklates, int students) {
        Arrays.sort(chocklates);
        int i = 0;
        int j = students - 1;
        int minDiff = Integer.MAX_VALUE;

        while (j < chocklates.length) {
            minDiff = Math.min(minDiff, chocklates[j] - chocklates[i]);
            i++;
            j++;
        }
        System.out.println("The difference between min and max: " + minDiff);
    }
}
