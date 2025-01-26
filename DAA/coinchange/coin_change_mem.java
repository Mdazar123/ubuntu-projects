import java.util.*;

class change{
    int n,w;
    int wt[];
    int a[][];

    public change(int n,int w){
        this.n=n;
        this.w=w;
        wt=new int[n];
        a=new int[n+1][w+1];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Weights");
        int i,j;
        for(i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(i=0;i<=n;i++){
            for(j=0;j<=w;j++){
                a[i][j]=-1;
            }
        }
    }

    int coin(int n,int w){
        if(a[n][w]!=-1){
            return a[n][w];
        }

        if(w==0){
            return a[n][w]=1; 
        }

        if(n==0){
            return a[n][w]=0;
        }

        if(wt[n-1]<=w){
            return a[n][w]=coin(n, w-wt[n-1])+coin(n-1, w);
        }

        else{
            return a[n][w]=coin(n-1,w);
        }
    }
}
public class coin_change_mem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,w;
        System.out.println("Enter array size");
        n=sc.nextInt();
        System.out.println("Enter weights");
        w=sc.nextInt();
        change c= new change(n, w);
        System.out.println(c.coin(n, w));
    }
}
