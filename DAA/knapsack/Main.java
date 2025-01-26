import java.util.Scanner;
class knapsac {
  int[] wt;
  int[] val;
  knapsac(int n){
    wt=new int[n];
    val=new int[n];
  }
  void readinputs(int n){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter wt's");
    for(int i=0;i<n;i++){
      wt[i]=sc.nextInt();
    }
    System.out.println("enter val corresponds to wt");
    for(int i=0;i<n;i++){
      val[i]=sc.nextInt();
    }
  }
  int ks(int n,int w){
    if(n==0 || w==0)
    return 0;
    if(wt[n-1]<=w){
      return Math.max(val[n-1]+ks(n-1,w-wt[n-1]),ks(n-1,w));
    }
    else{
      return ks(n-1,w);
    }
  }

  
}


class Main{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    knapsac k=new knapsac(n);
    k.readinputs(n);
    System.out.println("enter w :");
    int w=sc.nextInt();
    System.out.println(k.ks(n, w));
    
  }

}
