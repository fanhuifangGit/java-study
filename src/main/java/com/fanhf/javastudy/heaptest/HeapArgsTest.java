package com.fanhf.javastudy.heaptest;

/**
 * @author fanhf
 * @Description 堆参数
 *
 * -XX:+PrintFlagsInitial ：查看所有的参数的默认初始值
 * 也可以在cmd中执行：java -XX:+PrintFlagsInitial  显示所有默认初始值
 * -XX:+PrintFlagsFinal ：查看所有的参数的最终值（可能会存在修改，不再是初始值）
 * 例如配置： -XX:+PrintFlagsFinal -XX:SurvivorRatio=6
 * 输出：
 *  uintx SurvivorRatio                            := 6                                   {product}
 *  = 6 的前面有个”:“ ,就说明值有修改
 *  另外：
 *     具体cmd查看某个参数的指令：jps：查看当前运行中的进程
 *                        jinfo -flag SuvivorRatio [pid]
 *     输出：-XX:SurvivorRatio=6
 * -Xms: 初始堆空间内存（默认为物理内存的1/64）
 * -Xmx: 最大堆空间内存（默认为物理内存的1/4）
 * -Xmn: 设置新生代的大小。（初始值及最大值）
 * -XX:NewRatio：配置新生代与老年代在堆结构的占比
 *
 * =============================================================
 * -XX:NewRatio=2 说明：新生代占1，老年代占2，即新生代占1/3，老年代占2/3
 * 如果比例设置的不合适，
 * 比如：
 *
 * 新生代比较小，老年代比较大，-XX:NewRatio=20
 * 就会频繁的Minor GC，
 *      If the size for the young generation is too low, then a large number of minor GCs will be performed.
 *      (https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html)
 *     -----------------------------------
 *     |   Eden   |          Old         |
 *     -----------------------------------
 *
 * 如果eden区比较小，survivor比较大
 * 就会导致Minor GC被触发的次数比较高，stw的次数也会比较多，从而影响用户进程；
 *
 * *************************************************
 * 新生代比较大，老年代比较小，-XX:NewRatio=1
 * 就会导致 full GC
 *      If the size is too high, then only full GCs will be performed, which can take a long time to complete.
 *      -----------------------------------
 *      |     Eden                |  Old  |
 *      -----------------------------------
 * 官网建议：
 * Oracle recommends that you keep the size for the young generation between a half and a quarter of the overall heap size.
 *  (https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html)
 *
 *  如果eden区比较大，survivor比较小
 *  最理想的状态就是所有的对象放到eden区后都被Minor GC回收了，没有进入survivor区的对象，但这种可能性极低；
 *  如果survivor比较小的话，就导致放的对象比较少，当不断的有新的对象进入eden区，eden区满了之后，Minor GC会将eden区再连同survivor也一起回收，
 *  但在回收后把存活的对象要放到survivor区的时候，就会放不下，就会把对象放到Old区，就会导致Minor GC失去意义，
 *  因为eden区满了之后，还没等对象的age达到15，就过早的进入了Old区，相当于Minor GC只能做一半的工作，确实是做了回收的工作，
 *  但是做的却是没有太多成效的工作，若是survivor不是很小的话，被回收的更多的对象顺利进入survivor区，Minor GC就能节省更多的空间，
 *  换句话说，survivor过小就导致Minor GC的回收的性价比太低，有点出力不讨好的感觉；
 *  另外，过多的对象进入Old区就会导致Major GC，而Major GC会产生更长时间的stw，影响用户进程，而且如果survivor过小，分代的意义也就不大了。
 *
 * ============================================================
 * -XX:SurvivorRatio：设置新生代与中Eden和S0/S1空间的比例
 * -XX:MaxTenuringThreshold：设置新生代垃圾的最大年龄
 * -XX:+PrintGCDetails：输出详细的GC处理日志
 * -XX:HandlePromotionFailure：是否设置空间分配担保
 *
 * @date 2020-12-15 13:48
 */
public class HeapArgsTest {

    public static void main(String[] args) {
        System.out.println("heap args test");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}   
