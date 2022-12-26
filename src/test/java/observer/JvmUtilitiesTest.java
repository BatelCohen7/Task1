package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JvmUtilitiesTest {

    @Test
    public void testJvmInfo() {
        String jvmInfo = JvmUtilities.jvmInfo();
        assertTrue(jvmInfo.contains("PID="));
        assertTrue(jvmInfo.contains("Total Memory="));
        assertTrue(jvmInfo.contains("Available Cores="));
    }

    @Test
    public void testObjectFootprint() {
        Object obj = new Object();
        String objectFootprint = JvmUtilities.objectFootprint(obj);
        assertTrue(objectFootprint.contains("Address="));
    }

    @Test
    public void testObjectTotalSize() {
        Object obj = new Object();
        String objectTotalSize = JvmUtilities.objectTotalSize(obj);
        assertTrue(objectTotalSize.contains("Total Memory="));
    }

    @Test
    public void testMemoryStats() {
        Object obj = new Object();
        String memoryStats = JvmUtilities.memoryStats(obj);
        assertTrue(memoryStats.contains("Total Memory="));
        assertTrue(memoryStats.contains("Address="));
    }
}