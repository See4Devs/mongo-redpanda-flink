package FlinkIMS;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;

import java.io.IOException;

public class JSONDeserializer implements DeserializationSchema<Product> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void open(InitializationContext context) throws Exception {
        DeserializationSchema.super.open(context);
    }

    @Override
    public Product deserialize(byte[] bytes) throws IOException {
        if (bytes == null) {
            return null; // Return null or handle the null case as needed
        }
        return mapper.readValue(bytes, Product.class);
    }

    @Override
    public boolean isEndOfStream(Product product) {
        return false;
    }

    @Override
    public TypeInformation<Product> getProducedType() {
        return TypeInformation.of(Product.class);
    }
}
