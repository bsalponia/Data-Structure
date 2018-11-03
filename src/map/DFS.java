package map;

public class DFS {
    public static void main(String args[]) {
        System.out.println("DFS is alive.");


        Graph theGraph= new Graph(10);
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE
        System.out.print("Visits: ");
        theGraph.dfs(); // depth-first search
        System.out.println();


    }

    static class Vertex{
        Vertex(char vertexName){
            this.vertexName= vertexName;
            wasVisited= false;
        }

        char vertexName;
        boolean wasVisited;
    }

    static class Stackk{        //array stack
        int top;
        int[] arr;
        int capacity= 20;
        Stackk(){
            arr= new int[capacity];
            top= -1;
        }

        void push(int value){
            arr[++top]= value;
        }

        void size(){
            System.out.println("size of stack: "+ top);
        }

        int pop(){
            return arr[top--];
        }

        int peek(){
            return arr[top];
        }

        boolean isEmpty(){
            return top== -1;
        }

    }

    static class Graph{
        Vertex[] vertexArray;
        int vertexCount;
        int[][] matrix;
        int capacity;
        Stackk stack;

        Graph(int capacity){
            this.capacity= capacity;
            vertexCount= 0;
            vertexArray= new Vertex[capacity];
            matrix= new int[capacity][capacity];
            for(int i=0;i<capacity;i++)
                for(int j=0;j<capacity;j++)
                    matrix[i][j]= 0;
            stack= new Stackk();
        }

        void addVertex(char value){
            vertexArray[vertexCount++]= new Vertex(value);
        }

        void addEdge(int start, int end){
            matrix[start][end]= 1;
            matrix[end][start]= 1;
        }

        void display(int v){
            System.out.println("vertex: "+ vertexArray[v].vertexName);
        }

        int getVisitedVertex(int v){     //using adjacency matrix
            for(int i=0;i<vertexCount;i++){
                if(matrix[v][i]== 1 &&
                        !vertexArray[i].wasVisited){
                    return i;
                }
            }
            return -1;
        }

        void dfs(){
            vertexArray[0].wasVisited= true;
            display(0);
            stack.push(0);

            while(!stack.isEmpty()){

                int visited= getVisitedVertex(stack.peek());
                if(visited== -1){
                    stack.pop();
                }else{
                    vertexArray[visited].wasVisited =true;
                    display(visited);
                    stack.push(visited);
                }
            }
        }




    }

}
