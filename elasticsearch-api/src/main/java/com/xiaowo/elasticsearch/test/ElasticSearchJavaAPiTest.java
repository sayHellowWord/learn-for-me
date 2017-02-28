package com.xiaowo.elasticsearch.test;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * elasticSearch java api 操作练习
 */
public class ElasticSearchJavaAPiTest {

    public static void main(String[] args) throws UnknownHostException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.2.157"), 9300));

        //存储+返回
    /*    String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";

        IndexResponse response = client.prepareIndex("twitter", "tweet")
                .setSource(json)
                .get();
        // Index name
        String _index = response.getIndex();
        System.out.println("_index: " + _index);
        // Type name
        String _type = response.getType();
        System.out.println("_type: " + _index);
        // Document ID (generated or not)
        String _id = response.getId();
        System.out.println("_id: " + _id);
        // Version (if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();
        System.out.println("_version: " + _version);
        // status has stored current instance statement.
        RestStatus status = response.status();
        System.out.println("status: " + status.toString());*/

        GetResponse response = client.prepareGet("twitter", "tweet", "AVp9qaqAZRobjgf0XtPy").get();
        String source = response.getSourceAsString();
        System.out.println("source : " + source);
    }

}
