//second method
class Omst{
    Integer files[];
    int retValue;
    Omst(){
        Integer files[] = {10,12,8,6,5,3,4};
        this.files = files;
        this.retValue = 0;
        System.out.println(optimalSort(files.length));
    }
    int optimalSort(int n){
        if(n == 2){
            int val = files[n-1]+files[n-2];
            return val;
        }
        swap(n);
        swap(n-1);
        int val = files[n-1]+files[n-2];
        files[n-2] = val;
        retValue += val + optimalSort(n-1);
        return retValue;
    }
    void swap(int n){
        int small = 0;
        for(int i=1; i<n; i++){
            if(files[i] < files[small]){
                small = i;
            }
        }
        int temp = files[n-1];
        files[n-1] = files[small];
        files[small] = temp;
    }
}
public class OptimalMerg2{
    public static void main(String[] args) {
        new Omst();
    }
    
}
