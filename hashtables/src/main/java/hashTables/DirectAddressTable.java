package hashTables;

import java.util.Random;

public class DirectAddressTable {

    private KeyedData[] T;
    private int length;

    public DirectAddressTable(int U) {
        T = new KeyedData[U];
        length = U;
    }

    public void insert(KeyedData x) {
        T[x.key] = x;
    }
    public void delete(KeyedData x) {
        T[x.key] = null;
    }

    public KeyedData search(int k) {
        return T[k];
    }

    public static void main(String[] args) {
        int u = 100;
        DirectAddressTable t = new DirectAddressTable(u);
        Random dice = new Random();
        KeyedData data;
        for (int i = 0; i < 10; i++) {
            int temp = dice.nextInt();
            data = new KeyedData(i, temp);
            t.insert(data);
        }


    }
}
