/* Ref: https://www.youtube.com/watch?v=IIU646w5rZI */

import java.util.Arrays;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Item i1 = new Item(60, 10);
        Item i2 = new Item(100, 20);
        Item i3 = new Item(120, 30);

        Item[] items = { i1, i2, i3 };
        int weight = 50;
        fractionalKnapsack(items, weight);
    }

    private static void fractionalKnapsack(Item[] items, int weight) {
        Arrays.sort(items, (Item a, Item b) -> (b.value / b.weight) - (a.value / a.weight));
        double res = 0;
        for (int i = 0; i < items.length; i++) {
            if (weight > items[i].weight) {
                res += (double) items[i].value;
                weight -= items[i].weight;
            } else {
                res += (weight * items[i].value / (double) items[i].weight);
                break;
            }
        }
        System.out.println("Maximum value: " + res);
    }
}
