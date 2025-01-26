// package subset;
import java.util.Scanner;

class subset{
  int wt[];
  public subset(int n){
    wt=new int[n];

  }
  void readinputs(int n){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the wt elements :");
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
    }
  }

  int ssub(int n,int w){
    if(w==0){
      return 1;
    }
    if(n==0){
      return 0;
    }
    if(wt[n-1]<=w){
      return ssub(n-1, w-wt[n-1]) + ssub(n-1, w);
    }
    else{
      return ssub(n-1,w);
    }
  }
}

public class countsubset{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    subset s=new subset(n);
    System.out.println("enter subset sum value :");
    int w=sc.nextInt();
    s.readinputs(n);
    System.out.println(s.ssub(n, w));
    

  }
  
}
