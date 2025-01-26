// package subset;
import java.util.Scanner;

class subset{
  int wt[];
  int w;
  int n;
  public subset(int n,int w){
    this.w=w;
    this.n=n;
    wt=new int[n];

  }
  
  void readinputs(){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the wt elements :");
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
    }
  }

  boolean ssub(int n,int w){
    if(w==0){
      return true;
    }
    if(n==0){
      return false;
    }
    if(wt[n-1]<=w){
      return (ssub(n-1, w-wt[n-1]) || ssub(n-1, w));
    }
    else{
      return ssub(n-1,w);
    }
  }
}

public class subsetsum{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println("enter subset sum value :");
    int w=sc.nextInt();
    subset s=new subset(n, w);
    s.readinputs();
    System.out.println(s.ssub(n, w));
    

  }
  
}
