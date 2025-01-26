import java.util.Scanner;

class cycle {
  int ele[];
  int adj[][];
  int n;

  public cycle(int n) {
    this.n = n;
    ele = new int[n];
    ele[0] = 0;
    adj = new int[n][n];
  }

  void readinputs() {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter adjacency matrix of a graph");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        adj[i][j] = sc.nextInt();
      }

    }
  }

  boolean issafe(int k, int i) {
      if (adj[ele[k - 1]][i] != 1) {
        return false;
      }
    for (int j = 1; j < k; j++) {
      if (ele[j] == i) {
        return false;
      }
    }
    if (k == (n - 1) && adj[i][0] != 1) {
      return false;
    }
    return true;
  }

  void fill(int n, int k) {
    if (k >= n) {
      // System.out.print("in print function\t");
      for (int i = 0; i < n; i++) {
        System.out.print(ele[i] + "\t");
      }
      System.out.println('\n');
      return;
    }
    for (int i = 1; i < n; i++) {
      // System.out.print("inside iteration\t");

      if (issafe(k, i)) {
        ele[k] = i;
        fill(n, k + 1);
      }
    }
  }

}

public class hamiltoniancycle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter n value :");
    int n = sc.nextInt();
    cycle hc = new cycle(n);
    hc.readinputs();
    hc.fill(n, 1);

  }

}
