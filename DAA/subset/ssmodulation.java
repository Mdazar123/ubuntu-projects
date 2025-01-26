// package subset;
import java.util.Scanner;

class subsets{

  int wt[];
  int w;
  int n;
  int a[][];
  public subsets(int n,int w){
    this.w=w;
    this.n=n;
    wt=new int[n];
    a=new int[n+1][w+1];
    for(int i=0;i<=n;i++){
      for(int j=0;j<=w;j++){
        a[i][j]=-1;
      }
    }

  }
  
  void readinputs(){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the wt elements :");
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
    }
  }

  int ssubsum(int n,int w){
    if(a[n][w]!=-1){
      return a[n][w];
    }
    if(w==0){
      return a[n][w]=1;
    }
    if(n==0){
      return a[n][w]=0;
    }
    if(wt[n-1]<=w){
      
      int num1=ssubsum(n-1, w-wt[n-1]);
      int num2=ssubsum(n-1, w);
      if(num1==1 || num2==1){
        return a[n][w]=1;
      }
      else{
        return a[n][w]=0;
      }
    }
    else{
      return a[n][w]=ssubsum(n-1,w);
    }
    
  }
}

public class ssmodulation{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println("enter subset sum value :");
    int w=sc.nextInt();
    subsets s=new subsets(n, w);
    s.readinputs();
    System.out.println(s.ssubsum(n, w));
    
  }
  
  
}

