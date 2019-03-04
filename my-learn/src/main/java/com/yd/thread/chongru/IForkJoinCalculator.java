package com.yd.thread.chongru;

import java.util.Map;
import java.util.concurrent.RecursiveTask;

/**
 * Created by nick on 2019/1/8.
 *
 * @author nick
 * @date 2019/1/8
 */
public abstract class IForkJoinCalculator extends RecursiveTask {

    private Map<String, ?> context;

    public IForkJoinCalculator(Map<String, ?> context) {
        this.context = context;
    }

    public Map<String, ?> getContext() {
        return context;
    }

    public void setContext(Map<String, ?> context) {
        this.context = context;
    }

}