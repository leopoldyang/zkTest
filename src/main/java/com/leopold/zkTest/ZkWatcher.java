package com.leopold.zkTest;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lpyang on 2016/8/5.
 */
public class ZkWatcher implements Watcher {
    public static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    @Override
    public void process(WatchedEvent event) {
        System.out.println("Receive watched event: " + event);
        if(Event.KeeperState.SyncConnected == event.getState()){
            connectedSemaphore.countDown();
        }
    }
}
