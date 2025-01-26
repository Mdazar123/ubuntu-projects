import java.util.Scanner;
class edge{
  int u;
  int v;
  public edge(int u,int v){
    this.u=u;
    this.v=v;
  }
}
class kuskal{
  int n;
  int vis[];
  int adj[][];
  int par[];
  int value=0;
  public kuskal(int n){
    this.n=n;
    adj=new int[n][n];
    par=new int[n];
    for(int i=0;i<n;i++){
      par[i]=i;
    }
  }
  void readinputs(){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter adjacency matrix");
    for(int i=0;i<n;i++){
      for(int j=i;j<n;j++){
        if(i==j){
          adj[i][j]=-1;
        }
        else{
          System.out.print(i+" - "+j+" : ");
          adj[i][j]=adj[j][i]=sc.nextInt();
        }
      }
    }
  }
  void msp(){
    int k=n;
    while(k>0){
      edge e=findvertices();
      if(e == null) break;
      int i=e.u;
      int j=e.v;
      int u=findPar(i);
      int v=findPar(j);
      if(u != v){
        value+=adj[i][j];
        par[u]=v;
      }
      adj[i][j]=adj[j][i]=-1;
      k--;
    }
    System.out.println("minimum cost : "+value);
  }
  edge findvertices(){
    int min=Integer.MAX_VALUE;
    int u=-1;
    int v=-1;
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(adj[i][j] != -1 && adj[i][j]<min){
          u=i;
          v=j;
          min=adj[i][j];
        }
      }
    }
    if(u == -1) return null;
    return new edge(u,v);
  }
  int findPar(int n){
    if(n== par[n]){
      return n;
    }
    return par[n]=findPar(par[n]);
  }
}

public class practice{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    kuskal k=new kuskal(n);
    k.readinputs();
    k.msp();
  }
}