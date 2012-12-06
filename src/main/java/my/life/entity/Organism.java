package my.life.entity;

import java.util.UUID;

/**
 * Организм.
 * Created with IntelliJ IDEA.
 * User: Andrei_Pimenau
 * Date: 30.11.12
 * Time: 10.18
 * To change this template use File | Settings | File Templates.
 */
public class Organism {
    private Object id = UUID.randomUUID().toString();
    private boolean alive = true;

    public Object getId() {
        return id;
    }

    public boolean getAlive() {
        return alive;
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
        return "Organism id=" + this.id;
    }
}
