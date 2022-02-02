public class App {
    public static void main(String[] args) throws Exception {
        int graph[][] = {
                { 0, 1000, 2000 },
                { 0, 0, 5000 },
                { 0, 0, 0 },
        };
        N = graph.length;
        minCashFlow(graph);
    }

    static int N;

    private static void minCashFlow(int[][] graph) {
        int amount[] = new int[N];

        // Calculate the net amount to be paid to person 'p'
        for (int p = 0; p < N; p++)
            for (int i = 0; i < N; i++)
                amount[p] += (graph[i][p] - graph[p][i]);

        minCashFlowRec(amount);
    }

    private static void minCashFlowRec(int[] amount) {
        int mxCredit = getMax(amount), mxDebit = getMin(amount);

        // If both amounts are 0, then all amounts are settled
        if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
            return;

        // Find the minimum of two amounts
        int min = Math.min(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;

        // If minimum is the maximum amount to be
        System.out.println("Person " + mxDebit + " pays " + min + " to " + "Person " + mxCredit);

        minCashFlowRec(amount);
    }

    static int getMin(int arr[]) {
        int minInd = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] < arr[minInd])
                minInd = i;
        return minInd;
    }

    static int getMax(int arr[]) {
        int maxInd = 0;
        for (int i = 1; i < N; i++)
            if (arr[i] > arr[maxInd])
                maxInd = i;
        return maxInd;
    }
}
