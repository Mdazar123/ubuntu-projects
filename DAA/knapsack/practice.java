import  java.util.Scanner;

class point{
  int n,w;
  int wt[];
  int val[];
  int a[][];
  public point(int n,int w){
    this.n=n;
    this.w=w;
    wt=new int[n];
    val=new int[n];
    a=new int[n+1][w+1];
    for(int i=0;i<=n;i++)for(int j=0;j<=w;j++)a[i][j]=-1;
  }
  void readinputs(){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter wt's values");
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
    }
    System.out.println("enter val's values");
    for(int i=0;i<n;i++){
      val[i]=sc.nextInt();
    }
  }
  void ks(){
    for(int i=0;i<=n;i++){
      for(int j=0;j<=w;j++){
        if(i==0|| j==0){
          a[i][j]=0;
          continue;
        }
        if(wt[i-1]<=j){
          a[i][j]=Math.max(val[i-1]+a[i][j-wt[i-1]],a[i-1][j]);
        }
        else{
          a[i][j]=a[i-1][j];
        }
      }
    }
    System.out.println(a[n][w]);
  }
}

public class practice{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter n value ");
    int n=sc.nextInt();
    System.out.println("enter w value ");
    int w=sc.nextInt();
    point p=new point(n, w);
    p.readinputs();
    p.ks();

  }
}
