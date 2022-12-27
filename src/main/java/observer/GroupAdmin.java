package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender {

    public final ArrayList<Member> observers = new ArrayList<>();

    private UndoableStringBuilder status;

    public GroupAdmin(){
        status = new UndoableStringBuilder() ;
    }

    /**
     * The register function add a member to the observers list.
     * @param obj - the object to register and such that implements the Member interface.
     */
    @Override
    public void register(Member obj) {
        observers.add(obj);
    }

    /**
     * The unregister function removes a member from the observers list.
     * @param obj - the object to register and such that implements the Member interface.
     */
    @Override
    public void unregister(Member obj) {
        observers.remove(obj);
    }

    /**
     * Inserts the string into this character sequence, and notify all the observers change has been made.
     * @param offset - the offset.
     * @param obj - the String.
     */
    @Override
    public void insert(int offset, String obj) {
        status.insert(offset, obj);
        notifyObservers();
    }

    /**
     * Appends the specified string to this character sequence, and notify all the observers change has been made.
     * @param obj - the String.
     */
    @Override
    public void append(String obj) {
        status.append(obj);
        notifyObservers();
    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * In addition, notifies all the observers change has been made.
     * @param start - The beginning index, inclusive
     * @param end - The ending index, exclusive.
     */
    @Override
    public void delete(int start, int end) {
        status.delete(start, end);
        notifyObservers();
    }

    /**
     * This method undo the previous operation, and notify all the observers change has been made.
     */
    @Override
    public void undo() {
        try {
            status.undo();
            notifyObservers();
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Error: cannot undo to empty list.");
        }
    }

    /**
     * this function being used in each of the UndoableStringBuilder functions above (append, insert, delete and undo).
     * and its propose is to notify each observer that change has been made, and to update the copy it holds to the
     * recent UndoableStringBuilder.
     */
    public void notifyObservers() {
        for (Member observer : observers) {
            observer.update(status);
        }
    }

    public UndoableStringBuilder getStatus() {
        return status;
    }

    public void setStatus(UndoableStringBuilder status) {
        this.status = status;
    }

    public String toString() {
        return observers.toString();
    }
}
