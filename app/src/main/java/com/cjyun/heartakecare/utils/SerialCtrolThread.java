package com.cjyun.heartakecare.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android_serialport_api.SerialPort;
import android_serialport_api.sendreceive.SerialCtrol;

/**
 * Created by Administrator on 2016/9/5 0005.
 */
public class SerialCtrolThread extends Thread {
    private static final int SERIAL_BAUDRATE = 9600;//串口波动率

    // 2、创建串口操作的实例：
    // private SerialCtrol mSerialCtrol;
    // private SerialPort mSerialPort;
    private boolean tFlag;
    private SerialCtrol mSerialCtrol;
    private SerialPort mSerialPort;


    public SerialCtrolThread() {
        mSerialCtrol = new SerialCtrol();
        try {
            mSerialPort = mSerialCtrol.openSerialPort(SERIAL_BAUDRATE, 3);
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tFlag = true;
    }

    public void stopThread(boolean flag) {
        synchronized (this) {
            this.tFlag = flag;
        }
    }

    @SuppressWarnings("deprecation")
    public void run() {
        // TODO Auto-generated method stub
        super.run();

        while (tFlag) {

            // mSerialCtrol=new
            // SerialCtrol();//此操作直接影响主线程的setInfo（）操作，导致textview内容设置不上
            initSerialCtrol();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private boolean SerialCtrolTag = true;

    private void initSerialCtrol() {
        int size = 0;
        InputStream mInputStream = null;
        OutputStream mOutputStream = null;
        StringBuffer sbf = new StringBuffer();
        String data = null;
        SerialCtrolTag = true;
        try {
            mInputStream = mSerialPort.getInputStream();
            // mOutputStream=mSerialPort.getOutputStream();
            byte[] buffer = new byte[1024];

            if (mInputStream.equals(null) || mInputStream == null)
                return;

            int n = 0;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            n = mInputStream.read(buffer);
            String dataStr = "";
            for (int i = 0; i < n; i++) {
                dataStr += buffer[i] + ",";
            }
            System.out.println("data:" + dataStr);
        } catch (Exception e) {
            return;
        }
    }
}
