package com.fanhf.javastudy.heaptest;

public class TLABTest {
    /**
     * 测试 -XX:UseTLAB 参数是否开启
     * @param args
     *
     *
     *  In JDK 7, interned strings are no longer allocated in the permanent generation of the Java heap,
     *  在JDK 7中，不再在Java堆的永久代中分配interned字符串,
     *  but are instead allocated in the main part of the Java heap (known as the young and old generations),
     *  但分配在Java堆的主要部分中(被称为年轻代和老年代),
     *  along with the other objects created by the application. This change will result in more data residing in the main Java heap,
     *  以及应用程序创建的其他对象。此更改将导致更多数据存在主Java堆中,
     *  and less data in the permanent generation, and thus may require heap sizes to be adjusted.
     * 永久代中的数据较少，因此可能需要调整堆大小.
     *  Most applications will see only relatively small differences in heap usage due to this change,
     * 由于此更改，大多数应用程序只会看到相对较小的堆使用差异,
     *  but larger applications that load many classes or make heavy use of the String.intern() method will see more significant differences.
     *  但是加载了很多类或大量使用String.intern（）方法的大型应用程序将看到更大的不同.
     */
    public static void main(String[] args){
        System.out.println("start...............");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end..............");
    }
}
