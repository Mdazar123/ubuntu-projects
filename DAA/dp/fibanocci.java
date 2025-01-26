import java.util.Scanner;
class fibano {
  int[] a;
  public fibano(int n){
    a=new int[n+1];
    for(int i=0;i<=n;i++){
      a[i]=-1;
    }
  }

  int fib(int n){
    if(a[n] != -1){
      return a[n];
    }
    if(n==0 || n==1){
      return a[n]=1;
    }else{
      return a[n]=fib(n-1)+fib(n-2);
    }

  } 
}
class fibanocci{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n;
    System.out.println("enter the value of n :");
    n=sc.nextInt();
    fibano f=new fibano(n);
    System.out.println(f.fib(n));
  }
}
