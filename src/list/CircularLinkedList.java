package list;

public class CircularLinkedList {

    public static void main(String[] args) {
        System.out.println("It's Alive");

        LinkedList list= new LinkedList();

        list.insertBeginning(2);
        list.print();
        list.insertBeginning(1);
        list.print();
        list.insertEnd(3);
        list.print();
        list.insertEnd(4);
        list.print();
        list.insertIntermediate(8, 1);
        list.print();
        list.insertIntermediate(9, 1);
        list.print();
        list.deleteBeginning();
        list.print();
        list.deleteEnd();
        list.print();
        list.deleteIntermediate(2);
        list.print();

    }

    public static class LinkedList {

        private ListNode head;              //also known as tail
        private int size;

        public LinkedList() {
        }           //default constructor

        //insertion-------------------------------------------
        //beginning
        public void insertBeginning(int data) {
            ListNode node = new ListNode(data);
            if(head==null){
                node.setNext(node);
                head = node;
            }else{
                ListNode temp= head;
                while(temp.getNext()!=head){
                    temp= temp.getNext();
                }
                node.setNext(head);
                temp.setNext(node);
                head= node;
            }
            size++;
        }

        //end
        public void insertEnd(int data) {
            ListNode node= new ListNode(data);
            node.setNext(head);
            ListNode temp= head;
            while(temp.getNext()!=head){
                temp= temp.getNext();
            }
            temp.setNext(node);
            size++;
        }

        //intermediate
        public void insertIntermediate(int data, int pos) {
            ListNode node = new ListNode(data);
            ListNode temp = head;
            for (int i = 1; i < pos; i++) {
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
            size++;
        }

        //deletion------------------------------------------
        //beginning
        public void deleteBeginning() {
            if (head == null) {
                System.out.println("List is empty.");
            } else {
                ListNode temp = head;
                while (temp.getNext()!=head){
                    temp= temp.getNext();
                }
                head = head.getNext();
                temp.setNext(head);
                size--;
            }
        }

        //end
        public void deleteEnd() {

            if (head == null) {
                System.out.println("List is empty.");
            } else {

                ListNode temp= head;
                ListNode prev= null;
                while(temp.getNext()!=head){
                    prev= temp;
                    temp= temp.getNext();
                }
                prev.setNext(head);
                temp.setNext(null);
                size--;
            }
        }

        //intermediate
        public void deleteIntermediate(int pos) {

            ListNode posNode = head;         //position node
            ListNode preNode = null;             //previous node to position
            for (int i = 1; i < pos; i++) {
                preNode = posNode;
                posNode = posNode.getNext();
            }
            preNode.setNext(posNode.getNext());
            posNode.setNext(null);
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
                } while (temp != head);
            }

        }

        private static class ListNode {

            private int data;
            private ListNode next;

            public ListNode() {
            }

            public ListNode(int data) {
                this.data = data;
            }

            public ListNode(int data, ListNode next) {
                this.data = data;
                this.next = next;
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
}
