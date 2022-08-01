package cn.lishiyu.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestScatteringReads {
    public static void main(String[] args) throws FileNotFoundException {
        //分散读
        //使用以下方式读取，可以将数据填充至多个buffer
        try(RandomAccessFile file = new RandomAccessFile("data.txt","rw")){
            FileChannel channel = file.getChannel();
            ByteBuffer a = ByteBuffer.allocate(3);
            ByteBuffer b = ByteBuffer.allocate(3);
            ByteBuffer c = ByteBuffer.allocate(5);
            channel.read(new ByteBuffer[]{a, b, c});
            a.flip();
            b.flip();
            c.flip();

            ByteBufferUtils.debugAll(a);
            ByteBufferUtils.debugAll(b);
            ByteBufferUtils.debugAll(c);
        } catch (IOException e){

        }
    }
}
