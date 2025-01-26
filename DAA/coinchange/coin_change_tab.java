import java.util.*;

class coin_tab{
    int n;
    int w;
    int wt[];
    int a[][];

    public coin_tab(int n,int w){
        this.n=n;
        this.w=w;
        wt=new int[n];
        a=new int[n+1][w+1];
        Scanner sc = new Scanner(System.in);
        int i,j;
        System.out.println("Enter array size");
        for(i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }

        for(i=0;i<=n;i++){
            for(j=0;j<=w;j++){
                a[i][j]=-1;
            }
        }
    }

    int cc(int n,int w){
        int i,j;
        for(i=0;i<=n;i++){
            for(j=0;j<=w;j++){
                if(j==0){
                    a[i][j]=1;
                    continue;
                }

                if(i==0){
                    a[i][j]=0;
                    continue;
                }

                if(wt[i-1]<=j){
                    a[i][j]=a[i][j-wt[i-1]]+a[i-1][j];
                }

                else{
                    a[i][j]=a[i-1][j];
                }
            }
        }
        return a[n][w];
    }
}
public class coin_change_tab {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,w;
        System.out.println("Enter array size");
        n=sc.nextInt();
        System.out.println("Enter weight");
        w=sc.nextInt();
        coin_tab c = new coin_tab(n, w);
        System.out.println(c.cc(n, w));
    }
}
