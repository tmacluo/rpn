package com.nike.rpn.memento;

import java.util.*;

/**
 * Design pattern "memento" to support undo action
 *
 * @author Tmac
 */
public class MementoCaretaker {
    private int i = -1; // index for current Memento
    private final List<Memento> undoList = new ArrayList<Memento>();

    public void createMemento(Stack<String> stack) {
        undoList.add(new Memento((Stack<String>)stack.clone()));
        i++;
    }

    public Memento getMemento() {
        if (i <= -1 || undoList.isEmpty()) {
            return new Memento(new Stack<>());
        }
        undoList.remove(i--);
        if (i <= -1) {
            return new Memento(new Stack<>());
        }
        return undoList.get(i);
    }

    public void clearMemento() {
        undoList.clear();
        i = -1;
    }

}
