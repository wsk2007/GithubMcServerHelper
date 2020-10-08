package com.wangshengkai.gmcs;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Console;

import java.io.*;

/**
 * 本类负责输出信息
 * @author wsk2007
 */
public class DataPrinter extends Thread{
    /**
     * 输入流
     */
    private InputStream inputStream;
    /**
     * 输入流
     */
    private InputStream errorStream;

    public DataPrinter(InputStream inputStream, InputStream errorStream) {
        this.inputStream = inputStream;
        this.errorStream = errorStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getErrorStream() {
        return errorStream;
    }

    public void setErrorStream(InputStream errorStream) {
        this.errorStream = errorStream;
    }

    @Override
    public void run() {
        BufferedReader in = IoUtil.getUtf8Reader(inputStream);
        BufferedReader err = IoUtil.getUtf8Reader(errorStream);
        try{
            while(in.ready() && err.ready()){
                Console.print(in.readLine());
                Console.error(err.readLine());
            }
        }catch (IOException e) {

        }
    }
}
