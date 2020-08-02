package HashTable;

public class SimpleHashtable {
    private Employee[] hashtable;
    public SimpleHashtable() {
        hashtable = new Employee[10];

    }
    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null) {
            System.out.println("sorry already an emp at position, cant handle collision" + hashedKey);
        } else {
            hashtable[hashedKey] = employee;
        }
    }
    private int hashKey(String key) {
        // 5 mod 10 = 5
        return key.length() % hashtable.length;
    }

}
