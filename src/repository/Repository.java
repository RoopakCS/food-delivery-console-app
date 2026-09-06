package repository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> objects = new ArrayList<>();

    public void addObject(T object) {
        objects.add(object);
    }

    public T getObject(int index) {
        if(index >= 0 && index < objects.size()) {
            return objects.get(index);
        }

        return null;
    }

    public List<T> getAllObjects() {
        return objects;
    }

    public boolean isEmpty() {
        return objects.isEmpty();
    }

    public int size() {
        return objects.size();
    }
}
