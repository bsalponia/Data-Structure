package sorting.advancedSorting;

import java.util.Arrays;

public class QuickSort {            //todo: do this .

    private static int arr[];

    public static void main(String args[]){
        System.out.println("QuickSort is alive.");

        arr=  new int[]{6, 16, 43, 5, 67, 45, 65, 3};
        System.out.println("unsorted array: "+ Arrays.toString(arr));
        sortRecursive(0, arr.length-1);
        System.out.println("QuickSorted array: "+ Arrays.toString(arr));

    }
    

    private static void sortRecursive(int left, int right){

        if(left-right<=0){
            //do nothing, exit the function
        }else{
            int pivot= arr[right];
            int partitionIndex= partition(left, right, pivot);
            sortRecursive(left, partitionIndex-1);              //left array before pivot value
            sortRecursive(partitionIndex+1, right);         //right array
        }
    }



    private static int partition(int left, int right, int pivot){

        int leftPtr= left-1;
        int rightPtr= right+1;

        while(true){
            while(leftPtr< right &&
                    arr[++leftPtr]< pivot);    //nop
            while(rightPtr> left &&
                    arr[--rightPtr]> pivot);   //no operation

            if(leftPtr>= rightPtr){
                break;
            }else{
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, rightPtr);
        System.out.println("position & value: "+ leftPtr+ " "+arr[leftPtr]);
        return leftPtr;
    }

    private static void swap(int left, int right){
        int temp= arr[left];
        arr[left]= arr[right];
        arr[right]= temp;
    }

}
