package list;

public class SinglyLinkedList {

    public static void main(String[] args) {
        System.out.println("It's Alive");

        LinkedList list= new LinkedList();

        list.insertBeginning(1);
        list.print();
        list.insertBeginning(2);
        list.print();
        list.insertEnd(4);
        list.print();
        list.insertIntermediate(3, 1);
        list.print();
        list.insertEnd(5);
        list.print();


        list.deleteBeginning();
        list.print();
        list.deleteEnd();
        list.print();
        list.deleteIntermediate(2);
        list.print();

    }

    public static class LinkedList {

        private ListNode head;
        private int size;

        public LinkedList() {
        }           //default constructor

        //insertion-------------------------------------------
        //beginning
        public void insertBeginning(int data) {
            ListNode node = new ListNode(data);
            node.setNext(head);
            head = node;
            size++;
        }

        //end
        public void insertEnd(int data) {
            ListNode node = new ListNode(data, null);
            ListNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
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
                head = head.getNext();
                temp.setNext(null);
                size--;
            }
        }

        //end
        public void deleteEnd() {

            if (head == null) {
                System.out.println("List is empty.");
            } else {

                ListNode posNode = head;         //position node
                ListNode preNode = null;             //previous node to position
                while (posNode.getNext() != null) {
                    preNode = posNode;
                    posNode = posNode.getNext();
                }
                preNode.setNext(null);
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
                } while (temp != null);
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
