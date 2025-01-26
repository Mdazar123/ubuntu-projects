import java.util.Scanner;

class MinDiffMemoization {
    int n;
    int[] arr;
    int[][] dp;

    public MinDiffMemoization(int n) {
        this.n = n;
        arr = new int[n];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        dp = new int[n + 1][totalSum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalSum; j++) {
                dp[i][j] = -1;
            }
        }
    }

    int findDiff(int idx, int currSum, int totalSum) {
        if (idx == 0) {
            return Math.abs((totalSum - currSum) - currSum);
        }

        if (dp[idx][currSum] != -1) {
            return dp[idx][currSum];
        }

        int include = findDiff(idx - 1, currSum + arr[idx - 1], totalSum);
        int exclude = findDiff(idx - 1, currSum, totalSum);

        return dp[idx][currSum] = Math.min(include, exclude);
    }

    int getMinDiff() {
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        return findDiff(n, 0, totalSum);
    }
}

public class  MinDiffmemoization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        MinDiffMemoization m = new MinDiffMemoization(n);
        int result = m.getMinDiff();
        System.out.println("The minimum difference between subset sums is: " + result);
    }
}

