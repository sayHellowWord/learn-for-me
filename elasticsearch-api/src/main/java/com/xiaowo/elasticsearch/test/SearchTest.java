package com.xiaowo.elasticsearch.test;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/27.
 */
public class SearchTest {

    public static void main(String[] args) throws UnknownHostException {

        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.2.157"), 9300));

//        SearchResponse response = client.prepareSearch("twitter").get();

        // MatchAll on the whole cluster with all default options
     /*   SearchResponse response = client.prepareSearch().get();
        SearchHits searchHits = response.getHits();
        System.out.println("searchHits : " + searchHits.totalHits());*/

        SearchResponse response = client.prepareSearch("megacorp")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery("about", "cabinets"))
                .setPostFilter(QueryBuilders.rangeQuery("age").from(1).to(100))     // Filter
                .setFrom(0).setSize(20).setExplain(true)
                .get();
        SearchHits searchHits = response.getHits();
        System.out.println("searchHits : " + searchHits.totalHits());
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        System.out.println("========================================================");

        response = client.prepareSearch("megacorp")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
               // .setQuery(QueryBuilders.multiMatchQuery("Smith", "about", "last_name"  ))
                .setQuery(QueryBuilders.matchQuery("about", "love like"))
                .get();
        searchHits = response.getHits();
        System.out.println("searchHits : " + searchHits.totalHits());
        hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }


    }
}
