import java.util.Scanner;

class MinDiffTabulation {
    int n;
    int[] arr;
    
    public MinDiffTabulation(int n) {
        this.n = n;
        arr = new int[n];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    int findMinDiff() {
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        boolean[][] dp = new boolean[n + 1][totalSum / 2 + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum / 2; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int j = totalSum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                minDiff = totalSum - 2 * j;
                break;
            }
        }
        return minDiff;
    }
}

public class MinDifftabulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        MinDiffTabulation m = new MinDiffTabulation(n);
        int result = m.findMinDiff();
        System.out.println("The minimum difference between subset sums is: " + result);
    }
}
