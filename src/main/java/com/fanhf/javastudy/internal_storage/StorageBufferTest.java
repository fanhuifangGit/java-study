package com.fanhf.javastudy.internal_storage;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * @author fanhf
 * @Description 查看直接内存的占用和释放
 * @date 2020-12-17 15:06
 */
public class StorageBufferTest {
    private static final int BUFFER = 1024 * 1024 * 1024;//1GB

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("直接内存分配完毕，请指示！");

        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        System.out.println("开始释放直接内存！");
        byteBuffer = null;
        System.gc();
        scan.next();
    }
}
