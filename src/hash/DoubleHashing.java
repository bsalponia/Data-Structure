package hash;

public class DoubleHashing {

    private int capacity;
    private DataItem[] arr;
    private DataItem noItem;
    private int doubleHashConstant= 5;              //prime number

    //key specific secondary hash function solves primary & secondary clustering
    DoubleHashing(int capacity){
        this.capacity= capacity;
        arr= new DataItem[capacity];
        noItem= new DataItem(-1);
    }

    public static void main(String[] args){
        System.out.println("DoubleHashing is alive");

        DoubleHashing doubleHashing= new DoubleHashing(19);             //imp: take array size always prime number
        doubleHashing.insert(241);
        doubleHashing.insert(225);
        doubleHashing.insert(51);
        doubleHashing.insert(266);
        doubleHashing.insert(278);
        doubleHashing.insert(831);
        doubleHashing.insert(451);

        System.out.println("find: "+doubleHashing.find(245));
        System.out.println("find: "+doubleHashing.find(278));

        System.out.println("delete: "+doubleHashing.delete(215));
        System.out.println("delete: "+doubleHashing.delete(225));

    }

    private void insert(int key){
        int hashKey= hashFunction(key);
        int secondHashKey= secondHashFunction(key);
        while(arr[hashKey]!=null &&
                arr[hashKey].key!= -1){
            hashKey+= secondHashKey;
            hashKey%= capacity;
        }
        arr[hashKey]= new DataItem(key);
        System.out.println("inserted: "+ arr[hashKey].key);
    }

    private int find(int key){
        int hashKey= hashFunction(key);
        int secondHashKey= secondHashFunction(key);
        while(arr[hashKey]!=null){
            if(arr[hashKey].key== key){
                return key;
            }
            hashKey+= secondHashKey;
            hashKey%= capacity;
        }
        return 0;
    }

    private int delete(int key){
        int hashKey= hashFunction(key);
        int secondHashKey= secondHashFunction(key);
        while(arr[hashKey]!=null){
            if(arr[hashKey].key== key){
                arr[hashKey]= noItem;
                return key;
            }
            hashKey+= secondHashKey;
            hashKey%= capacity;
        }
        return 0;
    }

    private int hashFunction(int key){
        return key% capacity;
    }
    
    private int secondHashFunction(int key){
        return doubleHashConstant- (key%doubleHashConstant);
    }

    private static class DataItem{
        int key;
        DataItem(int key){
            this.key= key;
        }
    }
}
