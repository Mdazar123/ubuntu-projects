import java.util.Scanner;

class matrix{
  int n;
  int a[];
  public matrix(int n){
    this.n=n;
    a=new int[n+1];

  }
  void readinputs(){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter row adn col values of matrices ");
    for(int i=0;i<=n;i++){
      a[i]=sc.nextInt();
    }
  }
  int mcm(int i,int j){
    if(i==j)
    return 0;
    int min=Integer.MAX_VALUE;
    for(int k=i;k<j;k++){
      int val=mcm(i,k)+mcm(k+1,j)+a[i-1]*a[j]*a[k];
      if(val<min){
        min=val;
      }
    }
    return min;
  }
}


public class matrixchainmultiplication{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter n value");
    int n=sc.nextInt();
    matrix m=new matrix(n);
    m.readinputs();
    System.out.println(m.mcm(1, n));
    
  }
}