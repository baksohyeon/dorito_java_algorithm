package com.dorito.algorithms.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ArrayStackTest {

    @BeforeEach
    void setUp() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
    }

    @AfterEach
    void tearDown() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.clear();
    }

    @Test
    void push() {
        ArrayStack<Integer> stack = new ArrayStack<>(10);
        stack.push(300);
        stack.push(200);
        stack.push(100);

        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());

    }

    @Test
    void pop() {
    }

    @Test
    void peek() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }
}