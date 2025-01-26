import java.util.Scanner;

class obstt {
    int n;
    int[] key;
    int[] freq;
    int[][] a;

    public obstt(int n) {
        this.n = n;
        key = new int[n];
        freq = new int[n];
        a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = -1;
            }
            
        }

    }

    void readInputs() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            key[i] = i + 1;
        }
        System.out.println("Enter frequency values:");
        for (int i = 0; i < n; i++) {
            freq[i] = sc.nextInt();
        }
    }

    int obst() {
        
        for (int i = 0; i < n; i++){
            a[i][i] = freq[i];
        }
        for (int l = 2; l <= n; l++){ 
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                int min = Integer.MAX_VALUE;

                int freqSum = sum(i, j);
                for (int k = i; k <= j; k++) {
                    int cost = (k > i ? a[i][k - 1] : 0) + (k < j ? a[k + 1][j] : 0) + freqSum;
                    if(cost<min){
                        min=cost;
                    }
                }
                a[i][j] = min;
            }
        }

        return a[1][n - 1];
    }

    int sum(int m, int n) {
        int sum = 0;
        for (int i = m; i <= n; i++) {
            sum += freq[i];
        }
        return sum;
    }
}

public class obsttabulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value:");
        int n = sc.nextInt();
        obstt b = new obstt(n);
        b.readInputs();
        System.out.println(b.obst());
    }
}
