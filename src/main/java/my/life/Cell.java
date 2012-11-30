package my.life;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Andrei_Pimenau
 * Date: 30.11.12
 * Time: 9.33
 * To change this template use File | Settings | File Templates.
 */
public class Cell {
    private String id = UUID.randomUUID().toString();
    private boolean alive = true;

    public String getId() {
        return id;
    }

    public boolean getAlive() {
        return alive;
    }

    public void kill() {
        this.alive = false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) o;
        return cell.getId() == this.id;
    }

    @Override
    public String toString() {
        return "Cell id=" + this.id;
    }

}
