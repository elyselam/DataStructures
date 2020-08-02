package HashTable;

public class SimpleHashtable {
    private Employee[] hashtable;
    public SimpleHashtable() {
        hashtable = new Employee[10];

    }
    public void put(String key, Employee employee) {
        //doesn't handle collision
        //give index in the array
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null) {
            System.out.println("already an emp at position, cant handle collision" + hashedKey);
        } else {
            hashtable[hashedKey] = employee;
        }
    }
    //retrieval is O(1)
    public Employee get(String key) {
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }
    private int hashKey(String key) {
        // 5 mod 10 = 5
        return key.length() % hashtable.length;
    }


    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            System.out.println(hashtable[i]);
        }
    }

}
