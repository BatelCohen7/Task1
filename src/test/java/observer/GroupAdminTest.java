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
        }

        @Test
        public void testUpdate() {
            GroupAdmin admin = new GroupAdmin();
            ConcreteMember member = new ConcreteMember();
            admin.register(member);
            admin.append("Hello");
            assertEquals("Hello", member.copy.getLastItem().toString());
        }

        @Test
        public void testInsert() {
            GroupAdmin admin = new GroupAdmin();
            ConcreteMember member = new ConcreteMember();
            admin.register(member);
            admin.insert(0, "Hello");
            assertEquals("Hello", member.copy.getLastItem().toString());
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
    }
}