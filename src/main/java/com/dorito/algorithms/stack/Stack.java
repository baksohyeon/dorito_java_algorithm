package com.dorito.algorithms.stack;

public interface Stack<E> {
    public void push(E newItem);
    public E pop();
    public E peek();
    public boolean isEmpty();
    public int size();
    public void clear();
}
