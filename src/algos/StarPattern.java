package algos;

public class StarPattern {

    public static void main(String args[]){

        int size= 5;
        System.out.println("90 Degree:");
        ninetyDegree(size);

        System.out.println("180 Degree:");
        oneEightyDegre(size);

        System.out.println("270 Degree:");
        twoSeventyDegree(size);

        System.out.println("360 Degree:");
        threeSixtyDegree(size);

        System.out.println("Triangle:");
        triangle(size);

        System.out.println("Triangle upside down:");
        triangleUpsideDown(size);

    }

    private static void triangle(int size){

        for(int i=1;i<=size;i++){
            for(int a=i;a<size;a++){
                System.out.print(" ");
            }
            for(int k=1;k<i*2;k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    private static void triangleUpsideDown(int size){

        for(int i=size;i>=1;i--){
            for(int a=size;a>i;a--){
                System.out.print(" ");
            }
            for(int k=1;k<i*2;k++){
                System.out.print("*");
            }
            System.out.println("");
        }

    }


    private static void threeSixtyDegree(int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<(size-1)-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<=i;k++){
                System.out.print("*");
            }
            System.out.println("");
        }


    }

    private static void twoSeventyDegree(int size){

        for(int i=0;i<size;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<size-i;k++){
                System.out.print("*");
            }

            System.out.println("");
        }

    }

    private static void oneEightyDegre(int size){

        for(int i=0;i<size;i++){
            for(int j=size-i;j>0;j--){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    private static void ninetyDegree(int size){

        for(int i=0;i<size;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }

    }


}
