import java.util.*;
import java.math.*;
class knapsack1 {
    int[] val;
    int[] wt;
    int w;
    int n;

    public knapsack1(int n,int w){
        this.n=n;
        this.w=w;
        val=new int[n];
        wt=new int[n]; 
    }

    int knap(int n,int w){
        if(n==0||w==0){
            return 0;
        }
        if(wt[n-1]<=w){
            return Math.max(val[n-1]+knap(n,w-wt[n-1]),knap(n-1,w));
        }

        else{
            return knap(n-1,w);
        }
    }
}

class knapsack_unbounded_recursion{
    public static void main(String args[]){
        int n,w;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size");
        n=sc.nextInt();
        System.out.println("Enter Bag wait");
        w=sc.nextInt();
        knapsack1 k = new knapsack1(n,w);
        System.out.println("Enter weights of items:");
        int i;
        for(i=0;i<n;i++){
            k.wt[i]=sc.nextInt();
        }
        System.out.println("Enter values of items:");
        for(i=0;i<n;i++){
            k.val[i]=sc.nextInt();
        }
        System.out.println(k.knap(n,w));
    }
}
