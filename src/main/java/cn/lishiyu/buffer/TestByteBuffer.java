package cn.lishiyu.buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestByteBuffer {
    public static void main(String[] args) throws FileNotFoundException {
        //FileChannel
        //1.输入输出流 2。RandomAccessFile
      try(FileChannel channel = new FileInputStream("data.txt").getChannel()){
          //准备缓冲区
          //从channel 读取数据，向buffer写入
          ByteBuffer buffer = ByteBuffer.allocate(10);//10个字节的缓冲区
          while (true) {
              int len = channel.read(buffer);
              if(len == -1){
                  break;
              }
              //打印buffer的内容
              buffer.flip();//切换到读模式
              while (buffer.hasRemaining()) {
                  byte b = buffer.get();
                  System.out.println((char) b);
              }
              //buffer切换到写模式
              buffer.clear();
          }
      }catch (IOException e){

      }
    }
}
