package com.fanhf.javastudy.atomic;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-10 10:42
 */
import java.util.concurrent.TimeUnit;

public class MonkeysWorker implements Runnable {
    private static boolean exists = false;
    private String name;

    public MonkeysWorker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (!exists) {
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException var3) {
            }

            exists = true;
            System.out.println(this.name + ":俺来了...");

            try {
                System.out.println(this.name + " 吃俺老孙一棒...");
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException var2) {
            }

            System.out.println(this.name + " 俺老孙去也...");
            exists = false;
        } else {
            System.out.println(this.name + " 俺干不了...");
        }

    }

    public static void main(String[] args) {
        MonkeysWorker monkeysWorker1 = new MonkeysWorker("monkeysWorker1");
        MonkeysWorker monkeysWorker2 = new MonkeysWorker("monkeysWorker2");
        MonkeysWorker monkeysWorker3 = new MonkeysWorker("monkeysWorker3");
        (new Thread(monkeysWorker1)).start();
        (new Thread(monkeysWorker2)).start();
        (new Thread(monkeysWorker3)).start();
    }
}
