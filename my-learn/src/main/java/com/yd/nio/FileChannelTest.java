package com.yd.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.stream.Stream;

/**
 * Created by nick on 2018/8/5.
 *
 * @author nick
 * @date 2018/8/5
 */
public class FileChannelTest {

    public static void main(String[] args) throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("/Users/nick/learttestdata/filechannel.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);

        Stream.of(buf.array()).forEach(p -> System.out.println(p));


    }
}
