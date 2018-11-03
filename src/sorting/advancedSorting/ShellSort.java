package sorting.advancedSorting;

import java.util.Arrays;

public class ShellSort {

    public static void main(String args[]){
        System.out.println("ShellSort is alive.");

        int arr[]= {6, 16, 43, 5, 67, 45};
        System.out.println("unsorted array: "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("sorted array: "+ Arrays.toString(arr));

    }

    private static void sort(int[] arr){
        int size= arr.length;
        int outer, inner;
        int outerValue;
        int gap= size/2;   //though in the original submitted shellsort algorithm, it took gap/2 but this is not much effective

        while(gap>0){
            for(outer= gap; outer<size; outer++){
                outerValue= arr[outer];
                inner= outer;
                while(inner> gap-1 &&
                        arr[inner-gap]> outerValue){
                    arr[inner]= arr[inner-gap];
                    inner-= gap;
                }
                arr[inner]= outerValue;
            }
            gap/=2;
        }
    }

}
