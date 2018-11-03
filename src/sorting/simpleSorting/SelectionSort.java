package sorting.simpleSorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String arg[]){
        System.out.println("SelectionSort is alive.");
        int[] arr= {6,5,4,3,2,1};
        sort(arr);
    }

    static void sort(int[] arr){
        System.out.println(Arrays.toString(arr));
        int size= arr.length;
        int min;
        for(int i=0;i<size-1;i++){
            min= i;
            for(int j=i+1;j<size;j++){
                if(arr[j]<arr[min])
                    min= j;
            }
            //swap now
            int temp= arr[i];
            arr[i]= arr[min];
            arr[min]= temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
