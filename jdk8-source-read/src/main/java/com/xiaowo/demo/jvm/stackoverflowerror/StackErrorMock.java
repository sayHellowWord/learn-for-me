package com.xiaowo.demo.jvm.stackoverflowerror;

/**
 * Created by nick on 2019/3/25.
 *
 * @author nick
 * @date 2019/3/25
 */
public class StackErrorMock {

    private static int index = 1;

    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        } catch (Throwable e) {
            System.out.println("Stack deep : " + index);
            e.printStackTrace();
        }
    }

}
