package trees;

import stack.StackList;

public class BinaryTreeTraversalIterative {             //+ finding the heigh/depth of the tree

    public static void main(String args[]){

        System.out.println("BinaryTreeTraversalIterative is Alive!!!");

        BinaryTree tree= new BinaryTree();
        tree.setRoot(new BinaryTreeNode(1));

        //left subree
        tree.getRoot().setLeft(new BinaryTreeNode(2));
        tree.getRoot().getLeft().setLeft(new BinaryTreeNode(4));
        tree.getRoot().getLeft().setRight(new BinaryTreeNode(5));

        //right subtree
        tree.getRoot().setRight(new BinaryTreeNode(3));
        tree.getRoot().getRight().setLeft(new BinaryTreeNode(6));
        tree.getRoot().getRight().setRight(new BinaryTreeNode(7));

        System.out.println("Pre-Order Traversal");
        tree.preOrder(tree.getRoot());
        System.out.println("");
        System.out.println("In-Order Traversal");
        tree.inOrder(tree.getRoot());
        System.out.println("");
        System.out.println("Post-Order Traversal");
        tree.postOrder(tree.getRoot());                     //using 2 stack


        System.out.println("");
        System.out.println("Post-Order Traversal Single Stack");
        tree.postOrderSingle(tree.getRoot());

        //finding the depth or height of the tree
        System.out.println("");
        tree.getDepth(tree.getRoot());

    }


    public static class BinaryTree{

        private BinaryTreeNode root;
        private BinaryTree(){root= null;}

        private void preOrder(BinaryTreeNode root){

            if(root==null)
                return;

            Stack nodeStack= new Stack();
            nodeStack.push(root);

            while(!nodeStack.isEmpty()){

                BinaryTreeNode node= nodeStack.peek();
                System.out.print(node.getData()+" ");
                nodeStack.pop();

                if(node.right!=null){
                    nodeStack.push(node.getRight());
                }
                if(node.left!=null){
                    nodeStack.push(node.getLeft());
                }
            }

        }

        private void inOrder(BinaryTreeNode root){

            if(root==null)
                return;
            Stack nodeStack= new Stack();
            BinaryTreeNode current= root;
            while(!nodeStack.isEmpty() ||
                    current!=null){
                while(current!=null){
                    nodeStack.push(current);
                    current= current.left;
                }
                //now the current must be null
                current= nodeStack.peek();          //before pop, storing the item in current node
                nodeStack.pop();
                System.out.print(current.getData()+ " ");

                current= current.right;
            }
        }


        //using 2 stack
        private void postOrder(BinaryTreeNode root){
            if(root==null)
                return;

            Stack s1= new Stack();
            s1.push(root);
            Stack s2= new Stack();
            while (!s1.isEmpty()){

                BinaryTreeNode node= s1.peek();
                s1.pop();
                s2.push(node);

                if(node.getLeft()!=null)
                    s1.push(node.getLeft());
                if(node.getRight()!=null)
                    s1.push(node.getRight());
            }

            while(!s2.isEmpty()){
                BinaryTreeNode node= s2.peek();
                s2.pop();
                System.out.print(node.getData()+ " ");
            }
        }

        //single stack
        private void postOrderSingle(BinaryTreeNode root){
            if(root==null)
                return;

            Stack stack= new Stack();
            stack.push(root);

            BinaryTreeNode previous= null;
            while(!stack.isEmpty()){
                BinaryTreeNode current= stack.peek();
                if(previous==null ||
                        previous.left== current ||
                        previous.right== current){

                    //top to down
                    if(current.left!=null)
                        stack.push(current.left);
                    else if(current.right!=null)
                        stack.push(current.right);
                } else if (current.left == previous) {
                    if(current.right!=null)
                        stack.push(current.right);
                }else{
                    System.out.print(current.data+ " ");
                    stack.pop();
                }
                previous= current;
            }


        }

        private void getDepth(BinaryTreeNode root){         //this is also height
            if(root==null)
                return;

            Stack stack= new Stack();
            stack.push(root);

            int maxDepth= 0;

            BinaryTreeNode previous= null;
            while(!stack.isEmpty()){
                BinaryTreeNode current= stack.peek();
                if(previous==null ||
                        previous.left== current ||
                        previous.right== current){

                    //top to down
                    if(current.left!=null)
                        stack.push(current.left);
                    else if(current.right!=null)
                        stack.push(current.right);
                } else if (current.left == previous) {
                    if(current.right!=null)
                        stack.push(current.right);
                }else{
//                    System.out.print(current.data+ " ");
                    stack.pop();
                }
                previous= current;

                if(stack.size>maxDepth)
                    maxDepth= stack.size;

            }

            System.out.println("Depth/Height of the tree: "+ maxDepth);
        }


        public BinaryTreeNode getRoot() {
            return root;
        }

        public void setRoot(BinaryTreeNode root) {
            this.root = root;
        }
    }






    public static class Stack{

        private int size;
        private Node head;

        public Stack(){head= null;size=0;}
        public void push(BinaryTreeNode data){
            Node node= new Node(data);
            node.setNext(head);
            head= node;
            size++;
//            System.out.print(" "+head.getData());
        }

        public void pop(){
            Node temp= head;
//            System.out.print(" "+head.getData());
            head = head.getNext();
            temp.setNext(null);
            size--;
        }

        private int size(){
            return size;
        }

        private boolean isEmpty(){
            return size<=0;
        }

        private BinaryTreeNode peek(){
            return head.getData();
        }


    }


    private static class Node{

        private BinaryTreeNode data;         //now this is the catch, this node accepts input of BinaryTreeNode type
        private Node next;

        public Node(){}
        public Node(BinaryTreeNode data){
            this.data= data;
        }

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


    private static class BinaryTreeNode{

        private int data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(){}
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
}
