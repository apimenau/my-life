package my.life.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import my.life.entity.Cell;

/**
 * Created with IntelliJ IDEA.
 * User: Andrei_Pimenau
 * Date: 28.11.12
 * Time: 4.49
 * To change this template use File | Settings | File Templates.
 */
public class CellTest {

    @Test
    public void createInstance() {
        Cell cell = new Cell();
        assertNotNull(cell.getId());
        assertTrue(cell.getAlive());
    }

    @Test
    public void everyInstanceIsUnique() {
        Cell a = new Cell();
        Cell b = new Cell();
        assertFalse(a.equals(b));
        assertTrue(a.equals(a));
    }

    @Test
    public void toStringCall() {
        Cell cell = new Cell();
        assertNotNull(cell);
    }

    @Test
    public void equalsCall() {
        Cell cell = new Cell();
        assertTrue(cell.equals(cell));
        Object nullObj = null;
        assertFalse(cell.equals(nullObj));
        assertFalse(cell.equals(new Object()));
    }

    @Test
    public void hashCodeCall() {
        Cell cell = new Cell();
        assertTrue(cell.hashCode() == cell.hashCode());
    }

    @Test
    public void killCell() {
        Cell cell = new Cell();
        cell.kill();
        assertFalse(cell.getAlive());
    }
}
