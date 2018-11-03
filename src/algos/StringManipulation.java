package algos;

import java.util.Arrays;
import java.util.HashMap;

public class StringManipulation {

    public static void main(String args[]){

        System.out.println("StringManipulation is Alive!");

        String str= "bhriguraj salponia is awesome";

        //-----------occurrences of character-------------------
//        System.out.println("a count:" + occurrenceCountSingle(str, 'a'));

//        occurrenceCountAllMap(str);
//        occurrenceCountAllLoop(str);

        //------------------reverse-----------------
//        reverseString(str);
//        reverseSentence(str);

        //-------------remove whitespace-----------
//        removeWhitespace(str);
    }

    private static void removeWhitespace(String str){

        String result="";
        char[] charArray= str.toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(charArray[i] != ' '){
                result+= charArray[i];
            }
        }
        System.out.println(result);
    }

    private static void reverseSentence(String str){

        String[] split= str.split(" ");
        String result="";
        for(int i=split.length-1;i>=0;i--){
            result+=  split[i]+" ";
        }
        System.out.println(result);
    }


    private static void reverseString(String str){
        for(int i=str.length()-1;i>=0;i--){
            System.out.print(str.charAt(i));
        }
    }

    private static void occurrenceCountAllLoop(String str){

        int[] count= new int[Character.MAX_VALUE];
        for(int i=0;i<str.length();i++){
            count[(int)str.charAt(i)]++;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]>0){
                System.out.println("Number of "+ (char)i+": "+ count[i]);
            }
        }
    }

    private static void occurrenceCountAllMap(String str){
        HashMap<Character, Integer> map= new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){     //already hai map mai
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
        System.out.println(map);
    }

    private static int occurrenceCountSingle(String str, char value){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)== value){
                count++;
            }
        }
        return count;
    }

}
