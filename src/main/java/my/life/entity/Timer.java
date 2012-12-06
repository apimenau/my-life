package my.life.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Andrei_Pimenau
 * Date: 3.12.12
 * Time: 8.59
 * To change this template use File | Settings | File Templates.
 */
public class Timer implements Runnable {

    private static final Timer instance = new Timer();
    private static Thread ticker;

    private long time = 0l;
    private static boolean started = false;
    private static boolean pendingStop = false;
    private int interval = 500;
    private long stopTime = -1l;

    private Timer() {
    }

    public static Timer getInstance() {
        return instance;
    }

    public long getTime() {
        return time;
    }

    public boolean isStarted() {
        return started;
    }

    public void startIt() {
        if (started) {
            System.out.println("already started.");
        } else {
            started = true;
            while (pendingStop) {
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ticker = new Thread(instance);
            ticker.start();
        }
    }

    public void stopIt() {
        if (started && !pendingStop) {
            pendingStop = true;
        }
    }

    public void tick() {
        System.out.println(time + ": tick");
        time++;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        if (interval > 0) {
            this.interval = interval;
        }
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }


    @Override
    public void run() {
        while (started && !pendingStop && notOvertimed()) {
            tick();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        started = false;
        pendingStop = false;
    }

    private boolean notOvertimed() {
        if (stopTime > 0) {
            return time < stopTime;
        } else {
            return true;
        }
    }
}
