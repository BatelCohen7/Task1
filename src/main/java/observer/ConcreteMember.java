package observer;

public class ConcreteMember implements Member {


    public UndoableStringBuilder copy;
    private String name;

    /**
     * Constructor - initialize the UndoableStringBuilder to null.
     */
    public ConcreteMember() {
        this.copy = new UndoableStringBuilder(null);
    }

    /**
     * Getter of the name.
     * @return String of the name of the member.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter of the name.
     * @param name - name of the member.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Update will be called from the observable, and will be used for notify the member
     * and will create an updated UndoableStringBuilder by the parameter provided.
     * @param usb - the original UndoableStringBuilder.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.copy = new UndoableStringBuilder(usb.getList());
    }

    @Override
    public String toString() {
        return "ConcreteMember{" +
                "copy=" + copy +
                '}';
    }
}
