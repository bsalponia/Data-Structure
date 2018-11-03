package stack;

import java.util.Arrays;

public class StackArray {

    public static void main(String[] args) {

        System.out.println("It's Alive");

        Stack stack= new Stack(6);
        stack.push(1);
        stack.print();
        stack.push(2);
        stack.print();
        stack.push(3);
        stack.print();
        stack.push(4);
        stack.print();
        stack.push(5);
        stack.print();
        stack.push(6);
        stack.print();
        stack.push(7);
        stack.push(8);


        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.pop();

        stack.push(4);
        stack.print();
        stack.push(5);
        stack.print();
        stack.push(6);
        stack.print();
        System.out.println("top: "+stack.top()+ "  capacity: "+stack.size());

    }


    public static class Stack{

        private int arr[];
        private int capacity;
        private int top= -1;                // default -1

        public Stack(){}

        private Stack(int capacity){
            this.capacity= capacity;
            arr= new int[capacity];         //initialising the array size
        }

        private void push(int data){
            if(isFull()){
                System.out.println("Stack Overflow");
            }else{
                arr[++top]= data;
            }
        }

        private void pop(){
            if(isEmpty()){
                System.out.println("Stack underflow");
            }else{
                arr[top--]= Integer.MIN_VALUE;
            }
        }

        private void print(){
            System.out.println(Arrays.toString(arr));
        }

        private boolean isFull(){
            return size()==capacity;
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
    }


}
