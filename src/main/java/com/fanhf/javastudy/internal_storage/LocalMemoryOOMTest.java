package com.fanhf.javastudy.internal_storage;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * @author fanhf
 * @Description 本地内存的OOM， java.lang.OutOfMemoryError: Direct buffer memory
 * @date 2020-12-17 16:26
 */
public class LocalMemoryOOMTest {
    private static final int BUFFER = 1024 * 1024 * 20;//20M

    public static void main(String[] args) {
        ArrayList<ByteBuffer> bufferList = new ArrayList<ByteBuffer>();
        int count = 0;
        while (true){
            ByteBuffer bf = ByteBuffer.allocateDirect(BUFFER);
            bufferList.add(bf);
            count++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(count);
            }
        }
    }
}
