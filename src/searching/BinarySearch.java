package searching;

public class BinarySearch {

    public static void main(String args[]){
        System.out.println("BinarySearch is alive.");
        int arr[]= {1, 2, 4, 5, 6, 9, 11, 14, 21, 26, 31, 53, 63, 66, 71, 77, 81, 93, 97};
        System.out.println("Search item: "+ search(arr, 4));

    }

    private static int search(int arr[], int item){
        int size= arr.length;
        int mid, low= 0, high= size-1;
        while(low<= high){
            mid= (low+high)/2;
            if(arr[mid]== item){
                return item;
            }else if(arr[mid]< item){
                high= mid-1;
            }else if(arr[mid]> item){
                low= mid+1;
            }
        }
        return -1;
    }


}
