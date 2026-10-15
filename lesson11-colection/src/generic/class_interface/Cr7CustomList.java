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
        // Cho phép index = size để thêm vào cuối list
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }

        // Mở rộng mảng nếu đã đầy
        if (size == elements.length) {
            elements = grow();
        }

        // Dịch các phần tử sang phải để tạo khoảng trống
        System.arraycopy(
                elements, index,
                elements, index + 1,
                size - index
        );

        elements[index] = e;
        size++;

        return true;
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            // Hỗ trợ cả trường hợp e == null
            if (e == null ? elements[i] == null : e.equals(elements[i])) {
                removeAt(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean remove(int index, E e) {
        checkIndex(index);

        // Chỉ xóa nếu phần tử tại index bằng e
        E current = elements[index];

        if (e == null ? current != null : !e.equals(current)) {
            return false;
        }

        removeAt(index);
        return true;
    }

    @Override
    public boolean removeIf(Predicate<E> predicate) {
        if (predicate == null) {
            throw new NullPointerException("Predicate must not be null");
        }

        boolean removed = false;
        int i = 0;

        while (i < size) {
            if (predicate.test(elements[i])) {
                removeAt(i);
                removed = true;
            } else {
                i++;
            }
        }

        return removed;
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

    /**
     * Xóa phần tử tại index và dịch các phần tử còn lại sang trái.
     */
    private void removeAt(int index) {
        int numMoved = size - index - 1;

        if (numMoved > 0) {
            System.arraycopy(
                    elements, index + 1,
                    elements, index,
                    numMoved
            );
        }

        // Giải phóng reference ở vị trí cuối
        elements[--size] = null;
    }
}
