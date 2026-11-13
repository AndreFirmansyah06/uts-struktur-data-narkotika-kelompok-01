package com.example.utsstrukdat.utill;

public class ArrayStack<T> implements StrukturData<T> {
    private Object[] data;
    private int top;
    private int langkahTerakhir;

    public ArrayStack() { data = new Object[10]; }

    public void push(T v) {
        if (top == data.length) {
            Object[] baru = new Object[data.length * 2];
            for (int i = 0; i < top; i++) baru[i] = data[i];
            data = baru;
        }
        data[top++] = v;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack kosong");
        T x = (T) data[--top];
        data[top] = null;
        return x;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack kosong");
        return (T) data[top - 1];
    }


    private void restore(ArrayStack<T> bantu) {

        while (!bantu.isEmpty()) push(bantu.pop());
    }

    public int getLangkahTerakhir() {
        return langkahTerakhir;
    }


    @Override public void add(T v) {
        push(v);
    }
