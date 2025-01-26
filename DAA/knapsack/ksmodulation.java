import java.util.Scanner;

class ksmemory{
  int[] wt;
  int[] val;
  int[][] a;
  ksmemory(int n,int w){
    wt=new int[n];
    val=new int[n];
    a=new int[n+1][w+1];

    for(int i=0;i<=n;i++){
      for(int j=0;j<=w;j++){
          a[i][j]=-1;
      }
    }
  }
  void readinputs(int n){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter wt's");
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
    }
    System.out.println("enter val corresponds to wt");
    for(int i=0;i<n;i++){
      val[i]=sc.nextInt();
    }
  }
  int ks(int n,int w){
    if(a[n][w] != -1){
      return a[n][w];
    }
    if(n==0 || w==0){
      return a[n][w]=0;
    }
    if(wt[n-1]<=w){
      return a[n][w]=Math.max(val[n-1]+ks(n-1,w-wt[n-1]),ks(n-1,w));
    }
    else{
      return a[n][w]=ks(n-1,w);
    }
  }

}
class ksmodulation{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println("enter w :");
    int w=sc.nextInt();
    ksmemory ks=new ksmemory(n,w);
    ks.readinputs(n);
    System.out.println(ks.ks(n, w));
  }
}

