package com.learn.storm.helloword.spout;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;
import java.util.Random;

/**
 * Created by nick on 2017/11/12.
 * 模拟消息源spout
 */
public class RandomSentenceSpout extends BaseRichSpout {

    private  SpoutOutputCollector spoutOutputCollector;
    private  Random random;

    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.spoutOutputCollector = spoutOutputCollector;
        random = new Random();

        System.out.println("=======================================");
    }

    public void nextTuple() {

        try {
            Thread.sleep(2000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String[] sentences = new String[]{
                "jikexueyuan is a good school",
                "And if the golden sun",
                "four score and seven years ago",
                "storm hadoop spark hbase",
                "blogchong is a good man",
                "Would make my whole world bright",
                "blogchong is a good website",
                "storm would have to be with you",
                "Pipe to subprocess seems to be broken No output read",
                " You make me feel so happy",
                "For the moon never beams without bringing me dreams Of the beautiful Annalbel Lee",
                "Who love jikexueyuan and blogchong",
                "blogchong.com is Magic sites",
                "Ko blogchong swayed my leaves and flowers in the sun",
                "You love blogchong.com", "Now I may wither into the truth",
                "That the wind came out of the cloud",
                "at backtype storm utils ShellProcess",
                "Of those who were older than we"};
        // 从sentences数组中，随机获取一条语句，作为这次spout发送的消息
        String sentence = sentences[random.nextInt(sentences.length)];
        // 使用emit方法进行Tuple发布，参数用Values申明
        spoutOutputCollector.emit(new Values(sentence.trim().toLowerCase()));
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word"));
    }
}
