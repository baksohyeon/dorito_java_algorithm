package com.dorito.algorithms.stack;

public class ArrayStack<E> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null; // 임의의 에러 값
    private int topIndex; // 스택의 top 인덱스
    private E[] stack;


    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(STR."Invalid capacity: \{capacity}");
        }
        stack = (E[]) new Object[capacity];
        topIndex = -1;
    }

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
        if (stack == null) {
            throw new OutOfMemoryError("Not enough memory to allocate an array of size " + DEFAULT_CAPACITY);
        }
    }


    /**
     * @param newItem
     * 알고리즘 6-1 구현: 스택에 원소 x 삽입하기
     */
    @Override
    public void push(E newItem) {
        // full stack: topIndex == stack.length - 1
        if (topIndex == stack.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++topIndex] = newItem;
    }

    /**
     * @return top of stack or ERROR if stack is empty
     */
    @Override
    public E pop() {
        if (topIndex >= 0) {
            return stack[topIndex--];
        }
        if (topIndex == -1) {
            return ERROR; // the stack is empty
        }
    }
    /**
     * @return top of stack or ERROR if stack is empty
     */
    @Override
    public E peek() {
        if (topIndex >= 0) {
            return stack[topIndex];
        }
        if (topIndex == -1) {
            return ERROR; // the stack is empty
        }
        return ERROR; // should never reach here

    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return topIndex < 0; // stack is empty if topIndex == -1
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return topIndex + 1;
    }

    /**
     *
     */
    @Override
    public void clear() {
        stack = (E[]) new Object[stack.length];
        topIndex = -1;
    }
}