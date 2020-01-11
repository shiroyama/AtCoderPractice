package dp_d;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int W = Integer.parseInt(sc.next());
        int[] w = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(sc.next());
            v[i] = Integer.parseInt(sc.next());
        }

        long[][] dp = new long[N + 1][W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < w[i]) {
                    dp[i + 1][j] = dp[i][j];
                    continue;
                }
                long taken = dp[i][j - w[i]] + v[i];
                long notTaken = dp[i][j];
                dp[i + 1][j] = Math.max(taken, notTaken);
            }
        }
        System.out.println(dp[N][W]);
    }
}
