import java.util.*;

class queens{
    int n;
    int a[];

    public queens(int n){
        this.n=n;
        a=new int[n+1];
    }

    void fill(int n,int k){
        if(k>n){
            for(int i=1;i<=n;i++){
                System.out.print(i);
            }
            System.out.println();
            for(int i=1;i<=n;i++){
                System.out.print(a[i]);
            }
            System.out.println();
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(isSafe(k,i)){
                a[k]=i;
                fill(n,k+1);
            }
        }
    }

    boolean isSafe(int k,int i){
        for(int j=1;j<k;j++){
            if(a[j]==i){
                return false;
            }
            if(Math.abs(k-j)==Math.abs(i-a[j])){
                return false;
            }
        }
        return true;
    }
}
public class n_queens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        // sc.nextLine();
        queens b = new queens(n);
        b.fill(n,1);
    }
}
