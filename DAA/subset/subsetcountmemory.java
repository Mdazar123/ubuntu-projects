// package subset;
import java.util.Scanner;

class subsetcmem{
  int wt[];
  int[][] a;
  public subsetcmem(int n,int w){
    wt=new int[n];
    a=new int[n+1][w+1];
    for(int i=0;i<=n;i++){
      for(int j=0;j<=w;j++){
        a[i][j]=-1;
      }
    }

  }
  void readinputs(int n){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the wt elements :");
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
    }
  }

  int ssub(int n,int w){
    if(a[n][w] != -1){
      return a[n][w];
    }

    if(w==0){
      return a[n][w]=1;
    }
    if(n==0){
      return a[n][w]=0;
    }
    if(wt[n-1]<=w){
      return a[n][w]=ssub(n-1,w-wt[n-1])+ssub(n-1, w);
    }
    else{
      return a[n][w]=ssub(n-1,w);
    }
  }
}

public class subsetcountmemory{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println("enter subset sum value :");
    int w=sc.nextInt();
    subsetcmem s=new subsetcmem(n,w);
    s.readinputs(n);
    System.out.println(s.ssub(n, w));
    
  }
  
}
