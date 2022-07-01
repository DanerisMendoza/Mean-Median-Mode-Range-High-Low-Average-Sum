package mean.median.mode.range.high.low.average.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MeanMedianModeRangeHighLowAverageSum {
    public static void main(String[] args) {
        double arr[] = {1,2,3,4,4.5,4.5,5.2,6,7,8,9,10};      
        String arr2[] = computationMethod(arr);
        System.out.println("Mean: "+arr2[0]);
        System.out.println("Median: "+arr2[1]);
        System.out.println("Mode: "+arr2[2]);
        System.out.println("Range: "+arr2[3]);
        System.out.println("High: "+arr2[4]);
        System.out.println("Low: "+arr2[5]);
        System.out.println("Average: "+arr2[6]);
        System.out.println("Sum: "+arr2[7]);
    }
    
    public static String[] computationMethod(double arr[]){
        //declaration 
        double mean,median,range,high,low,average,sum=0.0;      
        //round off first then print original array
        String arrString[] = new String[arr.length];
        for(int i=0; i<arr.length; i++){
            if(arr[i]%1 ==0)
               arrString[i] = String.valueOf((int) Math.round(arr[i]));
            else
               arrString[i] = String.valueOf(arr[i]);
        }
        System.out.println("Array: "+Arrays.toString(arrString));
        
        //compute high low sum and average
        String mode;
        int higestCount = 1;     
        Map<Double, Integer> modeWithCount = new HashMap<Double, Integer>();
        ArrayList<String> arrList = new ArrayList<>();
        high = low = arr[0];
        for(int i=0; i<arr.length; i++){
            if (modeWithCount.containsKey(arr[i]))                
                modeWithCount.replace(arr[i], modeWithCount.get(arr[i]) + 1);
            else  
                modeWithCount.put(arr[i], 1);
            if(arr[i]>high)
                high = arr[i];
            if(arr[i]<low)
                low = arr[i];
            sum += arr[i];
        }
        //mean and average is same
        mean = average = sum/arr.length;
      
        Double higestMode =  null;
        String[] arr2String = new String[8];
        
        //getting mode
        for (Map.Entry<Double, Integer> currentKey : modeWithCount.entrySet()) {
            if (currentKey.getValue() > higestCount){
                higestMode = currentKey.getKey();
                higestCount++;
            }
        } 
        //if multiple mode
        if(higestCount!=1){
            for(Map.Entry<Double, Integer> currentKey : modeWithCount.entrySet()){
                 if (currentKey.getValue() == higestCount)
                    arrList.add(currentKey.getKey()%1==0? String.valueOf(Math.round(currentKey.getKey())):currentKey.getKey().toString());
            }
        }
           
        if(higestCount==1)
            mode = "no mode";
        else if(arrList.size() == 1)
            mode = (higestMode%1==0)?  String.valueOf((int) Math.round(higestMode)):higestMode.toString();
        else
            mode = Arrays.toString(arrList.toArray());
        
        //to get median you need to sort first
        Arrays.sort(arr);
        if(arr.length % 2 == 0){
            double sumOfMiddleElements = arr[arr.length / 2] + arr[arr.length / 2 - 1];
            median = ((double) sumOfMiddleElements) / 2;
        }
        else{
            median = (double) arr[arr.length / 2];
        }
        
        //range is  simply high - low
        range = high - low;
        
           
        //round off if even else retain
        double[] arr2 = {mean,median,0,range,high,low,average,sum}; 
        for(int i=0; i<8; i++){
           if(i == 2){
               arr2String[2] = mode;
               continue;
           }
            
           if(arr2[i]%1 ==0)
               arr2String[i] = String.valueOf((int) Math.round(arr2[i]));
           else
               arr2String[i] = String.valueOf(arr2[i]);
        }   
    
    return arr2String;
    }
    
}
