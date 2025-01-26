import java.util.*;

class point
{
  int x;
  int y;
}
public class closestpair
{
  public static void main(String[] args) {
    System.out.println("enter count of points");
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    point p[]=new point[n];

    for(int i=0;i<n;i++){
      p[i]=new point();
      System.out.println("enter "+(i+1)+" point coordinates");
      p[i].x=sc.nextInt();
      p[i].y=sc.nextInt();
    }

    double min=Double.MAX_VALUE;
    
    for(int i=0;i<n-1;i++){
      for(int j=i+1;j<n;j++)
      {
        double xi=Math.pow((p[i].x-p[j].x),2);
        double yi=Math.pow((p[i].y-p[j].y),2);
        double d=Math.sqrt(xi+yi);
        // min=(int)Math.min(d,min);
        if(d<min){
          min=d;
        }

      }
    }
    System.out.println("minimum distance between two points : "+min);
    for(int i=0;i<n-1;i++){
      int count=0;
      for(int j=i+1;j<n;j++)
      {
        double xi=Math.pow((p[i].x-p[j].x),2);
        double yi=Math.pow((p[i].y-p[j].y),2);
        double d=Math.sqrt(xi+yi);
        if(d==min){
          System.out.println("closest pair points are : ("+p[i].x+","+p[i].y+"),("+p[j].x+","+p[j].y+")");
          count=1;
          break;
        }
      }
      if(count != 0){
        break;
      }
    }

  }
}
