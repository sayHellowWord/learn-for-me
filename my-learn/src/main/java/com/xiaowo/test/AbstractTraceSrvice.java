package com.xiaowo.test;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by nick on 2019/6/18.
 *
 * @author nick
 * @date 2019/6/18
 */
public abstract class AbstractTraceSrvice implements ITraceService {

    //    @Autowired()
    TraceFactory factory;

    @PostConstruct
    void init() {
        factory.registryProcessor(this);
    }

    @Override
    public String doCaculate(Map map) {
        //"方法1（getModel（））";
        return "";

    }


    public  void getModel(Map map){

    }


    public void getModel1(){

    }

}
