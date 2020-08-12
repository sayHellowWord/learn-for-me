package com.xiaowo.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created by nick on 2019/6/25.
 *
 * @author nick
 * @date 2019/6/25
 */
public class KafkaProducerDemo {

    public static final String topic = "topic-demo";

    public static void main(String[] args) {

        //构造初始化客户端所需要的配置
        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "master:9092,slave1:9092,slave2:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        //retries:重试次数，kafka异常分为可重试异常和不可重试异常
        //重试异常：NetworkException、LeaderNotAvaliableException、UnknowTopicOrPartionException、NotEnoughReplicasException、NotCoordinatorException
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        try (//初始化生产者客户端,KafkaProducer是线程安全
             KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props)) {

            //构造一个消息体
            ProducerRecord record = new ProducerRecord<String, String>(topic, "key", "message info");
            //发送消息体
            Future<RecordMetadata> future = producer.send(record);
            producer.send(record, new Callback() {

                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {

                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
