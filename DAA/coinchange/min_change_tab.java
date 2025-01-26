import java.util.*;
import java.math.*;
import java.io.*;

class change_tab{
    int n,w;
    int wt[];
    int a[][];
    int m=Integer.MAX_VALUE;

    public change_tab(int n,int w){
        this.n=n;
        this.w=w;
        wt=new int[n];
        a=new int[n+1][w+1];

        Scanner sc = new Scanner(System.in);
        int i,j;
        System.out.println("Enter weights");
        for(i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }

        for(i=0;i<=n;i++){
            for(j=0;j<=w;j++){
                a[i][j]=-1;
            }
        }
    }

    int ct(int n,int w){
        int i,j;
        for(i=0;i<=n;i++){
            for(j=0;j<=w;j++){
                if(j==0){
                    a[i][j]=0;
                    continue;
                }

                if(i==0){
                    a[i][j]=m-1000;
                    continue;
                }

                if(wt[i-1]<=j){
                    a[i][j]=Math.min(1+ct(i, j-wt[i-1]),ct(i-1, j));
                }

                else{
                    a[i][j]=ct(i-1, j);
                }
            }
        }
        return a[n][w];
    }
}
public class min_change_tab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,w;
        System.out.println("Enter array size");
        n=sc.nextInt();
        System.out.println("Enter weight");
        w=sc.nextInt();
        change_tab c = new change_tab(n, w);
        System.out.println(c.ct(n, w));
    }
}
