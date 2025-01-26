import java.util.Scanner;
public class stringmatch{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter two srtrings");
    String s1=sc.next();
    String s2=sc.next();
    int m=s1.length();
    int n=s2.length();
    int flag=0;
    for(int i=0;i<=(m-n);i++)
    {
      if(s1.charAt(i)==s2.charAt(0))
      {
        int count=0;
        for(int j=0;j<n;j++)
        {
          if(s2.charAt(j)!=s1.charAt(i+j)){
            count=1;
            break;
          }
        }
        if(count==0)
        {
          flag=i;
          
        }
      }
    }
    if(flag != 0){
      System.out.println("match found at index "+flag);
    }
    else{
      System.out.println("no match found");
    }
    
    
  }
}