// package subset;
import java.util.Scanner;

class coinc{
  int wt[];
  public coinc(int n){
    wt=new int[n];

  }
  void readinputs(int n){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the wt elements :");
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
    }
  }

  int cchange(int n,int w){
    if(w==0){
      return 1;
    }
    if(n==0){
      return 0;
    }
    if(wt[n-1]<=w){
      return cchange(n, w-wt[n-1]) + cchange(n-1, w);
    }
    else{
      return cchange(n-1,w);
    }
  }
}

public class coinchange{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    coinc c=new coinc(n);
    System.out.println("enter subset sum value :");
    int w=sc.nextInt();
    c.readinputs(n);
    System.out.println(c.cchange(n, w));
    

  }
  
}

