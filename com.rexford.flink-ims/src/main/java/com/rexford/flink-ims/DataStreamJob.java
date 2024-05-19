package com.rexford.flinkIMS;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class DataStreamJob {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("group.id", "flink-group");

        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>("inventory-topic", new SimpleStringSchema(), properties);
        consumer.setStartFromEarliest();

        DataStream<String> stream = env.addSource(consumer)
                .assignTimestampsAndWatermarks(WatermarkStrategy.forMonotonousTimestamps());

        stream.print();

        env.execute("Flink Inventory Management System");
    }
}
