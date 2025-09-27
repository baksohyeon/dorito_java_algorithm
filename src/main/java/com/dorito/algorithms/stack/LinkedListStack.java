package com.dorito.algorithms.stack;

public class LinkedListStack<E> implements Stack<E> {
    private Node<E> top;
    private final E ERROR = null; // 임의의 에러 값


    public LinkedListStack() {
        topNode = null;
    }


    /**
     * @param newItem
     */
    @Override
    public void push(E newItem) {

    }

    /**
     * @return
     */
    @Override
    public E pop() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public E peek() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     *
     */
    @Override
    public void clear() {

    }
}
