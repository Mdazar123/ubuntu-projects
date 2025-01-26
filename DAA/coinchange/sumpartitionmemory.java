import java.util.Scanner;

class partitiont{
  int wt[];
  int w;
  int n;
  int a[][];
  public partitiont(int n){
    this.n=n;
    wt = new int[n];
    a=new int[n+1][w+1];
    for(int i=0;i<=n;i++){
      for(int j=0;j<=w;j++){
        a[i][j]=-1;
      }
    }
  }
  int sum=0;
  void readinputs(){
    Scanner sc=new Scanner(System.in);
    for(int i=0;i<n;i++)
    {
      wt[i]=sc.nextInt();
      sum+=wt[i];
    }
    
  }
  int check(){
    if(sum %2 != 0){
      return 0;
    }
    else{
      w=sum/2;
      return spartitiont(n, w);
    }
  }
  int spartitiont(int n,int w){
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
      
      int num1=spartitiont(n-1, w-wt[n-1]);
      int num2=spartitiont(n-1, w);
      if(num1==1 || num2==1){
        return 1;
      }
      else{
        return 0;
      }
    }
    else{
      return spartitiont(n-1,w);
    }
  }
  
}


public class sumpartitionmemory {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter n value : ");
    int n=sc.nextInt();
    partitiont pt=new partitiont(n);
    pt.readinputs();
    System.out.println(pt.check());
    
  }
  
}