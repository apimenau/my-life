package my.tests.of.threads;

/**
 * Created with IntelliJ IDEA.
 * User: Andrei_Pimenau
 * Date: 3.12.12
 * Time: 8.59
 * To change this template use File | Settings | File Templates.
 */
public class MyTimer implements Runnable {

    private String zu;
    private String name;

    public MyTimer(String zu, String name) {
        this.zu = zu;
        this.name = name;
    }

    @Override
    public void run() {
        while (Runner.accessible.get(name)) {
            System.out.print(zu);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
