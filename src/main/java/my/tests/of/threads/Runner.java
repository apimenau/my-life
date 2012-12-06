package my.tests.of.threads;

import java.util.Map;
import java.util.UUID;
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
        String name1 = UUID.randomUUID().toString();
        Thread t1 = pusk("1", name1);
        String name2 = UUID.randomUUID().toString();
        Thread t2 = pusk("2", name2);
        String name3 = UUID.randomUUID().toString();
        Thread t3 = pusk("3", name3);
        Thread.sleep(1100);
        accessible.put(name1, false);
        System.out.println("end1");
        Thread.sleep(1100);
        accessible.put(name2, false);
        System.out.println("end2");
    }

    private static Thread pusk(String zu, String name) {
        Thread t = new Thread(new MyTimer(zu, name), name);
        accessible.put(t.getName(), Boolean.TRUE);
        t.start();
        return t;
    }
}
