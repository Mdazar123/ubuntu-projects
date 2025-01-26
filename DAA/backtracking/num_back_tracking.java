import java.util.*;

class number{
    int a[];
    int n;
    int count=0;

    public number(int n){
        this.n=n;
        a=new int[n];
    }

    void fill(int n,int k){
        if(k==n){
            for(int i=0;i<n;i++)System.out.print(a[i]);
            System.out.println();
            return;
        }
        for(int i=0;i<=3;i++){
            a[k]=i;
            fill(n,k+1);
        }
    }
}
public class num_back_tracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        //sc.nextLine();
        number b = new number(n);
        b.fill(n,0);
        System.out.println(b.count);
    }
}

