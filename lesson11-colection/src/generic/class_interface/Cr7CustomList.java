package generic.class_interface;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Cr7CustomList<E> implements Cr7List<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private int size;
    private E[] elements;

    public Cr7CustomList() {
//        elements = new E[DEFAULT_CAPACITY];
        elements = createGenericArray(DEFAULT_CAPACITY);
    }

    public Cr7CustomList(int initialCapacity) {
        int capacity = DEFAULT_CAPACITY;
        if (initialCapacity > capacity) {
            capacity = initialCapacity;
        }
        elements = createGenericArray(capacity);
    }

    @Override
    public boolean add(E e) {
        if(size == elements.length) {
            elements = grow();
        }
        elements[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E e) {
        return false;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public boolean remove(int index, E e) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<E> predicate) {
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    @Override
    public E getOrDefault(int index, E defaultValue) {
        E value = get(index);
        return value == null ? defaultValue : value;
    }

    @Override
    public void set(int index, E value) {
        checkIndex(index);
        elements[index] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public void forEach(Consumer<E> consumer, Predicate<E> predicate) {
        for (int i = 0; i < size; i++) {
            E e = elements[i];
            if (predicate.test(e)) {
                consumer.accept(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private E[] createGenericArray(int length) {
        return (E[]) Array.newInstance(Object.class, length);
    }

    private E[] grow() {
        int capacity = elements.length;
        int newCapacity = capacity * 3 / 2;
        return Arrays.copyOf(elements, newCapacity);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index is out of range, size = " + size);
        }
    }
}
