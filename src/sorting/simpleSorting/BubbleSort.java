package sorting.simpleSorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String args[]){
        System.out.println("BubbleSort is ALive");

        int[] arr= {6,5,4,3,2,1};
        System.out.println("Unsorted element of array: "+ Arrays.toString(arr));
        bubbleSort(arr);

    }

    private static void bubbleSort(int[] arr){
        int size= arr.length;
        boolean isSwapped;
        for(int i=0;i<size-1;i++){
            isSwapped= false;
            for(int j=0;j<size-1-i;j++){
                System.out.println("value of j: "+ j);
                if(arr[j]> arr[j+1]){       //swap the items
                    int temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                    isSwapped= true;
                }
            }
            if(!isSwapped){//no element swapped in this phase so breaking out of loop
                break;
            }
        }
        System.out.println("Sorted element of array: "+ Arrays.toString(arr));
    }



}
