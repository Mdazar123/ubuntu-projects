import java.util.*;

class coin{
    int n,w;
    int wt[];

    public coin(int n,int w){
        this.n=n;
        this.w=w;
        wt=new int[n];
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter weights");
        for(i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
    }

    int change(int n,int w){
        if(w==0){
            return 1;
        }

        if(n==0){
            return 0;
        }

        if(wt[n-1]<=w){
            return change(n,w-wt[n-1])+change(n-1,w);
        }

        else{
            return change(n-1, w);
        }
    }
}
public class coin_change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,w;
        System.out.println("Enter array size");
        n=sc.nextInt();
        System.out.println("Enter weight:");
        w=sc.nextInt();
        coin c = new coin(n, w);
        System.out.println(c.change(n, w));
    }
}
