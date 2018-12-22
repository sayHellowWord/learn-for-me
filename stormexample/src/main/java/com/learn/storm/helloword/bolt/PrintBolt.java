package com.learn.storm.helloword.bolt;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

/**
 * Created by nick on 2017/11/12.
 */
public class PrintBolt extends BaseBasicBolt {

    public void execute(Tuple input, BasicOutputCollector collector) {
        try {
            String mesg = input.getString(0);
            if (mesg != null) {
                System.out.println(mesg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }
}