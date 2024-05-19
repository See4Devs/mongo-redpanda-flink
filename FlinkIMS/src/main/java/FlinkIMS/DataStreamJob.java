// package FlinkIMS;
 
// import org.apache.flink.connector.kafka.sink.KafkaSink;
// import org.apache.flink.connector.kafka.source.KafkaSource;
// import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
// import org.apache.flink.streaming.api.datastream.DataStream;
// import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
// import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
// import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchemaBuilder;
// import org.apache.kafka.clients.producer.ProducerConfig;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.apache.flink.api.common.eventtime.WatermarkStrategy;
// import org.apache.flink.api.common.functions.MapFunction;
// import org.apache.flink.api.common.serialization.SimpleStringSchema;

// import java.util.Properties;

// public class DataStreamJob {
//     public static void main(String[] args) throws Exception {
//         final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

//         // Kafka broker addresses
//         final String bootstrapServers = "redpanda-0:9092,redpanda-1:9092,redpanda-2:9092";
//         final String productTopic = "e-inventory.products";
//         final String outputTopic = "processed-products";

//         KafkaSource<String> source = KafkaSource.<String>builder()
//                 .setBootstrapServers(bootstrapServers)
//                 .setTopics(productTopic)
//                 .setGroupId("e-ims-group")
//                 .setStartingOffsets(OffsetsInitializer.earliest())
//                 .setValueOnlyDeserializer(new SimpleStringSchema())
//                 .build();

//         DataStream<String> cdcStream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka source");

//         // Transform JSON messages to Product objects
//         DataStream<Product> productStream = cdcStream.map(new MapFunction<String, Product>() {
//             @Override
//             public Product map(String message) throws Exception {
//                 ObjectMapper objectMapper = new ObjectMapper();
//                 JsonNode jsonNode = objectMapper.readTree(message);
//                 JsonNode fullDocumentNode = jsonNode.get("fullDocument");
//                 return objectMapper.treeToValue(fullDocumentNode, Product.class);
//             }
//         });

//         // Convert Product objects back to JSON strings
//         DataStream<String> jsonStringStream = productStream.map(product -> {
//             ObjectMapper objectMapper = new ObjectMapper();
//             return objectMapper.writeValueAsString(product);
//         });

//         // Configure Kafka Sink
//         Properties properties = new Properties();
//         properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

//         KafkaSink<String> sink = KafkaSink.<String>builder()
//                 .setBootstrapServers(bootstrapServers)
//                 .setRecordSerializer(KafkaRecordSerializationSchema.builder()
//                         .setTopic(outputTopic)
//                         .setValueSerializationSchema(new SimpleStringSchema())
//                         .build())
//                 .setKafkaProducerConfig(properties)
//                 .build();

//         jsonStringStream.sinkTo(sink);

//         env.execute("Flink Kafka Source Example");
//     }
// }


package FlinkIMS;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class DataStreamJob {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Kafka broker addresses
        final String bootstrapServers = "redpanda-0:9092,redpanda-1:9092,redpanda-2:9092";
        final String productTopic = "e-inventory.products";

        KafkaSource<Product> source = KafkaSource.<Product>builder()
                .setBootstrapServers(bootstrapServers)
                .setTopics(productTopic)
                .setGroupId("e-ims-group")
                .setStartingOffsets(OffsetsInitializer.earliest())
                .setValueOnlyDeserializer(new JSONDeserializer())
                .build();

        DataStream<Product> productStream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka source");

        productStream.print();

        env.execute("Flink Kafka Source Example");
    }
}





