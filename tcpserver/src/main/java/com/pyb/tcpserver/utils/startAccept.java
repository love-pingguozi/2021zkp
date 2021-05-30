package com.pyb.tcpserver.utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pyb
 * @date 2021年05月21日 15:56
 */
public class startAccept extends ServerSocket {
    private static final int SERVER_PORT = 10099;
    private static List thread_list = new ArrayList();// 服务器已启用线程集合
    private static List ip_list = new ArrayList();// Ip地址集合

    public startAccept() throws IOException {
        super(SERVER_PORT);// 创建ServerSocket
        new ListennerSocket();
    }

    private class ListennerSocket extends Thread {
        public ListennerSocket() {
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {// 监听客户端请求，启个线程处理
                    Socket socket = accept();
                    new ServerThread(socket);
                }

            } catch (Exception e) {
            } finally {
                try {
                    close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ServerThread extends Thread {
        private Socket client;
        private DataOutputStream outsend;
        private BufferedReader in;

        public ServerThread(Socket s) {
            try {
                client = s;
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                outsend = new DataOutputStream(client.getOutputStream());
                System.out.println("每个socket连接就会开启了异步线程");
                if(!ip_list.contains(s.getInetAddress().getHostAddress())){
                    ip_list.add(s.getInetAddress().getHostAddress());
                    thread_list.add(this);
                }
                start();
            } catch (Exception e) {

            }
        }

        @Override
        public void run() {
            try {
                String line = null;
                while ((line = in.readLine()) != null) {
                    //消息内容，进行处理
                    System.out.println(line);

                }
            } catch (Exception e) {
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("客户端与本服务器断开连接");
            }
        }

        // 向客户端发送一条消息
        private void sendMessage(String msg) {
            try {
                outsend.writeUTF(msg);
            } catch (IOException e) {

            }
        }

    }

    public static class PrintOutThread extends Thread {
        private String send_ip;//需要发送的目标Ip；
        private String message;

        public PrintOutThread(String ip, String _message) {
            send_ip = ip;
            message = _message;
            start();
        }

        @Override
        public void run() {
            boolean b=true;
            while (true) {//不需要死循环，可以设置标记位不能 
                if (ip_list.contains(send_ip)&&b==true) {
                    int index = ip_list.indexOf(send_ip);
                    ServerThread thread = (ServerThread) thread_list.get(index);
                    thread.sendMessage(message);
                    b=false;
                }
            }
        }

    }


}
