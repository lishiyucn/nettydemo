package cn.lishiyu.buffer;

import io.netty.buffer.ByteBufUtil;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestbyteBufferString {
    public static void main(String[] args) {
        //1.字符串转为 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes(StandardCharsets.UTF_8));
        ByteBufferUtils.debugAll(buffer);

        //2. Charset //自动切换到读模式
        ByteBuffer buffer2 = StandardCharsets.UTF_8.encode("hello");
        ByteBufferUtils.debugAll(buffer2);

        //3. wrap方法
        ByteBuffer buffer3 = ByteBuffer.wrap("hello".getBytes());
        ByteBufferUtils.debugAll(buffer3);

        String str1 = StandardCharsets.UTF_8.decode(buffer2).toString();
        System.out.println(str1);

        //buffer需要切换到读模式才能转
        buffer.flip();
        String str2 = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println(str2);

    }
}
