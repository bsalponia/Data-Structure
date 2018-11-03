package hash;

import java.util.List;

public class SeparateChaining {

    private List[] arr;
    private int capacity;                   //in seperate chaining

    SeparateChaining(int capacity){
        this.capacity= capacity;
        arr= new List[capacity];
        for(int i=0;i<capacity;i++)
            arr[i]= new List();
    }

    public static void main(String[] args){
        System.out.println("SeparateChaining is alive.");

        SeparateChaining separateChaining= new SeparateChaining(19);
        separateChaining.insert(241);
        separateChaining.insert(225);
        separateChaining.insert(51);
        separateChaining.insert(266);
        separateChaining.insert(278);
        separateChaining.insert(831);
        separateChaining.insert(451);

        System.out.println("find: "+separateChaining.find(245));
        System.out.println("find: "+separateChaining.find(278));

        System.out.println("delete: "+separateChaining.delete(241));
        System.out.println("delete: "+separateChaining.delete(225));

    }

    private int find(int key){
        int hashKey= hashFunction(key);
        return arr[hashKey].find(key);
    }

    private void insert(int key){
        int hashKey= hashFunction(key);
        arr[hashKey].insert(key);
    }

    private int delete(int key){
        int hashKey= hashFunction(key);
        arr[hashKey].delete(hashKey);
        return key;
    }

    private int hashFunction(int key){
        return key% capacity;
    }

    private static class List{
        private Node head;
        private int size;

        List(){head= null;}

        private int size(){return size;}

        private int find(int data){
            Node temp= head;
            while(temp!=null &&
                    temp.data!=data){
                temp= temp.next;
            }
            return temp==null?0:temp.data;
        }

        private void insert(int data){
            System.out.println("inserted: "+data);
            if(head== null){            //initial item
                head = new Node(data);
            }else{                              //un-sorted list
                Node temp= head;
                while(temp.next!=null){
                    temp= temp.next;
                }
                temp.next= new Node(data);
            }
            size++;
        }

        private int delete(int key){
            if(head==null){
                return 0;
            }else{
                size--;
                Node current= head;
                Node previous= null;
                while(current.next!=null &&
                        current.data!= key){
                    previous= current;
                    current= current.next;
                }
                Node toReturn= current;
                if(previous==null){
                    current= current.next;
                } else{
                    previous.next= current.next;
                    current.next= null;
                }
                return toReturn.data;
            }
        }

        private class Node{
            private int data;
            private Node next;

            Node(){}
            Node(int data){
                this.data= data;
                next= null;
            }
        }
    }
}
