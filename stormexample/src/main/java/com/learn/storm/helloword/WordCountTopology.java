package com.learn.storm.helloword;

import com.learn.storm.helloword.bolt.PrintBolt;
import com.learn.storm.helloword.bolt.WordCountBolt;
import com.learn.storm.helloword.bolt.WordNormailzerBolt;
import com.learn.storm.helloword.spout.RandomSentenceSpout;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

/**
 * Created by nick on 2017/11/12.
 */
public class WordCountTopology {

    private static TopologyBuilder builder = new TopologyBuilder();

    public static void main(String[] args) {

        Config config = new Config();

        builder.setSpout("RandomSentence", new RandomSentenceSpout(), 2);
        builder.setBolt("WordNormalizer", new WordNormailzerBolt(), 2).shuffleGrouping("RandomSentence");
        builder.setBolt("WordCount", new WordCountBolt(), 2).fieldsGrouping("WordNormalizer",
                new Fields("word"));
        builder.setBolt("Print", new PrintBolt(), 1).shuffleGrouping(
                "WordCount");

        config.setDebug(true);

        config.setMaxTaskParallelism(1);
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("wordcount", config, builder.createTopology());

    }
}
