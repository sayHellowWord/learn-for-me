package com.yd.jdk7.newio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by nick on 2017/11/7.
 */
public class PathTest {

    public static void main(String[] args) throws IOException {

      /*  Path ptah = Paths.get("/Users/nick/Documents/pathTest/path01.txt");

        System.out.println(ptah.getFileName());
        System.out.println(ptah.getNameCount());
        System.out.println(ptah.getParent());
        System.out.println(ptah.subpath(0,5));
        */
        Path path = Paths.get("./01.txt");
        System.out.println(path.normalize().toAbsolutePath().toString());
    }

}
