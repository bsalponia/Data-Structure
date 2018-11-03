package priorityqueue;

public class PriorityQueue {                //using heap data structures

    public static void main(String args[]){

        PQueue pQueue= new PQueue(10);
        pQueue.insert(5);
        pQueue.insert(12);
        pQueue.insert(17);
        pQueue.insert(8);
        pQueue.insert(36);
        pQueue.insert(9);
        pQueue.insert(22);

        pQueue.max();

        pQueue.delete();
        pQueue.delete();

    }

    static class PQueue{

        private int capacity;
        private Heap heap;
        public PQueue(int capacity){
            this.capacity= capacity;
            this.heap= new Heap(capacity);
        }

        private void insert(int item){
            heap.insert(item);
        }
        private void delete(){
            heap.delete();
        }
        private void max(){
            System.out.println("max: "+ heap.max());
        }
    }


    static class Heap{
        private int[] arr;
        private int size=0;
        private int capacity;

        Heap(int capacity){
            arr= new int[capacity];
            this.capacity= capacity;
        }

        private void insert(int item){
            if(isFull()){
                System.out.println("heap is full");
            }else{
                System.out.println("inserted: "+ item);
                arr[size++]= item;
                swim();
            }
        }

        private void delete(){
            if(isEmpty()){
                System.out.println("heap is empty");
            }else{
                System.out.println("deleted: "+ arr[0]);
                arr[0]= arr[size];
                size--;
                sink();
            }
        }

        //going down- delete case
        private void sink(){
            int index= 0;
            int leftIndex= index*2+1;
            while(leftIndex<= size){
                int rightIndex= leftIndex+1;
                int max= leftIndex;
                if(rightIndex<=size){
                    if(arr[rightIndex]>arr[leftIndex]){
                        max= rightIndex;
                    }
                }
                if(arr[index]< arr[max]){
                    int temp= arr[index];
                    arr[index]= arr[max];
                    arr[max]= temp;
                    leftIndex= max;
                }else{
                    break;
                }
            }
        }

        //going up- insert case
        private void swim(){
            int index= size-1;
            while(index>= 0){
                int parentIndex= (index-1)/2;
                int parentValue= arr[parentIndex];
                int childValue= arr[index];
                if(childValue> parentValue){
                    arr[parentIndex]= childValue;
                    arr[index]= parentValue;
                    index= parentIndex;
                }else{
                    break;
                }
            }
        }

        private int max(){
            return arr[0];
        }

        private boolean isFull(){
            return size+1== capacity;
        }

        private boolean isEmpty(){
            return size==0;
        }
    }
}
