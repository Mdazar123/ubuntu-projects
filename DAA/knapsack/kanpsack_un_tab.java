import java.util.*;
import java.math.*;
class knapscak_tab {
    int val[];
    int wt[];
    int w,n;
    int a[][];

    public knapscak_tab(int n,int w){
        this.n=n;
        this.w=w;
        val=new int[n];
        wt=new int[n];
        a=new int[n+1][w+1];
        int i,j;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of items:");
        for(i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        System.out.println("Enter weights of items:");
        for(i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        for(i=0;i<=n;i++){
            for(j=0;j<=w;j++){
                a[i][j]=-1;
            }
        }
    }

    int ks(int n,int w){
        int i,j;
        for(i=0;i<=n;i++){
            for(j=0;j<=w;j++){
                if(i==0||j==0){
                    a[i][j]=0;
                    continue;
                }
                if(wt[i-1]<=j){
                    a[i][j]=Math.max(val[i-1]+a[i][j-wt[i-1]],a[i-1][j]);
                }
                else{
                    a[i][j]=a[i-1][j];
                }
            }
        }
        return a[n][w];
        }
}

class kanpsack_un_tab{
    public static void main(String[] args) {
        int n,w;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        n=sc.nextInt();
        System.out.println("Enter bag weight");
        w=sc.nextInt();
        knapscak_tab k = new knapscak_tab(n, w);
        System.out.println(k.ks(n,w));
    }
}
