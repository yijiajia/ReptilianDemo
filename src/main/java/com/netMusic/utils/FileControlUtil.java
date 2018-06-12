package com.netMusic.utils;

import java.io.*;

/**
 * 文件控制类
 */
public class FileControlUtil {

    /**
     * 读取文本内容
     * fileName:文本路径
     */
    public static void readFileContent(String fileName){

        try {
            InputStream is = new FileInputStream(fileName);
            Reader reader = new InputStreamReader(is);
            int tempchar = 0;
            while((tempchar=reader.read())!=-1){
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }


//            byte[] b = new byte[100000];
//            int i = 0;
//            int index=0;
//
//            while((i=is.read())!=-1){
//                b[index++]=(byte)i;
//            }
//
//            System.out.println(new String(b));
            is.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args){

        String fileName = "D:\\Code\\idea\\project\\Reptilian\\test.txt";
        readFileContent(fileName);

    }

}
