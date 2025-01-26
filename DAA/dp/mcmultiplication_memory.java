import java.util.Scanner;
class mcmemory{
  int a[];
  int dp[][];
  public mcmemory(int n){
    a=new int[n+1];
    dp=new int[n+1][n+1];
    for(int i=0;i<=n;i++)for(int j=0;j<=n;j++)dp[i][j]=-1;
  }
  void readinputs(int n){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter matrix row column values");
    for(int i=0;i<=n;i++){
      a[i]=sc.nextInt();
    }
  }

  int mcm(int i,int j){
    if(dp[i][j] != -1){
      return dp[i][j];
    }
    if(i==j)return dp[i][j]=0;
    int min=Integer.MAX_VALUE;
    int val=0;
    for(int k=i;k<j;k++){
      val=mcm(i,k)+mcm(k+1,j)+a[i-1]*a[j]*a[k];
      if(val<min){
        min=val;
      }
    }
    return dp[i][j]=min;

  }
}

public class mcmultiplication_memory {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter no.of matrices for multiplication");
    int n=sc.nextInt();
    mcmemory mc= new mcmemory(n);
    mc.readinputs(n);
    System.out.println(mc.mcm(1, n));
  }
  
}
