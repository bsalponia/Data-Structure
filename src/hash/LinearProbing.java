package hash;

public class LinearProbing {

    private DataItem[] arr;
    private DataItem noItem;
    private int capacity;

    //suffers from primary clustering
    LinearProbing(int capacity){
        this.capacity= capacity;
        arr= new DataItem[capacity];
        noItem= new DataItem(-1);       //in case of delete
    }


    public static void main(String args[]){
        System.out.println("LinearProbing is alive");
        LinearProbing linearProbing= new LinearProbing(19);             //imp: take array size always prime number
        linearProbing.insert(241);
        linearProbing.insert(225);
        linearProbing.insert(51);
        linearProbing.insert(266);
        linearProbing.insert(278);
        linearProbing.insert(831);
        linearProbing.insert(451);

        System.out.println("find: "+linearProbing.find(245));
        System.out.println("find: "+linearProbing.find(278));

        System.out.println("delete: "+linearProbing.delete(215));
        System.out.println("delete: "+linearProbing.delete(225));

    }

    private int find(int key){
        int hashKey= hashFunction(key);
        while(arr[hashKey]!=null){
            if(arr[hashKey].key== key){
                return key;
            }
            hashKey++;
            hashKey%= capacity;
        }
        return 0;
    }

    private void insert(int key){
        DataItem item= new DataItem(key);
        int hashKey= hashFunction(key);
        while(arr[hashKey]!=null &&
                arr[hashKey].key!= -1){     //if cell not empty & not delete item, then move to next cell
            hashKey++;
            hashKey%= capacity;
        }
        arr[hashKey]= item;
        System.out.println("inserted: "+key);
    }

    private int delete(int key){
        int hashKey= hashFunction(key);
        while(arr[hashKey]!=null){              //till non empty
            if(arr[hashKey].key== key){                     //found the key
                //will return the key itself
                arr[hashKey]= noItem;
                return key;
            }
            hashKey++;
            hashKey%= capacity;                     //start from begining if overflow
        }
        return -1;
    }

    private int hashFunction(int key){
//        int remainder= key % capacity;
//        System.out.println("remainder: "+ remainder);
        return key % capacity;
    }

    //item to be inserted
    private static class DataItem{
        DataItem(int key){
            this.key= key;
        }
        int key;
    }
}
