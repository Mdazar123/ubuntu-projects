import java.util.*;
import java.math.*;
import java.io.*;

class change1{
    int n,w;
    int [] wt;
    int m=Integer.MAX_VALUE;

    public change1(int n,int w){
        this.n=n;
        this.w=w;
        wt=new int[n];
        Scanner sc = new Scanner(System.in);
        int i;
        System.out.println("Enter weights");
        for(i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
    }

    int mc(int n,int w){
        if(w==0){
            return 0;
        }

        if(n==0){
            return m-1000;
        }

        if(wt[n-1]<=w){
            return Math.min((1+mc(n,w-wt[n-1])),mc(n-1,w));
        }

        else{
            return mc(n-1,w);
        }
    }
}
public class min_change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,w;
        System.out.println("Enter array size");
        n=sc.nextInt();
        System.out.println("Enter weight");
        w=sc.nextInt();
        change1 c = new change1(n, w);
        System.out.println(c.mc(n,w));
    }
}
