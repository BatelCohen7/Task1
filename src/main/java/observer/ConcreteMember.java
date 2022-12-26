package observer;

public class ConcreteMember implements Member {

    public UndoableStringBuilder copy;
    private String name;

    public ConcreteMember() {
        this.copy = new UndoableStringBuilder(null);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
