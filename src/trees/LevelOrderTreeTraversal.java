package trees;

public class LevelOrderTreeTraversal {                      //+ seaching an element in a tree

    public static void main(String args[]){

        System.out.println("LevelOrderTreeTraversal is Alive!");

        BinaryTree binaryTree= new BinaryTree();
        //in this I'll be accessing the element without any class methods

        binaryTree.root= new BinaryTreeNode(1);
        binaryTree.root.left= new BinaryTreeNode(2);
        binaryTree.root.right= new BinaryTreeNode(3);
        binaryTree.root.left.left= new BinaryTreeNode(4);
        binaryTree.root.left.right= new BinaryTreeNode(5);
        binaryTree.root.right.left= new BinaryTreeNode(6);
        binaryTree.root.right.right= new BinaryTreeNode(7);

        binaryTree.levelOrder(binaryTree.root);


        //seraching an element in a binary tree using level order traversal
        System.out.println("");
        binaryTree.searchUsingLevelOrder(binaryTree.root, 5);
        binaryTree.searchUsingLevelOrder(binaryTree.root, 8);




    }

    private static class BinaryTree{

        private BinaryTreeNode root;
        public BinaryTree(){
            root=null;
        }


        private void searchUsingLevelOrder(BinaryTreeNode root, int element){

            if(root==null){
                System.out.println("Tree Empty!");
            }else{

                Queue queue= new Queue();
                queue.enqueue(root);

                boolean isPresent= false;
                while (!queue.isEmpty()) {

                    BinaryTreeNode binaryTreeNode= queue.dequeue();

                    if(binaryTreeNode.data==element){
                        isPresent= true;
                        System.out.println("element: "+ binaryTreeNode.data +" is present");
                    }else{
                        if(binaryTreeNode.left!=null)
                            queue.enqueue(binaryTreeNode.left);
                        if(binaryTreeNode.right!=null)
                            queue.enqueue(binaryTreeNode.right);
                    }
                }
                if(!isPresent)
                    System.out.println("Item not found");
            }
        }

        private void levelOrder(BinaryTreeNode root){

            if(root==null){
                System.out.println("Tree Empty!");
            }else{

                Queue queue= new Queue();
                queue.enqueue(root);

                while (!queue.isEmpty()) {

                    BinaryTreeNode binaryTreeNode= queue.dequeue();
                    System.out.print(binaryTreeNode.getData()+ " ");

                    if(binaryTreeNode.left!=null)
                        queue.enqueue(binaryTreeNode.left);
                    if(binaryTreeNode.right!=null)
                        queue.enqueue(binaryTreeNode.right);
                }
            }
        }

        public BinaryTreeNode getRoot() {
            return root;
        }

        public void setRoot(BinaryTreeNode root) {
            this.root = root;
        }
    }


    private static class Queue{

        private Node rear;                      //add in rear
        private Node front;                 //delete from front
        int size;

        public Queue(){
            rear= null;
            front= null;
            size= 0;
        }

        private void enqueue(BinaryTreeNode data){

            Node node= new Node();
            node.setData(data);
            node.setNext(null);
            if(isEmpty())
                front= node;
            else
                rear.setNext(node);

            rear= node;
            size++;
        }


        private BinaryTreeNode dequeue(){

            if(isEmpty()){
                return null;
            }
            Node temp= front;
            front= front.getNext();

            temp.setNext(null);
            size--;
            return temp.getData();
        }

        private boolean isEmpty(){
            return size==0;
        }
    }

    private static class BinaryTreeNode{

        private int data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(int data){
            this.data= data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }
    }


    private static class Node{

        private BinaryTreeNode data;
        private Node next;

        public BinaryTreeNode getData() {
            return data;
        }

        public void setData(BinaryTreeNode data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }



}
