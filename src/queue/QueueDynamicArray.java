package queue;

import java.util.Arrays;

public class QueueDynamicArray {

    public static void main(String args[]){

        System.out.println("It's Alive..");

        Queue queue= new Queue(5);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }

    public static class Queue{

        private int capacity;
        private int[] queueArr;
        private int front=0, rear= 0;
        int size= 0;

        public Queue(int capacity){
            this.capacity= capacity;
            queueArr= new int[capacity];
        }

        private void enqueue(int data){

            if(isQueueFull())
                expand();
            if(rear== capacity)
                rear= 0;

            queueArr[rear]= data;
            rear++;
            size++;
            print();

        }

        private void dequeue(){

            if(isQueueEmpty()){
                System.out.println("Queue Underflow");
                return;
            }

//            shrink();

            if(front== capacity)
                front= 0;

            queueArr[front]= Integer.MIN_VALUE;
            front++;
            size--;
            print();


        }

        private void expand(){
            System.out.println("Exapanding Array");
            capacity= capacity * 2;
            int[] arr= new int[capacity];
            System.arraycopy(queueArr, 0, arr, 0, queueArr.length);
            queueArr= arr;
        }

        //todo- shrink
        private void shrink(){
            if(size< capacity/ 2){
                int newCapacity= capacity/2;
                int[] arr= new int[newCapacity];
                System.arraycopy(queueArr, 0, arr, 0, arr.length);
                queueArr= arr;
            }

        }

        private boolean isQueueFull(){
            return size== capacity;
        }

        private boolean isQueueEmpty(){
            return size==0;
        }

        private void print(){
            System.out.println(Arrays.toString(queueArr));
        }

    }

}
