import java.util.Arrays;
import java.util.Collections;
class OMST{
    Integer files[];  //here it is not int coz:"Arrays.sort(files, Collections.reverseOrder());" wont works for primitive datatypes but objects
    int retValue;
    OMST(){
        Integer files[] = {3, 4, 5, 2};
        this.files = files;
        this.retValue = 0;
        System.out.println(optimalSort(files.length));
    }
    int optimalSort(int n){
        if(n == 2){
            int val = files[n-1]+files[n-2];
            return val;
        }
        Arrays.sort(files, Collections.reverseOrder());  //sort:decreasing order
        int val = files[n-1]+files[n-2];
        files[n-2] = val;
        retValue += val + optimalSort(n-1);
        return retValue;
    }
}
class OptimalMerge{
    public static void main(String[] args) {
        new OMST();
    }
    
}