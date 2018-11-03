package stack;

public class StackList {

    public static void main(String[] args){

        Stack stack= new Stack();
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.pop();


    }

    private static class Stack{

        private ListNode head;
        private int size;

        private void push(int data){
            ListNode node= new ListNode(data);
            node.setNext(head);
            head= node;
            size++;
            print();
        }

        private void pop(){
            ListNode temp= head;
            head= head.getNext();
            temp.setNext(null);
            size--;
            print();
        }

        private int top(){
            if(head==null){
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }else{
                return head.getData();
            }
        }

        private int size(){
            return size;
        }

        public void print() {
            System.out.println("");
            if (head == null) {
                System.out.println("Stack is empty.");
            } else {
                ListNode temp = head;
                do {
                    System.out.print(temp.getData() + "  ");
                    temp = temp.getNext();
                } while (temp != null);
            }

        }

    }

    private static class ListNode{

        private int data;
        private ListNode next;

        public ListNode(){}

        public ListNode(int data){
            this.data= data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

}
