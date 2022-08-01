package cn.lishiyu.buffer;

import java.nio.ByteBuffer;

public class TestByteBufferExam {
    public static void main(String[] args) {
        //粘包，半包
        ByteBuffer source = ByteBuffer.allocate(48);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);
    }
    private static void split(ByteBuffer source){
        source.flip();
        for (int i = 0; i < source.limit(); i++){
            //找到一条完整的信息
            if(source.get(i) == '\n'){
                int length = i + 1 - source.position();
                //把这条完整的信息存入新的ByteBuffer
                ByteBuffer target = ByteBuffer.allocate(length);
                //从source读，向target写
                for (int j = 0; j < length; j++){
                    target.put(source.get());
                }
                ByteBufferUtils.debugAll(target);
            }
        }
        source.compact();
    }
}
