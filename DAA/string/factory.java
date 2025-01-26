import java.util.*;

class point
{
  int x;
  int y;
}
public class factory
{
  // @SuppressWarnings("unlikely-arg-type")
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
    
    ArrayList<Double> doubles= new ArrayList<>();
    double max=Double.MIN_VALUE;
    int ans[]=new int[n];
    
    for(int i=0;i<n;i++)
    {
      double sum=0;
      for(int j=0;j<n;j++)
      {
        double xi=(p[i].x-p[j].x)*(p[i].x-p[j].x);
        double yi=(p[i].y-p[j].y)*(p[i].y-p[j].y);
        double d=Math.sqrt(xi+yi);
        sum+=d;
             
      }
      doubles.add(sum);
      if((sum)>max){
        max=sum;
      }
    
    }
       System.out.println(max);
       System.out.println(doubles);
       System.out.println("("+p[doubles.indexOf(max)].x +","+p[doubles.indexOf(max)].y+") is the point to setup factory");
      
    }

  }

