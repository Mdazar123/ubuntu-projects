import java.util.Scanner;

class matrixtable{
  int n;
  int a[];
  int dp[][];
  public matrixtable(int n){
    this.n=n;
    a=new int[n+1];
    dp=new int[n+1][n+1];

  }
  void readinputs(){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter row adn col values of matrices ");
    for(int i=0;i<=n;i++){
      a[i]=sc.nextInt();
    }
  }
  void mcm(){
    for(int l=0;l<n;l++){
      for(int i=1;i<=n-l;i++){
        int j=i+l;
        int min=Integer.MAX_VALUE;
        int val=0;
        if(i==j){
          dp[i][j]=0;
          continue;
        }
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


public class Mcm_tabulation {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter n value");
    int n=sc.nextInt();
    matrixtable mt=new matrixtable(n);
    mt.readinputs();
    mt.mcm();
    
  }
  
}
