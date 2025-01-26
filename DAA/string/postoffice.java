import java.util.*;

class point
{
  int x;
  int y;
}

public class postoffice
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
    double min=Double.MAX_VALUE;
    
    for(int i=0;i<n;i++){
      double sum=0;
      for(int j=0;j<n;j++)
      {
        double xi=(p[i].x-p[j].x)*(p[i].x-p[j].x);
        double yi=(p[i].y-p[j].y)*(p[i].y-p[j].y);
        double d=Math.sqrt(xi+yi);
        sum+=d;
        
        // min=(int)Math.min(d,min);
        
      }
      doubles.add(sum);
      if((sum)<min){
        min=sum;
      }
    
    }
       System.out.println(min);
       System.out.println(doubles);
       System.out.println("("+p[doubles.indexOf(min)].x +","+p[doubles.indexOf(min)].y+") is the point to setup postoffice");
      
    }

  }

