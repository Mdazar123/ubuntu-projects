
class InnerKnapsack{
    int wts[];
    int values[];
    int ratios[];
    int bagWt = 0;
    int maxVal = 0;
    InnerKnapsack(){
        int wts[] = {2, 5, 3, 4};
        this.wts = wts;
        int values[] = {10, 20, 9, 8};
        this.values = values;
        int ratios[] = new int[values.length];
        this.ratios = ratios;
        for(int i=0; i<wts.length; i++){
            ratios[i] = values[i]/wts[i];
        }
        sort();
        this.bagWt = 8;
        kp();
    }
    void sort(){
        for(int i=1; i<ratios.length; i++){
            for(int j=0; j<ratios.length-i; j++){
                if(ratios[j] < ratios[j+1]){
                    swap(ratios, j, j+1);
                    swap(wts, j, j+1);
                    swap(values, j, j+1);
                }
            }
        }
        for(int i=0; i<ratios.length; i++){
            System.out.print(" ele :"+wts[i]);
        }
        
        kp();
    }
    void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void kp(){
        float maxVal = this.maxVal;
        for(int i=0; i<wts.length; i++){
            if(bagWt==0){
                break;
            }
            if(wts[i] <= bagWt){
                maxVal += values[i];
                bagWt -= wts[i];
            }
            else {
                float fval = (((float)bagWt)/wts[i]) * values[i];
                maxVal += fval;
                break;
            }
        }
        System.out.println("maxVal :"+maxVal);
    }
    
}
public class FractionalKp {
    public static void main(String[] args) {
        new InnerKnapsack();
    }
}