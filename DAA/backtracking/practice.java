import java.util.*;
class point{
  int n;
  int a[];
  public point(int n){
    this.n=n;
    a=new int[n+1];
  }
  void fill(int n,int k){
    if(k>n){
      for(int i=1;i<=n;i++){
        System.out.print(i);
      }
      System.out.println("\n");
      for(int i=1;i<=n;i++){
        System.out.print(a[i]);
      }
      System.out.println("\n");
      return;
    }
    for(int i=1;i<=n;i++){
      if(issafe(k,i)){
        a[k]=i;
        fill(n,k+1);
      }
    }
  }
  boolean issafe(int k,int i){
    for(int j=1;j<k;j++){
      if(a[j]==i){
        return false;
      }
      if(Math.abs(k-j)==Math.abs(i-a[j])){
        return false;
      }
    }
    return true;
  }
}
public class practice{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    point q= new point(n);
    q.fill(n,1); 
  }
}