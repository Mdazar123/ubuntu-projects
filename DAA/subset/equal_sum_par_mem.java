import java.util.*;
import java.math.*;

class partition_mem{
    int n,w;
    int wt[];
    boolean a[][];
    
    public partition_mem(int n,int w){
        this.n=n;
        this.w=w;
        a=new boolean[n+1][w+1];
    }

    boolean equal_tab(int wt[],int n,int w){
        if(a[n][w]!=false){
            return a[n][w];
        }
        if(w==0){
            return a[n][w]=true;
        }

        if(n==0){
            return a[n][w]=false;
        }

        if(wt[n-1]<=w){
            return a[n][w]=equal_tab(wt,n, w-wt[n-1])||equal_tab(wt,n-1, w);
        }

        else{
            return a[n][w]=equal_tab(wt,n-1, w);
        }
    }
}
public class equal_sum_par_mem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,w=0,i;
        System.out.println("Enter array size");
        n=sc.nextInt();
        System.out.println("Enter weights");
        int wt[]=new int[n];
        for(i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(i=0;i<n;i++){
            w=w+wt[i];
        }
        if(w%2==1){
            System.out.println("Equal sum partion is not possible");
        } 
        
        else if(w%2==0){
            w=w/2;
            partition_mem p = new partition_mem(n, w);
            boolean result=p.equal_tab(wt,n, w);
            if(result==true){
                System.out.println("Equal sum partition is possible");
            }

            else{
                System.out.println("Equal sum partition is not possible");
            }
        }
    }
}

