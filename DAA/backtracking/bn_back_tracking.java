import java.util.*;

class binary_number{
    int a[];
    int n;
    int count=0;

    public binary_number(int n){
        this.n=n;
        a=new int[n];
    }

    void fill(int n,int k){
        if(k==n){
            for(int j=0;j<n;j++){
                System.out.print(a[j]+"  ");
                count++;
            }
            System.out.println();
            return;
        }
        for(int i=0;i<=1;i++){
            if(k==0||a[k-1]==0|| i==0){

                a[k]=i;
                fill(n,k+1);
            }
        }
    }
}
public class bn_back_tracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        //sc.nextLine();
        binary_number b = new binary_number(n);
        b.fill(n,0);
        System.out.println(b.count);
    }
}
