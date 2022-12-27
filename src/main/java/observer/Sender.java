package observer;

public interface Sender {

    /**
     * The register function add a member to the observers list.
     * @param obj - the object to register and such that implements the Member interface.
     */
    void register(Member obj);

    /**
     * The unregister function removes a member from the observers list.
     * @param obj - the object to register and such that implements the Member interface.
     */
    void unregister(Member obj);

    /**
     * Inserts the string into this character sequence, and notify all the observers change has been made.
     * @param offset - the offset.
     * @param obj - the String.
     */
    void insert(int offset, String obj);

    /**
     * Appends the specified string to this character sequence, and notify all the observers change has been made.
     * @param obj - the String.
     */
    void append(String obj);

    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * In addition, notifies all the observers change has been made.
     * @param -The beginning index, inclusive
     * @param -The ending index, exclusive.
     */
    void delete(int start, int end);

    /**
     * This method undo the previous operation, and notify all the observers change has been made.
     */
    void undo();
}
