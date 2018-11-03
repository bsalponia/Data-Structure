package stack;

public class balacingsymbol {

    public static void main(String args[]){

        String s= "(())[]{}";
        System.out.println("Is the given string balanced: "+ isSymbolBalanced(s));

    }

    private static boolean isSymbolBalanced(String s){

        Stack stack= new Stack(20);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)== ')'){
                if(!stack.isEmpty() &&
                        stack.top()== '('){
                    stack.pop();
                }else
                    return false;
            }else if (s.charAt(i)== ']'){
                if(!stack.isEmpty() &&
                        stack.top()== '['){
                    stack.pop();
                }else
                    return false;
            }else if(s.charAt(i)== '}'){
                if(!stack.isEmpty() &&
                        stack.top()== '{'){
                    stack.pop();
                }else
                    return false;
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }


    private static class Stack{

        private int top= -1;
        private char[] arr;
        private int capacity;

        private Stack(int capacity){
            this.capacity= capacity;
            arr= new char[capacity];
        }

        private void push(char c){
            if(isFull()){
                System.out.println("Stack Overflow");
            }else{
                arr[++top]= c;
            }
        }

        private char pop(){
            if(isEmpty()){
                return 'c';
            }
            return arr[top--];
        }

        private boolean isEmpty(){
            return top<0;
        }

        private boolean isFull(){
            return top+1== capacity;
        }

        private char top(){
            return arr[top];
        }
    }
}
