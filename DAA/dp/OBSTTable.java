
class ObstTable{
    int n;
    int keys[];
    int freq[];
    int a[][];
    ObstTable(int n, int keys[], int freq[]){
        this.n = n;
        this.keys = keys;
        this.freq = freq;
        a = new int[n+2][n+2];
        System.out.println(fill(1, n));
    }
    int fill(int i, int j){
        for(int l=0; l<j; l++){
            for(int row=i; row<=j-l; row++){
                int col = l+row;
                int min = Integer.MAX_VALUE;
                if(row > col){
                    a[row][col] = 0;
                    continue;
                }
                if(row == col){
                    a[row][col] = freq[row];
                    continue;
                }
                for(int k=row; k<=col; k++){
                    int val = a[row][k-1] + a[k+1][col] + sum(row, col);
                    if(val < min){
                        min = val;
                    }
                }
                a[row][col] = min;
            }
        }
        return a[1][n];
    }
    int sum(int m, int n){
        int sum = 0;
        for(int i=m; i<=n; i++){
            sum += freq[i];
        }
        return sum;
    }
}
public class OBSTTable {
    public static void main(String[] args) {
        int n = 3;
        int keys[] = {0, 10, 12, 20};
        int freq[] = {0, 34, 8, 50};
        new ObstTable(n, keys, freq);
    }
}
