package algos;

public class FibonacciSeries {

    public static void main(String args[]){
        System.out.println("FibonacciSeries is alive!");

        printFibonacci(10);
    }

    private static void printFibonacci(int count){

        int first= 0, second= 1, sum;
        for(int i=0;i<count;i++){
            System.out.println(first);
            sum= first+second;
            first= second;
            second= sum;
        }
    }


}
