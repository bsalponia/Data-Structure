package trees;

public class BinarySearchTree {

    public static void main(String args[]){

        System.out.println("BinarySearchTree running..");

        BSTree bsTree= new BSTree();
        bsTree.root= new BSTNode(7);

        //left subtree
        bsTree.root.left= new BSTNode(4);
        bsTree.root.left.left= new BSTNode(2);
        bsTree.root.left.right= new BSTNode(5);

        //right subtree
        bsTree.root.right= new BSTNode(9);
        bsTree.root.right.left= new BSTNode(8);


        //find-- recursive & iterative
        bsTree.findRecursive(bsTree.root, 5);
        bsTree.findIterative(bsTree.root, 8);

        //find minimum--  recursive & iterative
        bsTree.findMinimumRecursive(bsTree.root);
        bsTree.findMinimumIterative(bsTree.root);

        //find maximum-- recursive & iterative
        bsTree.findMaximumRecursive(bsTree.root);
        bsTree.findMaximumIterative(bsTree.root);

        //insert recursive
        bsTree.insertRecursive(bsTree.root, 11);
        //print inorder after inserting 11
        System.out.println("Recurisve Insert");
        bsTree.inOrder(bsTree.root);

        System.out.println("");
        System.out.println("Iterative Insert");
        bsTree.insertIterative(bsTree.root, 12);
        bsTree.inOrder(bsTree.root);

        System.out.println("");
        System.out.println("Deleting the node");
        bsTree.delete(bsTree.root, 7);

        System.out.println("Inoder Traversal");
        bsTree.inOrder(bsTree.root);

        System.out.println("Is it bst? : "+ bsTree.checkBST(bsTree.root));

    }



    private static class BSTree{

        private BSTNode root;
        private BSTree(){root= null;}

        boolean checkBST(BSTNode root) {
            if(root==null)
                return true;
            if(root.left!=null &&
                    findMax(root.left).data< root.data)
                return true;
            if(root.right!=null &&
                    findMin(root.right).data> root.data)
                return true;
            if(checkBST(root.left) ||
                    checkBST(root.right))
                return true;
            return false;
        }

        private BSTNode delete(BSTNode root, int data){
            BSTNode temp;
            if(root==null)
                System.out.println("Not Found");
            if(data< root.data)
                root.left= delete(root.left, data);
            else if(data> root.data)
                root.right= delete(root.right, data);
            else{
                //both child hai
                if(root.left!=null &&
                        root.right!=null){

                    temp= findMax(root.left);           //finding the max in the left subtree
                    root.data= temp.data;               //replacing the left max node value with current node
                    root.left= delete(root.left, root.data);            //delete the max in left subtree
                }else{          //single child or no child condition
                    if(root.left!=null){
                        root= root.left;
                    }else if(root.right!=null){
                        root= root.right;
                    }else{
                        root= null;
                    }
                }
            }
            return root;
        }

        private void find(BSTNode root, int data){
            if(root==null){
                System.out.println("Data Not Found");
                return;
            }
            if(data==root.data){
                System.out.println("Data Found");
            }else if(data<root.data){
                find(root.left, data);
            }else if(data>root.data){
                find(root.right, data);
            }
        }


        private void inOrder(BSTNode root){
            if(root==null)
                return;
            inOrder(root.left);
            System.out.print(root.data+ " ");
            inOrder(root.right);
        }

        private BSTNode insertIterative(BSTNode root, int data){

            if(root==null)
                return new BSTNode(data);
            BSTNode temp= root;         //for traversing
            BSTNode parent= null;           //saving the parent
            while(temp!=null){
                parent= temp;
                if(data<temp.data){
                    temp= temp.left;
                }else{
                    temp= temp.right;
                }
            }

            //now the parent will contain the node whose child will be data
            if(data< parent.data)
                parent.left= new BSTNode(data);
            else
                parent.right= new BSTNode(data);

            return root;
        }

        private BSTNode insertRecursive(BSTNode root, int data){
            if(root==null){
                root= new BSTNode(data);
            }else{
                if(data<root.data)
                    root.left= insertRecursive(root.left, data);
                else if(data>root.data)
                    root.right= insertRecursive(root.right, data);
            }
            return root;
        }


        private void findMaximumRecursive(BSTNode root){
            if(root==null)
                return;
            if(root.right==null)
                System.out.println("maximum element: "+ root.data);
            else
                findMaximumRecursive(root.right);
        }

        private BSTNode findMax(BSTNode node){
            if(node==null)
                return null;
            if(node.right!=null)
                return findMax(node.right);
            return node;
        }

        private BSTNode findMin(BSTNode node){
            if(node==null)
                return null;
            if(node.left!=null)
                return findMax(node.left);
            return node;
        }

        private void findMaximumIterative(BSTNode root){
            if(root==null)
                return;
            while(root.right!=null){
                root= root.right;
            }
            System.out.println("maximum element: "+ root.data);
        }


        private void findMinimumRecursive(BSTNode root){
            if(root==null)
                return;
            if(root.left==null)
                System.out.println("minimum element: "+ root.data);
            else
                findMinimumRecursive(root.left);

        }

        private void findMinimumIterative(BSTNode root){
            if(root==null)
                return;
            while(root.left!=null){
                root= root.left;
            }
            System.out.println("minimum element: "+ root.data);
        }


        //find the value recursively
        private void findRecursive(BSTNode root, int data){
            if(root==null)
                return;

            if(data==root.data)
                System.out.println("found: "+ root.data);
            else if(data< root.data)
                findRecursive(root.left, data);
            else if(data> root.data)
                findRecursive(root.right, data);

        }

        //iterative find
        private void findIterative(BSTNode root, int data){
            if(root==null)
                return;
            else{
                while(root!=null){
                    if(data== root.data){
                        System.out.println("found: "+ root.data);
                        break;
                    }else if(data < root.data){
                        root= root.left;
                    }else{
                        root= root.right;
                    }
                }
            }
        }


    }


    private static class BSTNode{

        private int data;
        private BSTNode left;
        private BSTNode right;

        private BSTNode(){}
        private BSTNode(int data){this.data= data;}
    }



}
