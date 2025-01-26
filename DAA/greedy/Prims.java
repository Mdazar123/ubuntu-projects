// package Greedy;
import java.util.Scanner;;
class InnerPrims {
    int adj[][];
    int n;
    int par[];
    int vis[];
    InnerPrims(int adj[][], int n){
        this.adj = adj;
        this.n = n;
        par = new int[n];
        vis = new int[n];
        vis[0] = 1;
        par[0] = 0;
        for(int i=1; i<n; i++)
        {
            vis[i] = -1;
            par[i] = i;
        }
        findMsp();
    }
    void findMsp(){
        int k = n;
        int p = 0;
        int c = 0;
        while(k>0){
            int min = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                if(vis[i] == 1) {
                    for(int j=0; j<n; j++){
                        if(vis[j] == -1 && adj[i][j] != -1) {
                            if(adj[i][j] < min){
                                p = i;
                                c = j;
                                min = adj[i][j];
                            }
                        }
                    }
                }
            }
            vis[c] = 1;
            par[c] = p;
            k--;
        }
        System.out.println("par - child ");
        for(int i=0; i<n; i++){
            if(par[i] != -1){
                System.out.format("%d  -  %d ", par[i], i);
                System.out.println();
            }
        }
    }
}
class Prims{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("enter n:");
        n = sc.nextInt();
        int graph[][] = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i == j){
                    graph[i][j] = -1;
                } else {
                    System.out.format("%d - %d ", i, j);
                    graph[i][j] = graph[j][i] = sc.nextInt();
                }
            }
        }
        new InnerPrims(graph, n);
        sc.close(); 
    }
}