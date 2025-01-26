import java.util.*;
class  knapscak_non{
    int n,w;
    int val[];
    int wt[];
    int[][] a;
    public knapscak_non(int n,int w){
        this.n=n;
        this.w=w;
        val=new int[n];
        wt=new int[n];
        a=new int[n+1][w+1];
        int i,j;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter values of the items");
        for(i=0;i<n;i++){
            val[i]=sc.nextInt();
        }

        System.out.println("enter weights of the items");
        for(i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        
        for(i=0;i<=n;i++){
            for(j=0;j<=w;j++){
                a[i][j]=-1;
            }
        }
    } 

    int knap(int n,int w){
        if(a[n][w]!=-1){
            return a[n][w];
        }
        if(n==0||w==0){
            return a[n][w]=0;
        }
        if(wt[n-1]<=w){
            return a[n][w]=Math.max(val[n-1]+knap(n,w-wt[n-1]),knap(n-1,w));
        }
        else{
            return a[n][w]=knap(n-1,w);
        }
    }
}

class kanpsack_un_mem{
    public static void main(String[] args) {
        int n,w;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size:");
        n=sc.nextInt();
        System.out.println("enter total bag weight:");
        w=sc.nextInt();
        knapscak_non k = new knapscak_non(n, w);
        System.out.println(k.knap(n,w));
    }
}
