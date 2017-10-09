package exercises;

import hashTables.DirectAddressTable;
import hashTables.KeyedData;

/**
 * Created by T440P on 2017/9/30.
 */
public class MaxableDirectAddressTable extends DirectAddressTable {
    private int length;
    private KeyedData[] T;
    public MaxableDirectAddressTable(int U) {
        super(U);
    }

    public KeyedData findMax() {
        for (int i = length; i >= 0; i--) {
            if (T[i] != null) {
                return T[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MaxableDirectAddressTable t = new MaxableDirectAddressTable(100);

    }
}
