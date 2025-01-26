import java.util.Scanner;

public class numpattern {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter n value");
    int n=sc.nextInt();
    int a[][]=new int[n][n];
    for(int i=0;i<n;i++)for(int j=0;j<n;j++)a[i][j]=0;
    int l=1;
    int j=0;
    for(int k=0;k<n;k++){
      for(int i=0;i<n-k;i++){
        j=i+k;
        a[i][j]=l++;
        
      }
    }
    for(int i=0;i<n;i++){

      for(int k=0;k<n;k++){
        System.out.print(a[i][k]+"\t");
      }
      System.out.println("\n");
    }


  }

}
