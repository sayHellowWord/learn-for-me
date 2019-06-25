package com.xiaowo.test;

import org.apache.storm.shade.org.apache.curator.shaded.com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by nick on 2019/6/18.
 *
 * @author nick
 * @date 2019/6/18
 */
public class TraceFactory {

    private Map<String,ITraceService> traceServiceMap = Maps.newHashMap();

    /**
     * 注册业务指标计算处理规则
     *
     */
    public void registryProcessor(ITraceService traceService) {
        traceServiceMap.put(traceService.getPayTrace(),traceService);
    }

    public void calculate(String traceType,Map map) {

        traceServiceMap.get(traceType).doCaculate(map);
    }
}
