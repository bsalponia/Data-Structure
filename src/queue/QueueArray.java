package queue;

import java.util.Arrays;

public class QueueArray {

    public static void main(String args[]){

        System.out.println("It's Alive..");

        Queue queue= new Queue(4);
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

            if(isQueueFull()){
                System.out.println("Queue Overflow");
            }else{
                if(rear== capacity)
                    rear= 0;

                queueArr[rear]= data;
                rear++;
                size++;
                print();
            }
        }

        private void dequeue(){

            if(isQueueEmpty()){
                System.out.println("Queue Underflow");
            }else{

                if(front== capacity)
                    front= 0;

                queueArr[front]= Integer.MIN_VALUE;
                front++;
                size--;
                print();
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
