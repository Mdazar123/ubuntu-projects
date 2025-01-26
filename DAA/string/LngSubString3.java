
class Substring1{
    String str;
    Substring1(){
        this.str = "abcdefcabcabcdcd";
        System.out.println("+"+lngSubStr()+"+");
        System.out.println("+"+smlSubStr()+"+");
    }
    String lngSubStr(){
        String longStr = "";
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                String subStr = str.substring(i, j);
                if(uniqueElements(subStr)){
                    if(str.indexOf(subStr, i+1) != -1 && longStr.length() < subStr.length()){
                        longStr = subStr;
                    }
                } else {
                    break;
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
    boolean uniqueElements(String str){
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            int count = 0;
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == ch){
                    count++;
                }
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }
}
public class LngSubString3 {
    public static void main(String[] args) {
        new Substring1();
    }
}
