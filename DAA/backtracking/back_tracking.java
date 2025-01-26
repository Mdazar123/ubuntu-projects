import java.util.*;

class tracking{
    private static char[] arr;
    int n;
    char a[];

    public tracking(int n){
        this.n=n;
        Scanner sc = new Scanner(System.in);
        arr=new char[n];
        a=new char[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.next().charAt(0);
        }
    }

    boolean isSafe(int k,char i){
        for(int j=0;j<k;j++){
            if(a[j]==i){
                return false;
            }
        }
        
        return true;
    }

    void fill(int n,int k){
        if(k==n){
            for(int i=0;i<n;i++){
                System.out.print(a[i]);
            }
            System.out.println();
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(isSafe(k,arr[i])){
                a[k]=arr[i];
                fill(n,k+1);
            }
        }
    }
}
public class back_tracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        tracking t = new tracking(n);
        t.fill(n,0);
    }
}
