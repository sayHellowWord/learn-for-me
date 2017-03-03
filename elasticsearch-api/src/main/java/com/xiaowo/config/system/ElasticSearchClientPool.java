package com.xiaowo.config.system;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.web.bind.annotation.InitBinder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ES 客户端连接池
 */
public class ElasticSearchClientPool {

    private static volatile int corePoolSiz = 10;//核心池的大小

    private static volatile BlockingQueue<TransportClient> transportClients = new LinkedBlockingQueue(corePoolSiz);

    /**
     * 初始化客户端连接池
     */
    public void init() {
        for (int i = 0; i < corePoolSiz; i++) {
            try {
                TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.2.157"), 9300));
                transportClients.add(client);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 销毁客户端连接池
     */
    public void destory(){

    }


}
