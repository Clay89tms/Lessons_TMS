package org.example.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyPersonIterator implements Iterator {

    List<Person> personList = new ArrayList<>();
    private int cousour = -1;

    @Override
    public boolean hasNext() {
        return cousour < personList.size();
    }

    @Override
    public Object next() {
        cousour += 1;
        return personList.get(cousour);
    }
}
