import java.util.*;

class subsum{
    int ele[];
    int a[];
    int n;
    int targetsum=0;
    int count=0;

    public subsum(int n,int s){
        this.n=n;
        this.targetsum=s;
        a=new int[n];
        ele=new int[n];
        Scanner sc=new Scanner(System.in);
        System.out.println("enter subset values");
        for(int i=0;i<n;i++){
            ele[i]=sc.nextInt();
        }
    }

    void fill(int n,int k){
        if(k==n){
            int sum=0;
            for(int j=0;j<n;j++){
                if(a[j]==1){
                    sum+=ele[j];
                }
            }
            if(sum==targetsum){
                count++;
                for(int j=0;j<n;j++){
                    if(a[j]==1){
                        System.out.print(ele[j]+"\t");
                    }
                }
            }
            System.out.println();
            return;
        }
        for(int i=0;i<=1;i++){
                a[k]=i;
                fill(n,k+1);
        }
    }
}
public class substtrack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        //sc.nextLine();
        System.out.println("enter target sum value");
        int s=sc.nextInt();
        subsum b = new subsum(n,s);
        b.fill(n,0);
        System.out.println("no.of subsets with possible targetsum : "+b.count);
    }
}
