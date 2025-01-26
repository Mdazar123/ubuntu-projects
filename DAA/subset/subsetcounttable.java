// package subset;
import java.util.Scanner;

class subsetctable{
  int wt[];
  int a[][];

  public subsetctable(int n,int w){

    wt=new int[n];
    a=new int[n+1][w+1];

  }
  void readinputs(int n){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the wt elements :");
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
    }
  }

  int ssub(int n,int w){
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= w; j++) {
        if (j == 0) {
          a[i][j] = 1;
          continue;
        }
        if (i == 0) {
          a[i][j] = 0;
          continue;
        }
        if (wt[i - 1] <= j) {
          a[i][j] = (a[i - 1][j - wt[i - 1]] + a[i - 1][j]);
        } else {
          a[i][j] = a[i - 1][j];
        }
      }
    }
   return (a[n][w]);

  }
}

public class subsetcounttable{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println("enter subset sum value :");
    int w=sc.nextInt();
    subsetctable sct=new subsetctable(n,w);
    sct.readinputs(n);
    System.out.println(sct.ssub(n, w));
  }
  
}
