package Basic;

import java.io.*;

public class TestFile {
    public static void main(String[] args) {
//        File f1 = new File("D:/L/L");
//        try {
//            f1.getParentFile().mkdirs();
//            f1.createNewFile();
//            FileInputStream fis = new FileInputStream(f1);
//            DataInputStream dis = new DataInputStream(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(f1.delete());
//        File f2 = new File("D:/L.txt");
//        try (FileInputStream fis1 = new FileInputStream(f1); FileInputStream fis2 = new FileInputSStream(f2)) {
//
//        }
//        catch (IOException e) {
//
//        }
//        byte[] bs = new byte[3];
//        bs[0] = (byte)0xe5;
//        bs[1] = (byte)0xb1;
//        bs[2] = (byte)0x8c;
//        String str;
//        try {
//            str = new String(bs, "UTF-8");
//            System.out.println(str);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        copyFile("D:/test.txt", "D:/test2.txt");
    }
    public static void copyFile(String srcFile, String destFile) {
        File s = new File(srcFile), d = new File(destFile);
        if (!s.exists()) {
            System.out.println("File not exist");
            return;
        }
        if (!s.isFile()) {
            System.out.println("Not a file");
        }
        if (!d.exists()) {
            d.getParentFile().mkdirs();
        }
        try {
            d.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream(s); FileOutputStream fos = new FileOutputStream(d);
             BufferedInputStream bis = new BufferedInputStream(fis); BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] tmp = bis.readAllBytes();
            fos.write(tmp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
