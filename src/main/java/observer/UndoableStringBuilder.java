package observer;

import java.util.ArrayList;

/*
Use the class you've implemented in previous assignment
 */

public class UndoableStringBuilder {
    private  ArrayList<StringBuilder> list ;
    private int tempOffset = 0;
    public ArrayList<StringBuilder> getList() {
        return list;
    }

    public int getTempOffset() {
        return tempOffset;
    }

    /**
     * Constructor with no list provided, will be used by the GroupAdmin to make the original Object.
     */
    public UndoableStringBuilder() {
        this.list = new ArrayList<>();
        this.list.add(new StringBuilder()) ;
    }

    /**
     * Constructor with a list provided, will be used by ConcreteMember to make a copy of the original object.
     * @param list - a list of StringBuilders
     */
    public UndoableStringBuilder(ArrayList<java.lang.StringBuilder> list) {
        this.list = list;
    }

    public java.lang.StringBuilder getLastItem() {
            int lastIndex = list.size() - 1;
            if (lastIndex < 0) return new java.lang.StringBuilder();
            return new java.lang.StringBuilder(list.get(lastIndex));
        }

        /**
         * Appends the specified string to this character sequence.
         * @param str the String
         */
        public void append(String str) {
            java.lang.StringBuilder item = getLastItem();
            item.append(str);
            list.add(item);
        }

        /**
         * Removes the characters in a substring of this sequence. The substring begins
         * at the specified start and extends to the character at index
         * end - 1 or to the end of the sequence if no such character exists.
         * If start is equal to end, no changes are made.
         * @param start - The beginning index, inclusive
         * @param end - The ending index, exclusive.
         */
        public void delete(int start, int end) {
            try {
                java.lang.StringBuilder item = getLastItem();
                item.delete(start, end);
                list.add(item);
            }
            catch (Exception e) {
                throw new StringIndexOutOfBoundsException("Error: the offset isn't exist.");
            }
        }

        /**
         * Inserts the string into this character sequence.
         * @param offset– the offset
         * @param str-the str
         */

        public void insert(int offset, String str){
            try {
                java.lang.StringBuilder item = getLastItem();
                item.insert(offset, str);
                list.add(item);
                tempOffset = offset;
            }
            catch (Exception e) {
                throw new StringIndexOutOfBoundsException("Error: the offset isn't exist.");
            }
        }

        /**
         * Replaces the characters in a substring of this sequence with characters in
         * the specified String. The substring begins at the specified start and
         * extends to the character at index end - 1 or to the end of the sequence if
         * no such character exists. First the characters in the substring are removed
         * and then the specified String is inserted at start. (This sequence will be
         * lengthened to accommodate the specified String if necessary).
         * @param start– The beginning index, inclusive
         * @param end– The ending index, exclusive.
         * @param str – String that will replace previous contents
         */
        public void replace(int start, int end, String str){
            try {
                java.lang.StringBuilder item = getLastItem();
                item.replace(start, end, str);
                list.add(item);
            }
            catch (Exception e) {
                throw new StringIndexOutOfBoundsException("Error: the offset isn't exist.");
            }
        }
        /**
         * Causes this character sequence to be replaced by the reverse of the
         * sequence.
         */
        public void reverse() {
            java.lang.StringBuilder item = getLastItem();
            item.reverse();
            list.add(item);
        }

        /**
         * This method undo the previous operation
         */
        public void undo() {
            try {
                int lastIndex = list.size() - 1;
                list.remove(lastIndex);
            }
            catch (Exception e) {
                throw new IndexOutOfBoundsException("Error: cannot undo to empty list.");
            }
        }


    public void setList(ArrayList<StringBuilder> list) {
        this.list = list;
    }

    public String toString() {
            return getLastItem().toString();
        }
    }