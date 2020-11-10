package com.fanhf.javastudy.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-10 10:43
 */

public class MonkeysWorker2 implements Runnable {
    private static AtomicBoolean exists = new AtomicBoolean(false);
    private String name;

    public MonkeysWorker2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (exists.compareAndSet(false, true)) {
            System.out.println(this.name + ":俺来了...");

            try {
                System.out.println(this.name + "：俺独自享受美味...");
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException var2) {
            }

            System.out.println(this.name + "：俺老孙吃完了,去也...");
            exists.set(false);
        } else {
            System.out.println(this.name + "：俺不吃了，走了走了...");
        }

    }

    public static void main(String[] args) {
        MonkeysWorker2 monkeysWorker1 = new MonkeysWorker2("monkeysWorker1");
        MonkeysWorker2 monkeysWorker2 = new MonkeysWorker2("monkeysWorker2");
        MonkeysWorker2 monkeysWorker3 = new MonkeysWorker2("monkeysWorker3");
        (new Thread(monkeysWorker1)).start();
        (new Thread(monkeysWorker2)).start();
        (new Thread(monkeysWorker3)).start();
    }
}
