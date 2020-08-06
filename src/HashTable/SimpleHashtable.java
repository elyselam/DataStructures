package HashTable;

public class SimpleHashtable {
    private StoredEmp[] arr; //was only storing value, not keys

    public SimpleHashtable() {
        //arr[5] = 'jane jones'
        arr = new StoredEmp[10];
    }

    public void put(String key, Employee employee) {
        int k = hashKey(key);
        //if occupied, do linear probing
        if (occupied(k)) {
            //loop around until we find an open spot
            int stopIndex = k; //smith => 5
            //if 5 == 10-1, wraps around by setting it to 0
            //if index is 9, wrap around
            if (k == arr.length - 1) {
                k = 0;
            } else {
                k++; //now index 5 is 6
            }
            //keeps incrementing if the next slot is also occupied
            while (occupied(k) && k != stopIndex) {
                k = (k + 1) % arr.length;
            }
        }
        //occupied method
        if (occupied(k)) {
            System.out.println("already an emp at position, cant handle collision" + k);
        } else {
            arr[k] = new StoredEmp(key, employee);
        }
    }
    //retrieval is O(1)
    public StoredEmp get(String key) {
        if (hashKey(key) == -1) {
            return null;
        }
        return arr[hashKey(key)]; //arr[5] = 'jane jones'
    }
    private int hashKey(String key) {
        // 'jones'.length => 5 % 10 = 5
        return key.length() % arr.length;
    }

    private int findKey(String key) {
        int hashKey = hashKey(key);
        //emp found, then return the value
        if (arr[hashKey] != null && arr[hashKey].key.equals(key)) {
            return hashKey;
        }

        int stopIndex = hashKey;
        if (hashKey == arr.length -1) {
            hashKey = 0;
        } else {
            hashKey++;
        }
        while (hashKey != stopIndex &&
                arr[hashKey] != null &&
                !arr[hashKey].key.equals(key)) {
            hashKey = (hashKey + 1) % arr.length;
        }
        if (stopIndex == hashKey) {
            return -1;
        } else {
            return hashKey;
        }
    }

    //if there is already there, it's occupied
    private boolean occupied(int index) {
        return arr[index] != null;
    }

    public void printHashtable() {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                System.out.println("empty");
            }
            System.out.println(arr[i].emp);
        }
    }
}
