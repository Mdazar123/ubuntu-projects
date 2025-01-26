import java.util.Scanner;

class minstring{
  String s1;
  public minstring(String s1){
    this.s1=s1;
  }

  String longstr(){
    String lstr="";
    for(int i=0;i<s1.length();i++){
      for(int j=i;j<s1.length();j++){
        String substr=s1.substring(i, j);
        if(unique(substr)){
          if(s1.indexOf(substr,i+1)!= -1 && lstr.length()<substr.length()){
            lstr=substr;
          }

        }else{
          break;
        }
      }
    }
    return lstr;
  }
  String smallstr(){
    String sstr=null;
    for(int i=0;i<s1.length();i++){
      for(int j=i+1;j<s1.length();j++){
        String substr=s1.substring(i, j);
        if(sstr== null || s1.indexOf(substr, i+1)!= -1 && sstr.length()>substr.length()){
          sstr=substr;
        }

      }
    }
    return sstr;
  }


  boolean unique(String str){
    for(int i=0;i<s1.length();i++){
      char ch=s1.charAt(i);
      int count=0;
      for(int j=0;j<str.length();j++){
        if(str.charAt(j)==ch){
          count++;
        }
      }
      if(count>1){
        return false;
      }
    }
    return true;
  }
}

public class practice{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter strings");
    String s1=sc.next();
    minstring min=new minstring(s1);
    System.out.println(min.longstr());
    System.out.println(min.smallstr());

  }
}