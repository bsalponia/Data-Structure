package trees;

public class BinaryTreeTraversalRecursive {


    public static void main(String args[]){

        System.out.println("BinaryTreeTraversalRecursive is Alive!");
        BinaryTree tree= new BinaryTree();

        //root node
        tree.setRoot(new Node(1));

        //left subtree
        tree.getRoot().setLeft(new Node(2));
        tree.getRoot().getLeft().setLeft(new Node(4));
        tree.getRoot().getLeft().setRight(new Node(5));

        //right subtree
        tree.getRoot().setRight(new Node(3));
        tree.getRoot().getRight().setLeft(new Node(6));
        tree.getRoot().getRight().setRight(new Node(7));


        System.out.println("pre order");
        tree.preorder(tree.getRoot());

        System.out.println("");
        System.out.println("in order");
        tree.inorder(tree.getRoot());

        System.out.println("");
        System.out.println("post order");
        tree.postorder(tree.getRoot());

    }

    private static class BinaryTree{

        private Node root;
        private BinaryTree(){root= null;}

        private void preorder(Node root){             //recursive mai toh pass karna pardhega
            if(root!=null){
                System.out.print(""+root.getData()+" ");
                preorder(root.getLeft());
                preorder(root.getRight());
            }
        }
        private void inorder(Node root){
            if(root!=null){
                inorder(root.getLeft());
                System.out.print(""+root.getData()+" ");
                inorder(root.getRight());
            }
        }
        private void postorder(Node root){
            if(root!=null){
                postorder(root.getLeft());
                postorder(root.getRight());
                System.out.print(""+root.getData()+ " ");
            }
        }

        public void setRoot(Node root){
            this.root= root;
        }
        public Node getRoot(){
            return root;
        }
    }


    private static class Node{

        private int data;
        private Node left;
        private Node right;

        private Node(){}
        private Node(int data){
            this.data=data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
