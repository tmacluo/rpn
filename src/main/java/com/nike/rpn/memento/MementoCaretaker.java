package com.nike.rpn.memento;

import java.util.*;

/**
 * Design pattern "memento" to support undo action
 *
 * @author Tmac
 */
public class MementoCaretaker {
    private int currentIndex = -1; // index for current Memento
    private final List<Memento> mementoList = new LinkedList<>();

    public void createMemento(Stack<String> stack) {
        mementoList.add(new Memento((Stack<String>)stack.clone()));
        currentIndex++;
    }

    public Memento getMemento() {
        if (currentIndex < 0 || mementoList.isEmpty()) {
            return new Memento(new Stack<>());
        }
        mementoList.remove(currentIndex--);
        if (currentIndex <= -1) {
            return new Memento(new Stack<>());
        }
        return mementoList.get(currentIndex);
    }

    public void clearMemento() {
        mementoList.clear();
        currentIndex = -1;
    }

}
