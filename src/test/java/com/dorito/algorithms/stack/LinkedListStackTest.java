package com.dorito.algorithms.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    private LinkedListStack<String> stack;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        this.stack.clear();
    }

    @Test
    void push() {
        stack = new LinkedListStack<>();
        stack.push("test 1");
        stack.push("test 2");
        stack.push("test 3");
        stack.push("top");
        stack.printStack();
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



