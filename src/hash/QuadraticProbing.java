package hash;

public class QuadraticProbing {
    
    private DataItem[] arr;
    private int capacity;
    private DataItem noItem;

    //suffers from secondary clustering
    QuadraticProbing(int capacity){
        this.capacity= capacity;
        arr= new DataItem[capacity];
        noItem= new DataItem(-1);
    }

    public static void main(String args[]){
        System.out.println("QuadraticProbing is alive");

        QuadraticProbing quadraticProbing= new QuadraticProbing(19);    //imp: take array size always prime number
        quadraticProbing.insert(241);
        quadraticProbing.insert(225);
        quadraticProbing.insert(51);
        quadraticProbing.insert(266);
        quadraticProbing.insert(278);
        quadraticProbing.insert(831);
        quadraticProbing.insert(451);

        System.out.println("find: "+quadraticProbing.find(245));
        System.out.println("find: "+quadraticProbing.find(278));

        System.out.println("delete: "+quadraticProbing.delete(215));
        System.out.println("delete: "+quadraticProbing.delete(225));
    }


    private void insert(int key){
        int hashKey= hashFunction(key);
        int mAdd= 1;
        while(arr[hashKey]!=null &&
                arr[hashKey].key!= -1){
            hashKey+= mAdd*mAdd;                //1x1, 2x2, 3x3
            hashKey%= capacity;                 //for overflow
            mAdd++;
        }
        arr[hashKey]= new DataItem(key);
        System.out.println("inserted: "+key);
    }
    
    private int find(int key){
        int hashKey= hashFunction(key);
        int mAdd= 1;
        while(arr[hashKey]!=null){
            if(arr[hashKey].key== key){
                return key;
            }
            hashKey+= mAdd* mAdd;
            hashKey%= capacity;
            mAdd++;
        }
        return 0;
    }
    
    private int delete(int key){
        int hashKey= hashFunction(key);
        int mAdd= 1;
        while(arr[hashKey]!=null){
            if(arr[hashKey].key== key){
                arr[hashKey]= noItem;
                return key;
            }
            hashKey+= mAdd* mAdd;
            hashKey%= capacity;
            mAdd++;
        }
        return 0;
    }

    int hashFunction(int key){
        return key% capacity;
    }

    private static class DataItem{
        DataItem(int key){
            this.key= key;
        }
        int key;
    }
}
