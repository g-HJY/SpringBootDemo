package com.example.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaConsumer {
    @KafkaListener(topics = "testA")
    /*    @KafkaListener(groupId = "testGroup", topicPartitions = {
            @TopicPartition(topic = "topic1", partitions = {"0", "1"}),
            @TopicPartition(topic = "topic2", partitions = "0",
                    partitionOffsets = @PartitionOffset(partition = "1",
                            initialOffset = "100"))
    },concurrency = "3")//concurrency就是同组下的消费者个数，就是并发消费数，建议⼩于等于分区总数*/
    public void listenGroup(ConsumerRecord<String, String> record,
                            Acknowledgment ack) {
        String value = record.value();
        System.out.println(value);
        System.out.println(record);
        //⼿动提交offset
        ack.acknowledge();
    }
}