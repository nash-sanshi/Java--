package src.main.java.day17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Seventeen8_UploadPicServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(10008);
        while (true) {
            Socket s = ss.accept();
            new Thread(new UploadPic(s)).start();
        }
        //ss.close();
    }

    public static class UploadPic implements Runnable {
        private final Socket s;
        public UploadPic(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                String ip = s.getInetAddress().getHostAddress();
                System.out.println(ip + "......connected");

                InputStream in = s.getInputStream();
                File dir = new File("D:/java项目/java-learn/src/main/java/day17/pic");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                int count = 1;
                File file = new File(dir, ip + "(" + count + ")" + ".jpg");
                while(file.exists()){
                    file = new File(dir, ip + "(" + ++count + ")" + ".jpg");
                }
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                OutputStream out = s.getOutputStream();
                out.write("上传成功".getBytes());
                fos.close();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
