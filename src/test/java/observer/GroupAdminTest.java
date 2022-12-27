package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

        @Test
        public void testObserverRegistration() {
            GroupAdmin admin = new GroupAdmin();
            ConcreteMember member1 = new ConcreteMember();
            ConcreteMember member2 = new ConcreteMember();
            admin.register(member1);
            admin.register(member2);
            assertEquals(2, admin.observers.size());
        }

        @Test
        public void testObserverUnregistration() {
            GroupAdmin admin = new GroupAdmin();
            ConcreteMember member1 = new ConcreteMember();
            ConcreteMember member2 = new ConcreteMember();
            admin.register(member1);
            admin.register(member2);
            admin.unregister(member1);
            assertEquals(1, admin.observers.size());
            admin.unregister(member2);
            assertEquals(0, admin.observers.size());
        }

        @Test
        public void testUpdate() {
            GroupAdmin admin = new GroupAdmin();
            ConcreteMember member = new ConcreteMember();
            admin.register(member);
            admin.append("Hello");
            assertEquals("Hello", member.copy.getLastItem().toString());
            admin.delete(0,3);
            assertEquals("lo", member.copy.getLastItem().toString());
            admin.undo();
            assertEquals("Hello", member.copy.getLastItem().toString());
            admin.insert(0, "Hello ");
            assertEquals("Hello Hello", member.copy.getLastItem().toString());
            admin.undo();
            admin.undo();
            admin.undo();
            assertEquals("", member.copy.getLastItem().toString());
        }

        @Test
        public void testInsert() {
            GroupAdmin admin = new GroupAdmin();
            ConcreteMember member = new ConcreteMember();
            admin.register(member);
            admin.insert(0, "Hello");
            assertEquals("Hello", member.copy.getLastItem().toString());
            admin.insert(2,"y He");
            assertEquals("Hey Hello", member.copy.getLastItem().toString());
        }

    @Test
    public void testDelete() {
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member = new ConcreteMember();
        admin.register(member);
        admin.append("Hello");
        admin.delete(0, 5);
        assertEquals("", member.copy.getLastItem().toString());
    }

    @Test
    public void testUndo() {
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member = new ConcreteMember();
        admin.register(member);
        admin.append("Hello");
        admin.insert(2, "y He");
        admin.delete(8,9);
        assertEquals("Hey Hell", member.copy.getLastItem().toString());

        admin.undo();
        assertEquals("Hey Hello", member.copy.getLastItem().toString());
        admin.undo();
        assertEquals("Hello", member.copy.getLastItem().toString());
        admin.undo();
        assertEquals("", member.copy.getLastItem().toString());
    }

    @Test
    public void testNotifyObservers() {
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member = new ConcreteMember();
        admin.register(member);
        admin.append("Hello");
        admin.notifyObservers();
        assertEquals("Hello", member.copy.getLastItem().toString());
        admin.getStatus().setList(null);
        admin.notifyObservers();
        assertNull(member.copy.getList());
    }
}