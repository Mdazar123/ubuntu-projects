import java.util.Scanner;

class Knapsack {
    int[] wt;
    int[] val;
    int n,w;
    int maxVal=0;

    Knapsack(int n,int w) {
        this.n=n;
        this.w=w;
        wt = new int[n];
        val = new int[n];
    }

    void readInputs(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        System.out.println("Enter values corresponding to weights:");
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
    }

    void knapsackBacktrack(int cidx, int cwt, int cval) {
        if (cidx == n || cwt > w) {
            return;
        }

        if (cwt <= w) {
            maxVal = Math.max(maxVal, cval);
        }

        knapsackBacktrack(cidx + 1, cwt, cval);

        knapsackBacktrack(cidx + 1, cwt + wt[cidx], cval + val[cidx]);
    }

    int ks(int n, int w) {
        knapsackBacktrack(0, 0, 0);
        return maxVal;
    }
}

public class file {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        System.out.print("Enter maximum weight: ");
        int w = sc.nextInt();
        Knapsack k = new Knapsack(n,w);
        k.readInputs(n);
        System.out.println("Maximum value that can be obtained: " + k.ks(n, w));
    }
}

