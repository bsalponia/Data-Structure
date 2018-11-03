package trees;

public class AVLTree {

    public static void main(String args[]){

        System.out.println("AVLTree is Alive");


        Tree tree= new Tree();
        tree.root= tree.insert(null, 4);

        tree.preorder(tree.root);

        System.out.println("");
        tree.insert(tree.root, 2);
        tree.preorder(tree.root);


        System.out.println("");
        tree.insert(tree.root,1);
        tree.preorder(tree.root);


    }

    private static class Tree{

        private Node root;

        private Tree(){root=null;}

        private Node insert(Node root, int data){
            if(root==null){
                root= new Node();
                root.data= data;
            }else{

                if(data<root.data){
                    root.left= insert(root.left, data);
                    if(height(root.left) - height(root.right)==2){      //balance the imbalance
                        if(data < root.left.data)
                            root= LLRotation(root);
                        else
                            root= LRRotation(root);
                    }
                }else if(data>root.data){
                    root.right= insert(root.right, data);
                    if(height(root.right)- height(root.left)==2){
                        if(data > root.right.data)
                            root= RRRotation(root);
                        else
                            root= RLRotation(root);
                    }
                }else{
                    //this means duplicate data
                }
            }
            root.height= max(height(root.left),height(root.right))+1;
            return root;
        }

//        private int height(Node node){
//            if(node==null)
//                return -1;
//            else
//                return node.height;
//        }

        private int max(int l, int r){
            return l>r?l:r;
        }

        private void preorder(Node root){             //recursive mai toh pass karna pardhega
            if(root!=null){
                System.out.print(root.data+" ");
                preorder(root.left);
                preorder(root.right);
            }
        }

        private int height(Node node){
            if(node==null)
                return -1;
            else{
                int lTreeHeight= height(node.left);
                int rTreeHeight= height(node.right);

                if(lTreeHeight>rTreeHeight)
                    return lTreeHeight+1;
                else if(rTreeHeight>lTreeHeight)
                    return rTreeHeight+1;
                else
                    return 0;
            }
        }

        private Node RLRotation(Node node){
            node.right= LLRotation(node.right);
            return RRRotation(node);
        }

        private Node LRRotation(Node node){
            node.left= RRRotation(node.left);
            return LLRotation(node);
        }

        private Node LLRotation(Node node){
            System.out.println("in the LLRotation");
            Node temp= node.left;
            node.left= temp.right;
            temp.right= node;
            temp.height= max(height(temp.left), height(temp.right))+1;
            node.height= max(height(node.left), height(node.right))+1;
            return temp;
        }

        private Node RRRotation(Node node){
            System.out.println("in the RRRotation");
            Node temp= node.right;
            node.right= temp.left;
            temp.left= node;
            temp.height= max(height(temp.left), height(temp.right))+1;
            node.height= max(height(node.left), height(node.right))+1;
            return temp;
        }

    }



    private static class Node{
        private int data;
        private int height;
        private Node left;
        private Node right;
    }

}
