package com.nike.rpn.memento;

import java.util.*;

/**
 * Design pattern "memento" to support undo/redo action
 *
 * @author Tmac
 */
public class MementoManager {

    // index for current Memento
    private int currentIndex = -1;

    // used specifically for undo action, add a separate mementos list to track redo action
    private final List<Memento> mementos = new LinkedList<>();

    public void create(Stack<String> stack) {
        mementos.add(new Memento((Stack<String>) stack.clone()));
        currentIndex++;
    }

    public Memento undo() {
        if (currentIndex >= 0) {
            mementos.remove(currentIndex--);
        }
        if (currentIndex < 0 || mementos.isEmpty()) {
            return new Memento(new Stack<>());
        }
        return mementos.get(currentIndex);
    }

    public void clear() {
        mementos.clear();
        currentIndex = -1;
    }
}
