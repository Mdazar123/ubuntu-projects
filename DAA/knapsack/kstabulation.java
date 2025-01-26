import java.util.Scanner;

class kstable{
  int[] wt;
  int[] val;
  int[][] a;
  kstable(int n,int w){
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
    for(int i=0;i<=n;i++){
      for(int j=0;j<=w;j++){
        if(i==0 || j==0){
          a[i][j]=0;
          continue;
        }
        if(wt[i-1]<=j){
          a[i][j]=Math.max(val[i-1]+a[i-1][j-wt[i-1]],a[i-1][j]);

        }
        else{
          a[i][j]=a[i-1][j];
        }
      }
    }
    return a[n][w];
  }

}
class kstabulation{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println("enter w :");
    int w=sc.nextInt();
    kstable kt=new kstable(n,w);
    kt.readinputs(n);
    System.out.println(kt.ks(n, w));
  }
}

