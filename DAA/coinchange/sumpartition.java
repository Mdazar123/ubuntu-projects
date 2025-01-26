import java.util.Scanner;

class partition{
  int wt[];
  int w;
  int n;
  public partition(int n){
    this.n=n;
    wt = new int[n];
  }
  int sum=0;
  void readinputs(int n){
    Scanner sc=new Scanner(System.in);
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
      sum+=wt[i];
    }
  }
  boolean check(){
    if(sum %2 != 0){
      return false;
    }
    else{
      w=sum/2;
      return spartition(n, w);
    }
  }
  boolean spartition(int n,int w){
    if(w==0){
      return true;
    }
    if(n==0){
      return false;
    }
    if(wt[n-1]<=w){
      return  spartition(n-1, w-wt[n-1]) || spartition(n-1, w);
    }
    else{
      return spartition(n-1,w);
    }
  }
  
}

public class sumpartition {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter n value : ");
    int n=sc.nextInt();
    partition p=new partition(n);
    p.readinputs(n);
    System.out.println(p.check());
  }
  
}
