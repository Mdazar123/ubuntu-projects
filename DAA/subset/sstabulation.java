import java.util.Scanner;

class subsett {
  int wt[];
  boolean a[][];

  public subsett(int n, int w) {
    wt = new int[n];
    a = new boolean[n + 1][w + 1];

  }

  void readinputs(int n) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the wt elements :");
    for (int i = 0; i < n; i++) {
      wt[i] = sc.nextInt();
    }
  }

  void ssubsumt(int n, int w) {
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= w; j++) {
        if (j == 0) {
          a[i][j] = true;
          continue;
        }
        if (i == 0) {
          a[i][j] = false;
          continue;
        }
        if (wt[i - 1] <= j) {
          a[i][j] = (a[i - 1][j - wt[i - 1]] || a[i - 1][j]);
        } else {
          a[i][j] = a[i - 1][j];
        }
      }
    }
    System.out.println(a[n][w]);

  }
}

public class sstabulation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println("enter w value");
    int w = sc.nextInt();
    subsett t = new subsett(n, w);
    t.readinputs(n);
    // System.out.println(t.ssubsumt(n, w));
    t.ssubsumt(n, w);

  }

}
