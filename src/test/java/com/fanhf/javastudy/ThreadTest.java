package com.fanhf.javastudy;

/**
 * @author fanhf
 * @Description 为什么每次我们都习惯调用 start() 方法，为什么不直接调用 run() 方法来启动线程呢？
 * @date 2020-12-17 17:28
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.thread2Test();
//        threadTest.thread22Test();
//        threadTest.thread3Test();
    }

    public void thread2Test(){
        //2个线程，一个main，一个thread-0
        Thread thread = new Thread(
                () -> {
                    System.out.printf("Run begin another , 当前线程 : %s.%n" ,Thread.currentThread().getName());
                }
        );
        thread.start();
        //如果执行在把start方法再执行一遍就会报错，Exception in thread "main" java.lang.IllegalThreadStateException

        //Thread的704行的代码
        // if (threadStatus != 0)
        //            throw new IllegalThreadStateException();
        thread.start();
        /**
         * 输出结果：
         * Run begin another , 当前线程 : Thread-0.  thread2Test打印
         **/

    }

    public void thread22Test(){
        Thread thread = new Thread(
                () -> {
                    System.out.printf("Run begin another , 当前线程 : %s.%n" ,Thread.currentThread().getName());
                }
        );
        thread.start();
        //当开启了这个之后，线程就运行在了main线程中，并不是自己的线程中，如果是自己的线程，那么此时就会有3个线程，一个main，一个Thread-0，一个Thread-1
        // 而事实上闭关不是，thread.run()执行后是运行在了
        thread.run();
        //Thread的679行-689行的注释
        //Causes this thread to begin execution; the Java Virtual Machine calls the run method of this thread.
        //使该线程开始执行； Java虚拟机调用此线程的run方法

        //The result is that two threads are running concurrently:
        //结果是两个线程同时运行：
        // the current thread (which returns from the call to the start method)
        //当前线程（从调用返回到start方法）
        // and the other thread (which executes it run method).
        //另一个线程（执行它的运行方法）

        //It is never legal to start a thread more than once.
        //多次启动线程永远是不合法的
        //In particular, a thread may not be restarted once it has completed execution.
        //特别是，线程一旦完成执行就可能不会重新启动
//        System.out.printf("Run begin , 当前线程 : %s.%n" ,Thread.currentThread().getName());
        /**
         * 输出结果：
         *
         * Run begin another , 当前线程 : main.
         * Run begin , 当前线程 : main.              thread.run()后面吗打印
         * Run begin another , 当前线程 : Thread-0.  Thread-0打印
         *
         * thread.run()执行后输出的是：“Run begin another , 当前线程 : main”，说明是运行在了main线程中
         **/
    }

    public void thread3Test(){
        //3个线程，一个main，一个thread-0，一个thread-1
        Thread thread = new Thread(
                () -> {
                    System.out.printf("Run begin thread , 当前线程 : %s.%n" ,Thread.currentThread().getName());
                }
        );
        thread.start();

        Thread thread1 = new Thread(
                () -> {
                    System.out.printf("Run begin thread1 , 当前线程 : %s.%n" ,Thread.currentThread().getName());
                }
        );
        thread1.start();

        /**
         * 输出结果：
         * Run begin thread , 当前线程 : Thread-0.
         * Run begin thread1 , 当前线程 : Thread-1.
         **/
    }
}   
