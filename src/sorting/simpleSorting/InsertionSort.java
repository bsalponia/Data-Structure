package sorting.simpleSorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String args[]){
        System.out.println("InsertionSort is alive.");

        int arr[]= {6, 16, 43, 5, 67, 45};
        System.out.println("unsorted array: "+ Arrays.toString(arr));
        sort(arr);
        System.out.println("sorted array: "+ Arrays.toString(arr));

    }

    private static void sort(int[] arr){
        int size= arr.length;
        int outer, inner;
        int outerValue;
        for(outer=1; outer<size; outer++){
            outerValue= arr[outer];
            inner= outer;
            while(inner>0 &&
                    arr[inner-1]>= outerValue){
                arr[inner]= arr[inner-1];
                inner--;
            }
            arr[inner]= outerValue;
        }
    }
}
