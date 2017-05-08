package com.example.nare.contacts;

import java.util.Comparator;

/**
 * Created by Nare on 09.05.2017.
 */

public class SortByName implements Comparator<Item_class> {
    @Override
    public int compare(Item_class o1, Item_class o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
