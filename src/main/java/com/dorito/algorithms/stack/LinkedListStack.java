package com.dorito.algorithms.stack;

public class LinkedListStack<E> implements Stack<E> {

    // 내부 Node 클래스
    private static class Node<E> {
        private final E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
        private Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;   // stack의 top
    private int size;       // 원소 개수

    public LinkedListStack() {
        head = null;
        size = 0;
    }

    @Override
    public void push(E newItem) {
        // 새 노드가 head를 가리킴
        head = new Node<>(newItem, head); // head를 새 노드로 갱신
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E data = head.data;
        head = head.next; // 첫 노드를 제거
        size--;
        return data;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null; // 모든 노드의 참조 끊음 → GC 수거 가능
        size = 0;
    }
}