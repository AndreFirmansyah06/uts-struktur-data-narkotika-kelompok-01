package com.example.utsstrukdat.utill;

public class DynamicArray<T> implements StrukturData<T> {
    // ini baru - Hapus kata kunci 'static' agar tiap instance memiliki memori sendiri
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        validateInvariant();
    }

    @Override
    public void add(T value) {
        ensureCapacity();
        elements[size++] = value;
        validateInvariant();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int position) {
        checkIndex(position);
        return (T) elements[position];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int position) {
        checkIndex(position);
        T removedElement = (T) elements[position];

        // ini baru - Perbaikan sintaks numMoved
        int numMoved = size - position - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, position + 1, elements, position, numMoved);
        }
        elements[--size] = null;
        validateInvariant();
        return removedElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (value == null ? elements[i] == null : value.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        validateInvariant();
    }
