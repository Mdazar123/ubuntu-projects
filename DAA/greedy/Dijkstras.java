

import java.util.Scanner;
class Dj{
    int edge[][];
    int cost[];
    int vis[];
    int k;
    Dj(int edge[][], int cost[], int vis[]){
        this.edge = edge;
        this.cost = cost;
        this.vis = vis;
        k = edge.length;
        path();
    }
    
    void path(){
        while(k>0){
            int min=Integer.MAX_VALUE;
            int j=-1;
            for(int i=0;i<edge.length;i++){
                if(vis[i]== -1)
                {
                    if(cost[i]<min)
                    {
                        min=cost[i];
                        j=i;
                    }

                }
            }
            vis[j]=1;
            for(int i=0;i<edge.length;j++){
                if(edge[j][i] != -1){
                    if(cost[j]+edge[j][i]<cost[i]){
                        cost[i]=cost[j]+edge[j][i];
                    }
                }
            }
            k--;
        }
        // while(k>0){
        //     int min = Integer.MAX_VALUE; 
        //     int idx = -1;
        //     for(int i=0; i<edge.length; i++){
        //         if(vis[i]==-1){
        //             if(cost[i]<min){
        //                 min = cost[i];
        //                 idx = i;
        //             }
        //         }
                
        //     }
            
        //     vis[idx] = 1;
        //     for(int j=0; j<edge.length; j++){
        //         if(edge[idx][j] != -1){
        //             if((cost[idx]+edge[idx][j]) < cost[j]){
        //                 cost[j] = (cost[idx]+edge[idx][j]);
        //             }
        //         }
        //     }
        //     k--;
        // }
        for(int i=0; i<edge.length; i++){
            System.out.println(cost[i]);
        }
    }
}
public class Dijkstras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("enter no.of edges:");
        int n=sc.nextInt();
        int edge[][] = new int[n][n];
        int cost[] = new int[n];
        int vis[] = new int[n];
        cost[0] = 0;
        vis[0] = -1;
        for(int i=1; i<n; i++){
            cost[i] = Integer.MAX_VALUE;
            vis[i] = -1;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                edge[i][j] = -1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                System.out.println("edge of "+i+" & "+j+" :");
                edge[i][j] = edge[j][i] = sc.nextInt();
            }
        }
        new Dj(edge, cost, vis);
        sc.close();
    }
    
}
