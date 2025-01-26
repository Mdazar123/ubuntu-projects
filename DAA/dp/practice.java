import java.util.Scanner;

class mmcm{
  int n;
  int a[];
  int dp[][];
  public mmcm(int n){
    this.n=n;
    a=new int[n+1];
    dp=new int[n+1][n+1];
    // for(int i=0;i<=n;i++)for(int j=0;j<=n;j++)dp[i][j]=-1;
    Scanner sc=new Scanner(System.in);
    System.out.println("enter rows and cols of marices :");
    for(int i=0;i<=n;i++){
      a[i]=sc.nextInt();
    }
  }
  void mcm(){
    for(int l=0;l<n;l++){
      for(int i=1;i<=n-l;i++){
        int j=i+l;
        if(i==j){
          dp[i][j]=0;
          continue;
        }
        int min=Integer.MAX_VALUE;
        int val=0;
        for(int k=i;k<j;k++){
          val=dp[i][k]+dp[k+1][j]+a[i-1]*a[j]*a[k];
          if(val<min){
            min=val;
          }
        }
        dp[i][j]=min;
      }
    }
    System.out.println(dp[1][n]);
  }
}


public class practice{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter matrics count");
    int n=sc.nextInt();
    mmcm mc=new mmcm(n);
    mc.mcm();

  }
}