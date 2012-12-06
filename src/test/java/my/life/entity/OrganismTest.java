package my.life.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Andrei_Pimenau
 * Date: 28.11.12
 * Time: 4.49
 * To change this template use File | Settings | File Templates.
 */
public class OrganismTest {

    @Test
    public void createInstance() {
        Organism o = new Organism();
        assertNotNull(o);
    }

    @Test
    public void instanceId() {
        Organism o = new Organism();
        assertNotNull(o.getId());
    }

    @Test
    public void instanceAlive() {
        Organism o = new Organism();
        assertTrue(o.getAlive());
    }

    @Test
    public void equalsCall() {
        Organism o = new Organism();
        assertTrue(o.equals(o));
        Object nullObj = null;
        assertFalse(o.equals(nullObj));
        assertFalse(o.equals(new Object()));
    }

    @Test
    public void toStringCall() {
        Cell cell = new Cell();
        assertNotNull(cell);
    }

    @Test
    public void hashCodeCall() {
        Cell cell = new Cell();
        assertTrue(cell.hashCode() == cell.hashCode());
    }

    @Test
    public void everyInstanceIsUnique() {
        Organism a = new Organism();
        Organism b = new Organism();
        assertEquals(a, a);
        assertFalse(a.equals(b));
    }
}
