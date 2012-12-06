package my.life.entity;

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
public class TimerTest {

    Timer t = Timer.getInstance();

    private void stopTimer() {
        t.stopIt();
        pause();
    }

    private void pause() {
        try {
            Thread.sleep(2 * t.getInterval());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createInstance() {
        assertNotNull(t);
    }

    @Test
    public void getTime() {
        long time = t.getTime();
        assertTrue(time == 0);
    }

    @Test
    public void started() {
        assertFalse(t.isStarted());
    }

    @Test
    public void startIt() {
        t.startIt();
        assertTrue(t.isStarted());
    }

    @Test
    public void stopIt() {
        t.startIt();
        stopTimer();
        assertFalse(t.isStarted());
    }

    @Test
    public void tickAddOne() {
        stopTimer();
        long time = t.getTime();
        t.tick();
        assertTrue(t.getTime() - time == 1);
    }

    @Test
    public void seeInterval() {
        assertTrue(t.getInterval() > 0);
    }

    @Test
    public void setInterval() {
        int i = 100;
        t.setInterval(i);
        assertTrue(t.getInterval() == i);
    }

    @Test
    public void tryToSetWrongInterval() {
        int i = -100;
        t.setInterval(i);
        assertTrue(t.getInterval() != i);
        i = 0;
        t.setInterval(i);
        assertTrue(t.getInterval() != i);
    }

    @Test
    public void getStopTime() {
        assertTrue(t.getStopTime() > -2);
    }

    @Test
    public void setStopTime() {
        long stopTime = 10l;
        t.setStopTime(stopTime);
        assertTrue(t.getStopTime() == stopTime);
    }

    @Test
    public void runTimer() {
        stopTimer();
        System.out.println(t.getTime());
        long timeToStop = t.getTime() + 5;
        t.setStopTime(timeToStop);
        t.setInterval(10);
        t.startIt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getTime());
        assertTrue(t.getTime() == timeToStop);
    }
}
