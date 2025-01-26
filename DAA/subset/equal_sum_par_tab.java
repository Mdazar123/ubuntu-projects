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
        int i,j;
        for(i=0;i<=n;i++){
            for(j=0;j<=w;j++){
                if(j==0){
                    a[i][j]=true;
                }
        
                if(i==0){
                    a[i][j]=false;
                }
        
                if(wt[i-1]<=j){
                    a[i][j]=equal_tab(wt,i, j-wt[i-1])||equal_tab(wt,i-1, j);
                }
        
                else{
                    a[i][j]=equal_tab(wt,i-1, j);
                }
            }
        }
        return a[n][w];
    }
}
public class equal_sum_par_tab {
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
        sc.close();
    }
}

