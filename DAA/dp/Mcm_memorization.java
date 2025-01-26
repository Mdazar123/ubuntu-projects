import java.util.Scanner;

class matrixmemory{
  int n;
  int a[];
  int dp[][];
  public matrixmemory(int n){
    this.n=n;
    a=new int[n+1];
    dp=new int[n+1][n+1];
    for(int i=0;i<=n;i++){
      for(int j=0;j<=n;j++){
        dp[i][j]=-1;
      }
    }

  }
  void readinputs(){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter row adn col values of matrices ");
    for(int i=0;i<=n;i++){
      a[i]=sc.nextInt();
    }

  }
  int mcm(int i,int j){
    if(dp[i][j] != -1){
      return dp[i][j];
    }
    if(i==j)
    return dp[i][j]=0;
    int min=Integer.MAX_VALUE;
    for(int k=i;k<j;k++){
      int val=mcm(i,k)+mcm(k+1,j)+a[i-1]*a[j]*a[k];
      if(val<min){
        min=val;
      }
    }
    return dp[i][j]=min;
  }
}

public class Mcm_memorization {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter n value");
    int n=sc.nextInt();
    matrixmemory mm=new matrixmemory(n);
    mm.readinputs();
    System.out.println(mm.mcm(1, n));
    
  }
  
}
