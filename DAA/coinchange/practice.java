import java.util.Scanner;

class point{
  int n,w;
  int wt[];
  int m=Integer.MAX_VALUE;
  public point(int n,int w){
    this.n=n;
    this.w=w;
    wt=new int[n];
    Scanner sc=new Scanner(System.in);
    System.out.println("enter wt values :");
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
    }
  }
  int coinc(int n,int w){
    if(w==0){
      return 0;
    }
    if(n==0){
      return m-1000;
    }
    if(wt[n-1]<=w){
      return Math.min(1+coinc(n,w-wt[n-1]),coinc(n-1,w));
    }
    else{
      return coinc(n-1,w);
    }
  }
}

public class practice{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter n value ");
    int n=sc.nextInt();
    System.out.println("enter coin sum ");
    int w=sc.nextInt();
    point p=new point(n, w);
    System.out.println(p.coinc(n, w));

  }
}