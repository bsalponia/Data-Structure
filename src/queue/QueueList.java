package queue;

public class QueueList {

    public static void main(String args[]){

        System.out.println("It's Alive");

        Queue queue= new Queue();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

    }

    private static class Queue{

        private int size=0;
        private ListNode front, rear;

        public Queue(){}

        private void enqueue(int data){

            ListNode node= new ListNode(data);
            node.setNext(null);

            if(isQueueEmpty())              //this if condition will execute only once
                front= node;
            else
                rear.setNext(node);
            rear= node;
            size++;
            print();
        }

        private void dequeue(){

            if(isQueueEmpty()){
//                System.out.println("Queue Empty.");
            }else{

                ListNode node= front;
                front= front.getNext();
                node.setNext(null);
                size--;

            }
            print();
        }

        private boolean isQueueEmpty(){
            return size==0;
        }

        private void print() {
            System.out.println("");
            if (isQueueEmpty()) {
                System.out.println("Empty Queue.");
            } else {
                ListNode temp = front;
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
