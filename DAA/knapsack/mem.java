import java.util.*;
class stairs {
    int n;
    int a[];

    public stairs(int n){
        this.n=n;
        a=new int[n+1];
        int i;
        for(i=0;i<=n;i++){
            a[i]=-1;
        }
    }

    int stair(int n){
        if(a[n]!=-1){
            return a[n];
        }
        if(n<=1){
            return a[n]=1;
        }
        else{
            return a[n]=stair(n-1)+stair(n-2);
        }
    }
}

class mem{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        stairs s1 = new stairs(n);
        System.out.println(s1.stair(n));
    }
}
