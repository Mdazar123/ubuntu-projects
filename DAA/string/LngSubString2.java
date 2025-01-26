
// package BruteForce;
class Substring{
    String str;
    Substring(){
        this.str = "abcabcabcabcdcd";
        System.out.println("+"+lngSubStr()+"+");
        System.out.println("+"+smlSubStr()+"+");
    }
    String lngSubStr(){
        String longStr = "";
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                String subStr = str.substring(i, j);
                if(str.indexOf(subStr, i+1) != -1 && longStr.length() < subStr.length()){
                    longStr = subStr;
                }
            }
        }
        return longStr;
    }
    String smlSubStr(){
        String smallStr = null;
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                String subStr = str.substring(i, j);
                if(smallStr == null || (str.indexOf(subStr, i+1) != -1 && smallStr.length() > subStr.length())){
                    smallStr = subStr;
                }
            }
        }
        return smallStr;
    }
}
public class LngSubString2 {
    public static void main(String[] args) {
        new Substring();
    }
}
