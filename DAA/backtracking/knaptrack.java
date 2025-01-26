import java.util.*;

class knap {
  int wt[];
  int val[];
  int a[];
  int n;
  int w = 0;

  public knap(int n, int w) {
    this.n = n;
    this.w = w;
    a = new int[n];
    wt = new int[n];
    val = new int[n];
    Scanner sc = new Scanner(System.in);
    System.out.println("enter wt array values");
    for (int i = 0; i < n; i++) {
      wt[i] = sc.nextInt();
    }
    System.out.println("enter val array elements : ");
    for (int i = 0; i < n; i++) {
      val[i] = sc.nextInt();
    }
  }

  int min = Integer.MIN_VALUE;
  void fill(int n, int k) {
    if (k == n) {
      int value=0;
      int sum = 0;
      for (int i = 0; i < n; i++) {
        if (a[i] == 1) {
          sum += wt[i];
        }
      }
      if (sum <= w){
        for(int i=0;i<n;i++){
          if(a[i]==1){
            value+=val[i];
          }
        }
        if(value>min){
          min=value;
        }
      }
        return;
    }
    for (int i = 0; i <= 1; i++) {
      a[k] = i;
      fill(n, k + 1);
    }
  }
}

public class knaptrack {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    // sc.nextLine();
    System.out.println("enter max weight value");
    int w = sc.nextInt();
    knap b = new knap(n, w);
    b.fill(n, 0);
    System.out.println("max val can be earned : " + b.min);

  }
}
