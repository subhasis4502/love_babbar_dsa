/* 
Input:
3 3
1 2 0
1 2 1
1 2 3
3 3
0 1 2
1 1 2
3 1 2

Output:
Size of BCS: 2
*/


import java.util.*;

public class App {
    public static long getHashValue(long hash[][], int startIndOfI, int startIndOfJ, int endIndOfI, int endIndOfJ,
            long p1[], long p2[]) {
        long res = hash[endIndOfI][endIndOfJ] - hash[endIndOfI][startIndOfJ - 1] - hash[startIndOfI - 1][endIndOfJ]
                + hash[startIndOfI - 1][startIndOfJ - 1];
        res = res * p1[p1.length - startIndOfI] * p2[p2.length - startIndOfJ];
        return res;
    }

    public static boolean ninjaAndSwordHelper(long mat1[][], long mat2[][], int size, long p1[], long p2[],
            long hashMatA[][], long hashMatB[][]) {

        HashSet<Long> hashValueOfMat1 = new HashSet<>();
        for (int i = 1; i <= mat1.length - size + 1; i++) {
            for (int j = 1; j <= mat1[0].length - size + 1; j++) {
                hashValueOfMat1.add(getHashValue(hashMatA, i, j, i + size - 1, j + size - 1, p1, p2));
            }
        }

        for (int i = 1; i <= mat2.length - size + 1; i++) {
            for (int j = 1; j <= mat2[0].length - size + 1; j++) {
                if (hashValueOfMat1.contains(getHashValue(hashMatB, i, j, i + size - 1, j + size - 1, p1, p2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int ninjaAndSword(long[][] mat1, long[][] mat2, int m1, int n1, int m2, int n2) {
        long p1[] = new long[707];
        long p2[] = new long[707];

        p1[0] = p2[0] = 1;

        for (int i = 1; i < 707; i++) {
            p1[i] = p1[i - 1] * 157;
            p2[i] = p2[i - 1] * 173;
        }

        long hashMatA[][] = new long[707][707];
        long hashMatB[][] = new long[707][707];

        for (int i = 1; i <= m1; i++) {
            for (int j = 1; j <= n1; j++) {
                hashMatA[i][j] = hashMatA[i - 1][j] + hashMatA[i][j - 1] - hashMatA[i - 1][j - 1]
                        + mat1[i - 1][j - 1] * p1[i] * p2[j];
            }
        }

        for (int i = 1; i <= m2; i++) {
            for (int j = 1; j <= n2; j++) {
                hashMatB[i][j] = hashMatB[i - 1][j] + hashMatB[i][j - 1] - hashMatB[i - 1][j - 1]
                        + mat2[i - 1][j - 1] * p1[i] * p2[j];
            }
        }

        int startSize = 1;
        int endSize = 701;
        int largestCommonSubsquare = 0;
        while (startSize <= endSize) {
            int mid = (startSize + endSize) / 2;
            if (ninjaAndSwordHelper(mat1, mat2, mid, p1, p2, hashMatA, hashMatB)) {
                largestCommonSubsquare = mid;
                startSize = mid + 1;
            } else {
                endSize = mid - 1;
            }
        }
        return largestCommonSubsquare;

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        long a[][] = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();
        int y = sc.nextInt();
        long b[][] = new long[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        System.out.println("Size of BCS: " + ninjaAndSword(a, b, m, n, x, y));
        sc.close();
    }
}
