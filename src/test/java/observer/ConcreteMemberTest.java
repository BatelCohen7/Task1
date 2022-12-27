package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    public void testName() {
        ConcreteMember member = new ConcreteMember();
        member.setName("John Smith");
        assertEquals("John Smith", member.getName());
    }

    @Test
    public void testUpdate() {
        ConcreteMember member = new ConcreteMember();
        UndoableStringBuilder usb = new UndoableStringBuilder(null);
        usb.append("Hello");
        member.update(usb);
        assertEquals("Hello", member.copy.getLastItem().toString());

        UndoableStringBuilder newUsb = new UndoableStringBuilder(null) ;
        newUsb.append("Undoable String builder has been updated");
        member.update(newUsb);
        assertEquals("Undoable String builder has been updated", member.copy.getLastItem().toString());
    }
}