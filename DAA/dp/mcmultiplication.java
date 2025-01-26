import java.util.Scanner;
class multimc{
  int a[];
  public multimc(int n){
    a=new int[n+1];
  }
  void readinputs(int n){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter matrix row column values");
    for(int i=0;i<=n;i++){
      a[i]=sc.nextInt();
    }
  }

  int mcm(int i,int j){
    if(i==j)return 0;
    int min=Integer.MAX_VALUE;
    int val=0;
    for(int k=i;k<j;k++){
      val=mcm(i,k)+mcm(k+1,j)+a[i-1]*a[j]*a[k];
      if(val<min){
        min=val;
      }
    }
    return min;

  }
}

public class mcmultiplication {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter no.of matrices for multiplication");
    int n=sc.nextInt();
    multimc mc= new multimc(n);
    mc.readinputs(n);
    System.out.println(mc.mcm(1, n));
  }
  
}
