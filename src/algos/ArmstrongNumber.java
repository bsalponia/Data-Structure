package algos;

public class ArmstrongNumber {

    public static void main(String args[]){
        System.out.println("ArmstrongNumber is alive!");

        int number= 1532;
        //prove whether the above number is armstrong

        int numberOfDigits= 0, temp=number;
        while(temp!=0){
            numberOfDigits++;
            temp= temp/10;
        }


        int modulus, sum=0;
        temp=number;
        while(temp!=0){
            modulus= temp%10;
            sum+= power(modulus, numberOfDigits);
            temp/=10;
        }
        boolean isArmstrong= number==sum;
        System.out.println("Is number armstrong: "+ isArmstrong);

    }

    private static int power(int digit, int numberOfDigits){

        int power=1;
        for(int i=0;i<numberOfDigits;i++){
            power= power*digit;
        }
        return power;
    }
}
