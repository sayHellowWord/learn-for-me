package com.yd.zookeeper;

import org.apache.storm.shade.org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by nick on 2017/12/10.
 *
 * @author nick
 * @date 2017/12/10
 */
public class CreateSession {

    private static ZooKeeper zooKeeper;

    public static void main(String[] args) {

        try {
            zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("收到事件:" + watchedEvent);
                    if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {

                        //同步创建
                        String path;
                        try {
                            path = zooKeeper.create("/node_6", "6".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        //异步创建
                        zooKeeper.create("/node_5", "5".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new AsyncCallback.StringCallback() {
                            @Override
                            public void processResult(int i, String s, Object o, String s1) {
                                System.out.println("i = [" + i + "], s = [" + s + "], o = [" + o + "], s1 = [" + s1 + "]");
                            }
                        }, "异步创建");
                    }
                }
            });

            System.out.println(zooKeeper.getState());


            Thread.sleep(Integer.MAX_VALUE);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
