package com.dorito.algorithms.stack;


public class LinkedListStack<E> implements Stack<E> {
    private Node<E> topNode;
    private final E ERROR = null; // 임의의 에러 값


    public LinkedListStack() {
        topNode = null;
    }


    /**
     * @param newItem 스택에 원소 x 삽입
     */
    @Override
    public void push(E newItem) {
        topNode = new Node<>(newItem, topNode);
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

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        private E getData() {
            return data;
        }

        private void setData(E data) {
            this.data = data;
        }

        private Node<E> getNext() {
            return next;
        }

        private void setNext(Node<E> next) {
            this.next = next;
        }
    }
}