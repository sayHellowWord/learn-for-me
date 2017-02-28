package com.xiaowo.config.system;

/**
 * es 客户端 数据源
 */
public class ElasticSearchClientSource {

    public static ElasticSearchClientPool elasticSearchClientPool;

    static {
        elasticSearchClientPool = new ElasticSearchClientPool();
    }

}
