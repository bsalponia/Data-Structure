package list;

public class DoublyLinkedList {


    public static void main(String[] args) {

        System.out.println("It's Alive..");

        LinkedList list= new LinkedList();
        list.insertBeginning(1);
        list.print();
        list.insertBeginning(2);
        list.print();
        list.insertBeginning(9);
        list.print();
        list.insertBeginning(3);
        list.print();
        list.insertEnd(4);
        list.print();
        list.insertEnd(5);
        list.print();
        list.insertIntermediate(8, 3);
        list.print();
        list.deleteBeginning();
        list.print();
        list.deleteEnd();
        list.print();
        list.deleteIntermediate(3);
        list.print();

    }

    private static class LinkedList{

        private ListNode head;
        private int size;

        //insertion------------------------------------
        //beginning
        public void insertBeginning(int data) {
            ListNode node= new ListNode(data);
            node.setPrev(null);
            node.setNext(head);
            head= node;
            size++;
        }
        //end
        public void insertEnd(int data) {
            ListNode node= new ListNode(data);
            node.setNext(null);

            ListNode temp= head;
            while(temp.getNext()!=null) {
                temp= temp.getNext();
            }
            node.setPrev(temp);
            temp.setNext(node);
            size++;
        }
        //intermediate
        public void insertIntermediate(int data, int pos) {
            ListNode node= new ListNode(data);
            ListNode temp= head;
            for(int i=1;i<pos;i++){
                temp= temp.getNext();
            }
            node.setNext(temp.getNext());
            node.setPrev(temp);
            temp.getNext().setPrev(node);
            temp.setNext(node);
            size++;
        }

        //deletion----------------------------------------------
        //beginning
        public void deleteBeginning(){
            ListNode temp= head;
            head= head.getNext();
            head.setPrev(null);

            temp.setNext(null);
            size--;
        }
        //end
        public void deleteEnd(){
            ListNode temp= head;
            while (temp.getNext()!=null){
                temp= temp.getNext();
            }
            temp.getPrev().setNext(null);
            temp.setPrev(null);
            size--;
        }
        //intermediate
        public void deleteIntermediate(int pos){
            ListNode temp= head;
            for(int i=1;i<pos;i++){
                temp= temp.getNext();
            }
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            size--;
        }

        public void print() {
            System.out.println("");
            if (head == null) {
                System.out.println("List is empty.");
            } else {
                ListNode temp = head;
                do {
                    System.out.print(temp.getData() + "  ");
                    temp = temp.getNext();
                } while (temp != null);
            }
        }

    }

    private static class ListNode {

        private int data;
        private ListNode prev;
        private ListNode next;

        public ListNode() {
        }
        public ListNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getPrev() {
            return prev;
        }

        public void setPrev(ListNode prev) {
            this.prev = prev;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

}
