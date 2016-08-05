package com.leopold.zkTest;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by lpyang on 2016/8/5.
 */
public class TestConnection {
    //超时时间
    private static final int ZK_SESSION_TIME_OUT = 5*1000;
    //zk连接
    private static final String ZK_URL = "123.207.142.184:2181";
    /**
     * 获取zk连接
     */
    public void getZkConn(){
        try {
            ZooKeeper zk = new ZooKeeper(ZK_URL,ZK_SESSION_TIME_OUT,new ZkWatcher());
            System.out.println(zk.getState());
            ZkWatcher.connectedSemaphore.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Zookeeper session established");
        }
    }
}
