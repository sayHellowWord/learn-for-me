package com.xiaowo.elasticsearch.test;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/27.
 */
public class CreateTest {

    public static void main(String[] args) throws IOException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.2.157"), 9300));

        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("user", "kimi").field("postDate", new Date()).
                field("message", "Elasticsearch Create").field("author","guojingming").endObject();

        IndexResponse response = client.prepareIndex("twitter", "tweet", "4")
                .setSource(builder).get();

        System.out.println( response.toString());

    }

}
