import java.util.Scanner;
class fibno{
  int[] a;
  public fibno(int n){
    a=new int[n+1];
  }
  int fib(int n){
    for(int i=0;i<=n;i++){
      if(i==0 || i==1){
        a[i]=1;
      }
      else{
        a[i]=a[i-1]+a[i-2];
      }

    }
    return a[n];
  }
}

public class tabulationfib {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    fibno f=new fibno(n);
    
    System.out.println(f.fib(n));
  }
}
