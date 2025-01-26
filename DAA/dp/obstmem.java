import java.util.Scanner;  

class btree{
  int n;
  int key[];
  int freq[];
  int a[][];

  public btree(int n){
    this.n=n;
    key=new int[n];
    freq=new int[n];
    a=new int[n+1][n+1];
    for(int i=0;i<=n;i++)for(int j=0;j<=n;j++)a[i][j]=-1;

  }

  void readinputs(){
    Scanner sc=new Scanner(System.in);
    for(int i=1;i<=n;i++){
      key[i-1]=i;
    }
    System.out.println("enter frequency values");
    for(int i=0;i<n;i++){
      freq[i]=sc.nextInt();
    }
  }

  int obst(int i,int j){
    if(a[i][j] != -1){
      return a[i][j];
    }
    if(i==j){
       return a[i][j] = freq[i];
    }
    if(i>j){
       return a[i][j] = 0;
    }
    int min=Integer.MAX_VALUE;
    int val=0;
    for(int k=i;k<=j;k++){
      val=obst(i,k-1)+obst(k+1,j)+sum(i,j);
      if(val<min){
        min=val;
      }
    }
    return a[i][j]=min;
  }

  int sum(int m,int n){
    int sum=0;
    for(int i=m;i<=n;i++){
      sum+=freq[i];
    }
    return sum;
    
  }
}


public class obstmem{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter n value");
    int n=sc.nextInt();
    btree b=new btree(n);
    b.readinputs();;
    System.out.println(b.obst(1, n-1));
    
  }
  
}
