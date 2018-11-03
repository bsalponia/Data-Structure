package searching;

public class UnorderedLinearSearch {

    public static void main(String args[]){
        System.out.println("UnorderedLinearSearch is alvie.");

        int arr[]= {4, 1, 3, 7, 2, 9};
        System.out.println("search item: "+ search(arr, 7));


    }

    private static int search(int arr[], int item){
        int size= arr.length;
        for(int i=0; i<size; i++){
            if(arr[i]== item){
                return item;
            }
        }
        return -1;
    }

}
