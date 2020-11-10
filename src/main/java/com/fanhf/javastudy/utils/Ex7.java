package com.fanhf.javastudy.utils;

import java.io.*;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-10 10:58
 */

public class Ex7 {
    public Ex7() {
    }

    public void dataReader(String nameFile, int start, int finish) {
        if (start > finish) {
            System.out.println("Error start or finish!");
        } else {
            InputStream inputStream = null;
            LineNumberReader reader = null;

            try {
                File file = new File(nameFile);
                inputStream = new FileInputStream(new File(nameFile));
                reader = new LineNumberReader(new InputStreamReader(inputStream));
                int lines = this.getTotalLines(new File(nameFile));
                if (start < 0 || finish < 0 || finish > lines || start > lines) {
                    System.out.println("Line not found!");
                    return;
                }

                String line = reader.readLine();
                lines = 0;
                File newfilename = new File(file.getParent() + File.separator + "new_" + file.getName());
                System.out.println("newfilename:" + newfilename);

                while (line != null) {
                    ++lines;
                    if (lines >= start && lines <= finish) {
                        System.out.println(line);
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newfilename));
                        Throwable var11 = null;

                        try {
                            line = reader.readLine();
                            if (null != line) {
                                bufferedWriter.write(line);
                            }

                            bufferedWriter.close();
                        } catch (Throwable var22) {
                            var11 = var22;
                            throw var22;
                        } finally {
                            if (bufferedWriter != null) {
                                if (var11 != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (Throwable var21) {
                                        var11.addSuppressed(var21);
                                    }
                                } else {
                                    bufferedWriter.close();
                                }
                            }

                        }
                    }
                }

                inputStream.close();
                reader.close();
            } catch (FileNotFoundException var24) {
                var24.printStackTrace();
            } catch (IOException var25) {
                System.err.println("IO Error");
                System.exit(0);
            }

        }
    }

    private int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String line = reader.readLine();

        int lines;
        for (lines = 0; line != null; line = reader.readLine()) {
            ++lines;
        }

        reader.close();
        in.close();
        return lines;
    }

    public static void main(String[] args) {
        (new Ex7()).dataReader("D:\\study\\xiaomi.java", 2, 4);
        (new Ex7()).dataReader("D:\\study\\xiaomi.java", 3, 8);
    }
}