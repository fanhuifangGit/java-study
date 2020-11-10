package com.fanhf.javastudy.performances;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-10 10:43
 */
public class Bytes {
    public Bytes() {
    }

    public static String substring(String src, int start_idx, int end_idx) {
        byte[] b = src.trim().getBytes();
        String tgt = "";

        for(int i = start_idx; i <= end_idx; ++i) {
            tgt = tgt + (char)b[i];
        }

        return tgt;
    }
}
