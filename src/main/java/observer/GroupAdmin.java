package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {
    public final ArrayList<Member> observers = new ArrayList<>();
    private UndoableStringBuilder status;

    @Override
    public void register(Member obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        observers.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        status.insert(offset, obj);
        notifyObservers();
    }

    @Override
    public void append(String obj) {
        status.append(obj);
        notifyObservers();
    }

    @Override
    public void delete(int start, int end) {
        status.delete(start, end);
        notifyObservers();
    }

    @Override
    public void undo() {
        try {
            status.undo();
            notifyObservers();
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Error: cannot undo to empty list.");
        }
    }

    public void notifyObservers() {
        for (Member observer : observers) {
            observer.update(status);
        }
    }

    public String toString() {
        return observers.toString();
    }
}
