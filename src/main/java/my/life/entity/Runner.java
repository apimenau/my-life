package my.life.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Andrei_Pimenau
 * Date: 3.12.12
 * Time: 10.03
 * To change this template use File | Settings | File Templates.
 */
public class Runner {
    public static Map<String, Boolean> accessible = new ConcurrentHashMap<>();

    public static void main(String[] params) throws InterruptedException {
        System.out.println("Welcome!");
        Timer t = Timer.getInstance();
        t.startIt();
        Thread.sleep(2000);
        t.stopIt();
        Thread.sleep(1000);
        t.startIt();
        t.stopIt();
    }

}
