package searching;

public class OrderedLinearSearch {

    public static void main(String args[]){
        System.out.println("OrderedLinearSearch is alive.");
        int arr[]= {1,2,4,5,6,9};
        System.out.println("Search item: "+ search(arr, 4));

    }

    private static int search(int arr[], int item){
        int size= arr.length;
        for(int i=0; i<size; i++){
            if(arr[i]==item){
                return item;
            }else if(arr[i]> item){
                return -1;
            }
        }
        return -1;
    }


}
