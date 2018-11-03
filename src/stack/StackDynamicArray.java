package stack;

import java.util.Arrays;

public class StackDynamicArray {


    public static void main(String[] args){

        System.out.println("It's Alive...");

        Stack stack= new Stack(4);

        stack.push(2);
        stack.print();
        stack.push(3);
        stack.print();
        stack.push(4);
        stack.print();
        stack.push(2);
        stack.print();
        stack.push(2);
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();


    }


    private static class Stack{

        private int[] arr;
        private int capacity;
        private int top=-1;                 //i.e.. index value -1

        private Stack(int capacity){
            this.capacity= capacity;
            arr= new int[capacity];         //initialising the array size
        }

        private void push(int data){
            if(isFull())
                expand();
            arr[++top]= data;
        }

        private void expand(){

            int arr_[]= new int[size()*2];
            System.arraycopy(arr, 0 , arr_, 0, capacity);
            arr= arr_;
            capacity= arr.length;
            System.out.println("New capacity: "+ capacity);
        }

        private void pop(){
            if(isEmpty()){
                System.out.println("Stack underflow");
            }else{
                shrink();
                arr[top--]= Integer.MIN_VALUE;
            }
        }

        private void shrink(){
            boolean isHalf= size()<(capacity/2);
            if(isHalf){
                int[] arr_= new int[capacity/2];
                System.arraycopy(arr, 0 , arr_, 0, arr_.length);
                arr= arr_;
                capacity= arr.length;
                System.out.println("New capacity: "+ capacity);
            }
        }

        private boolean isFull(){
            return size()== capacity;
        }

        private boolean isEmpty(){
            return top<0;
        }


        private int size(){
            return top+1;
        }

        private int top(){
            return arr[top];
        }

        private void print(){
            System.out.println(Arrays.toString(arr));
        }

    }


}
