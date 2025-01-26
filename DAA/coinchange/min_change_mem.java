import java.util.*;
import java.math.*;
import java.io.*;

class change_mem{
    int n,w;
    int wt[];
    int a[][];
    int m=Integer.MAX_VALUE;

    public change_mem(int n,int w){
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

    int cm(int n,int w){
        if(a[n][w]!=-1){
            return a[n][w];
        }

        if(w==0){
            return a[n][w]=0;
        }

        if(n==0){
            return a[n][w]=m-100; 
        }

        if(wt[n-1]<=w){
            return a[n][w]=Math.min(1+cm(n, w-wt[n-1]),cm(n-1, w));
        }

        else{
            return a[n][w]=cm(n-1,w);
        }
    }
}
public class min_change_mem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,w;
        System.out.println("Enter array size");
        n=sc.nextInt();
        System.out.println("Enter weight");
        w=sc.nextInt();
        change_mem c = new change_mem(n, w);
        System.out.println(c.cm(n,w));
    }
}
