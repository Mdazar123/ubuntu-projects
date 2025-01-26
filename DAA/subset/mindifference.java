import java.util.Scanner;

class MinDiff {
    int n;
    int[] arr;
    int minDiff;

    public MinDiff(int n) {
        this.n = n;
        arr = new int[n];
        minDiff = Integer.MAX_VALUE;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    int findDiff(int idx, int currSum, int totalSum) {
        if (idx == 0) {
            int remSum = totalSum - currSum;
            minDiff = Math.min(minDiff, Math.abs(remSum - currSum));
            return minDiff;
        }
        findDiff(idx - 1, currSum + arr[idx - 1], totalSum);
        findDiff(idx - 1, currSum, totalSum);
        return minDiff;
    }
}

public class mindifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        MinDiff m = new MinDiff(n);

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += m.arr[i];
        }

        int result = m.findDiff(n, 0, totalSum);
        System.out.println("The minimum difference between subset sums is: " + result);
    }
}
